package com.example.fairshare.auth.signin

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import android.net.Uri
import android.util.Log
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationServiceConfiguration
import net.openid.appauth.ResponseTypeValues
import net.openid.appauth.AuthorizationRequest

class SignInPresenter: MvpBasePresenter<SignInView>() {

    fun doLogin() {
        ifViewAttached { view -> view.showLoading() }
    }

    fun doExternalLogin() {
        ifViewAttached { view -> view.showLoading() }

        // Get configuration from openId
        AuthorizationServiceConfiguration.fetchFromIssuer(
                Uri.parse("https://fs.mokhnatkin.org"),
                { serviceConfiguration, ex -> onServiceConfigFetched(serviceConfiguration, ex) }
        )
    }

    private fun onServiceConfigFetched(serviceConfiguration: AuthorizationServiceConfiguration?, ex: AuthorizationException?) {
        if (serviceConfiguration == null || ex != null) {
            Log.e(javaClass.simpleName, "Can't get oauth2 configuration", ex)
        }

        val authRequestBuilder = AuthorizationRequest.Builder(
            serviceConfiguration!!,
            "client.android",
            ResponseTypeValues.CODE,
            Uri.parse("org.mokhnatkin.fs://oauth2redirect"))

        val authRequest = authRequestBuilder.build()
        ifViewAttached { view -> view.showExternalLogin(authRequest) }
    }


}