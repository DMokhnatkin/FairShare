package com.example.fairshare.base.view

import android.app.Fragment
import android.support.annotation.LayoutRes

abstract class BaseFragment: Fragment() {

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    /**
     * Inject the dependencies
     */
    protected open fun injectDependencies() {

    }
}