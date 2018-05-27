package com.example.fairshare.infrastructure

import android.content.Context
import com.example.fairshare.domain.auth.FairShareAccount
import com.example.fairshare.domain.auth.ICurrentUserService
import com.google.android.gms.auth.api.signin.GoogleSignIn

class CurrentUserService(val context: Context) : ICurrentUserService {

    override fun getSignedInAccount(): FairShareAccount? {
        val account = GoogleSignIn.getLastSignedInAccount(context) ?: return null
        return FairShareAccount(account.displayName)
    }

    override fun setSignedInAccount(account: FairShareAccount?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}