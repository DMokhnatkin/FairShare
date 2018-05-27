package com.example.fairshare

import android.content.Context
import com.example.fairshare.domain.auth.signin.ISignInService
import com.example.fairshare.domain.auth.ICurrentUserService
import com.example.fairshare.infrastructure.CurrentUserService
import com.example.fairshare.infrastructure.signin.GoogleSignInService
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

class KoinModule {
    companion object {
        fun getModule(appContext: Context) : Module = applicationContext {
            bean { GoogleSignInService() as ISignInService }
            bean { CurrentUserService(appContext) as ICurrentUserService }
        }
    }
}