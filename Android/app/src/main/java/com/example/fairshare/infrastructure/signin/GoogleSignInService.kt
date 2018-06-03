package com.example.fairshare.infrastructure.signin

import android.content.Context
import android.content.Intent
import com.example.fairshare.domain.auth.signin.IGoogleSignInService
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

class GoogleSignInService : IGoogleSignInService {
    /**
     * Creates select from available google accounts menu
     */
    override fun createSignInIntent(context: Context): Intent? {
        val googleSignOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestProfile()
                .build()

        val googleSignInClient = GoogleSignIn.getClient(context, googleSignOptions)
        return googleSignInClient?.signInIntent
    }

    /**
     * Handles data entered in "sign in with" google menu
     */
    override fun handleSignInResult(intent: Intent): GoogleSignInAccount {
        // The Task returned from this call is always completed, no need to attach
        // a listener.
        val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
        return task.getResult(ApiException::class.java)
    }
}