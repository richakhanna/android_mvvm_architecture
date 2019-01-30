package com.richdroid.mvvm

/**
 * We create the contract to interact between View and ViewModel.
 * GreetUserViewModel will implement GreetUserContract.ViewActionDelegate.
 * And, GreetUserView will implement GreetUserContract.View.
 */
interface GreetUserContract {

    interface ViewActionDelegate {
        fun onGreetUserPressed()
        fun onClearUserPressed()
    }

    interface View {
        fun setDelegate(viewActionDelegate: ViewActionDelegate)
        fun setData(viewData: ViewData?)
    }

    data class ViewData(val userName: String)
}