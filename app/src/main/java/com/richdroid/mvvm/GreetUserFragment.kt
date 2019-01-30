package com.richdroid.mvvm

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.richdroid.mvvm.GreetUserContract.ViewData

class GreetUserFragment : Fragment() {

    private lateinit var viewModel: GreetUserViewModel
    private lateinit var contentView: GreetUserContract.View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViewModel(GreetUserViewModel::class.java, this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_greet_user, container, false).apply {
            contentView = (this as GreetUserContract.View).apply {
                setDelegate(viewModel)
            }
        }
    }

    private fun bindViewModel(
            modelClass: Class<out android.arch.lifecycle.ViewModel>,
            lifecycleOwner: LifecycleOwner
    ) {
        viewModel = getViewModelProvider()?.get(modelClass) as GreetUserViewModel

        //We are subscribing to the livedata to listen for the data changes and update the view.
        viewModel.run {
            getViewDataLiveData().observe(lifecycleOwner, Observer<ViewData> { viewData: ViewData? ->
                viewData.let {
                    contentView.setData(viewData)
                }
            })
        }
    }

    //When getting the ViewModelProvider, we are scoping it to the activity, so that viewModel exists until the activity is finished
    //to prevent the loss of data in cases like onConfiguration change.
    private fun getViewModelProvider(): ViewModelProvider? = activity?.let { ViewModelProviders.of(it) }
}
