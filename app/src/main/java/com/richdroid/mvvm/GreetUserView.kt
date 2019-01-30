package com.richdroid.mvvm

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.fragment_greet_user.view.*
import com.richdroid.mvvm.GreetUserContract.ViewData
import com.richdroid.mvvm.GreetUserContract.ViewActionDelegate

class GreetUserView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr), GreetUserContract.View {

    override fun setDelegate(viewActionDelegate: ViewActionDelegate) {
        viewActionDelegate.run {
            greetButton.setOnClickListener {
                onGreetUserPressed()
            }
            clearButton.setOnClickListener {
                onClearUserPressed()
            }
        }
    }

    override fun setData(viewData: ViewData?) {
        usernameTextView.text = viewData?.userName ?: ""
    }
}