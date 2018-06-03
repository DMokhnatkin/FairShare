package com.example.fairshare.domain.auth.signin

import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

interface IGoogleSignInService
{
    fun createSignInIntent(context: Context): Intent?

    fun handleSignInResult(intent: Intent): GoogleSignInAccount
}