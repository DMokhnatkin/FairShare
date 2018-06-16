package com.example.fairshare.auth.signin

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.hannesdorfmann.mosby3.mvp.MvpView
import net.openid.appauth.AuthorizationRequest

interface SignInView: MvpView {

    fun showLoginForm()

    fun showError()

    fun showLoading()

    fun loginSuccessful()

    fun showExternalLogin(request: AuthorizationRequest)

    fun showGoogleSignIn(googleSignInOptions: GoogleSignInOptions)
}