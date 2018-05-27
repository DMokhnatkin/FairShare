package com.example.fairshare.infrastructure.signin

import android.content.Context
import android.content.Intent
import com.example.fairshare.domain.auth.signin.IGoogleSignInService
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class GoogleSignInService: IGoogleSignInService {

    /**
     * Creates select from available google accounts menu
     */
    override fun createSignInIntent(context: Context): Intent? {
        val googleSignOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(context, googleSignOptions)
        return googleSignInClient?.getSignInIntent()
    }
}