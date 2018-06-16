package com.example.fairshare.auth.signin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.fairshare.R
import com.hannesdorfmann.mosby3.mvp.viewstate.MvpViewStateFragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.view.*
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationResponse
import net.openid.appauth.AuthorizationService
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.android.gms.common.api.ApiException

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

    private fun onLocalLoginClicked() {
        email_login_form.clearAnimation()

        presenter.doLogin()
    }

    private fun onGoogleLoginClicked() {
        presenter.doGoogleSignIn()
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

    override fun showGoogleSignIn(googleSignInOptions: GoogleSignInOptions) {
        val googleSignInClient = GoogleSignIn.getClient(activity!!, googleSignInOptions)
        val intent = googleSignInClient.signInIntent
        startActivityForResult(intent, RC_GOOGLE_SIGNIN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            RC_EXTERNAL_AUTH -> onExternalLogin(
                    if (data != null) AuthorizationResponse.fromIntent(data) else null,
                    AuthorizationException.fromIntent(data))
            RC_GOOGLE_SIGNIN -> {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                handleGoogleSignInResult(task)
            }
        }
    }

    private fun onExternalLogin(response: AuthorizationResponse?, ex: AuthorizationException?) {
        if (response != null) {
            Log.e("1111", "Completed")
        } else {
            Log.e(javaClass.canonicalName, "Authorization failed", ex)
        }
    }

    private fun handleGoogleSignInResult(task: Task<GoogleSignInAccount>) {
        try {
            val account = task.getResult(ApiException::class.java)

            // TODO: ok

        } catch (e: ApiException) {
            Log.w(javaClass.canonicalName, "signInResult:failed code=" + e.statusCode);

            // TODO: show error
        }
    }

    companion object {
        const val RC_EXTERNAL_AUTH = 120
        const val RC_GOOGLE_SIGNIN = 121
    }
}