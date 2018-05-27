package com.example.fairshare.domain.auth

interface ICurrentUserService {
    /**
     * Get current signed in account
     */
    fun getSignedInAccount(): FairShareAccount?

    /**
     * Set new current signed in account
     */
    fun setSignedInAccount(account: FairShareAccount?)
}