package com.example.fairshare.auth.signin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.fairshare.R
import com.hannesdorfmann.mosby3.mvp.viewstate.MvpViewStateFragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.view.*
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationResponse
import net.openid.appauth.AuthorizationService

class SignInFragment : MvpViewStateFragment<SignInView, SignInPresenter, SignInViewState>(), SignInView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        view.local_sign_in_button.setOnClickListener { onLocalLoginClicked() }
        view.signin_google.setOnClickListener { onGoogleLoginClicked() }

        return view
    }

    override fun createViewState(): SignInViewState {
        return SignInViewState()
    }

    // Called first time the fragment starts
    override fun onNewViewStateInstance() {
        showLoginForm()
    }

    override fun createPresenter(): SignInPresenter {
        return SignInPresenter()
    }

    fun onLocalLoginClicked() {
        email_login_form.clearAnimation()

        presenter.doLogin()
    }

    fun onGoogleLoginClicked() {
        presenter.doExternalLogin()
    }

    override fun showLoginForm() {
        viewState?.setShowLoginForm()

        setFormEnabled(true)
    }

    override fun showError() {
        viewState?.setShowError()
    }

    override fun showLoading() {
        viewState?.setShowLoading()

        setFormEnabled(false)
    }

    private fun setFormEnabled(isEnabled: Boolean) {
        username.isEnabled = isEnabled
        password.isEnabled = isEnabled
        local_sign_in_button.isEnabled = isEnabled
        signin_google.isEnabled = isEnabled
    }

    override fun loginSuccessful() {

    }

    override fun showExternalLogin(request: AuthorizationRequest) {
        val authService = AuthorizationService(activity!!)
        val authIntent = authService.getAuthorizationRequestIntent(request)
        startActivityForResult(authIntent, RC_EXTERNAL_AUTH)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            RC_EXTERNAL_AUTH -> onExternalLogin(
                    if (data != null) AuthorizationResponse.fromIntent(data) else null,
                    AuthorizationException.fromIntent(data))
        }
    }

    private fun onExternalLogin(response: AuthorizationResponse?, ex: AuthorizationException?) {
        if (response != null) {
            Log.e("1111", "Completed")
        } else {
            Log.e(javaClass.canonicalName, "Authorization failed", ex)
        }
    }

    companion object {
        const val RC_EXTERNAL_AUTH = 120
    }
}