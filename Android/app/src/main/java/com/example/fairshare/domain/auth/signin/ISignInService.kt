package com.example.fairshare.domain.auth.signin

import android.content.Context
import android.content.Intent

interface ISignInService {
    fun createSignInIntent(context: Context): Intent?
}