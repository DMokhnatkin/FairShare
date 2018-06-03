package com.example.fairshare.base.view

import android.support.annotation.LayoutRes
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.hannesdorfmann.mosby3.mvp.viewstate.MvpViewStateFragment
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState

abstract class BaseViewStateFragment<V: MvpView, P: MvpPresenter<V>, VS: ViewState<V>>:
        MvpViewStateFragment<V, P, VS>() {

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    /**
     * Inject the dependencies
     */
    protected open fun injectDependencies() { }
}