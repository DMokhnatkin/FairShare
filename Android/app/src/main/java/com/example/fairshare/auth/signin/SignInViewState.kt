package com.example.fairshare.auth.signin

import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState

class SignInViewState: ViewState<SignInView> {
    companion object {
        private const val STATE_SHOW_LOGIN_FORM = 0
        private const val STATE_SHOW_LOADING = 1
        private const val STATE_SHOW_ERROR = 2
    }

    var state = STATE_SHOW_LOGIN_FORM

    fun setShowLoginForm() {
        state = STATE_SHOW_LOGIN_FORM
    }

    fun setShowError() {
        state = STATE_SHOW_ERROR
    }

    fun setShowLoading() {
        state = STATE_SHOW_LOADING
    }

    override fun apply(view: SignInView?, retained: Boolean) {
        when (state) {
            STATE_SHOW_LOADING -> view?.showLoading()

            STATE_SHOW_ERROR -> view?.showError()

            STATE_SHOW_LOGIN_FORM -> view?.showLoginForm()
        }
    }
}