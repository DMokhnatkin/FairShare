package com.example.fairshare.auth.signin

import com.hannesdorfmann.mosby3.mvp.MvpView

interface SignInView: MvpView {

    fun showLoginForm()

    fun showError()

    fun showLoading()

    fun loginSuccessful()
}