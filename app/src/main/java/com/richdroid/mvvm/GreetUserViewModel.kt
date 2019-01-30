package com.richdroid.mvvm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.richdroid.mvvm.GreetUserContract.ViewData

class GreetUserViewModel : ViewModel(), GreetUserContract.ViewActionDelegate {

    private val viewDataLiveData = MutableLiveData<ViewData>()

    override fun onGreetUserPressed() {
        viewDataLiveData.postValue(ViewData(getUserName()))
    }

    override fun onClearUserPressed() {
        viewDataLiveData.postValue(null)
    }

    private fun getUserName(): String {
        //load user name from db or any other data source
        return "Richa Khanna"
    }

    fun getViewDataLiveData(): LiveData<GreetUserContract.ViewData> = viewDataLiveData
}