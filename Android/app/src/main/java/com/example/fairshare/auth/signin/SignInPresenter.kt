package com.example.fairshare.auth.signin

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import android.accounts.AccountManager
import javax.inject.Inject


class SignInPresenter: MvpBasePresenter<SignInView>() {

/*    @Inject
    private lateinit var accountManager: AccountManager*/

/*    @BindView(R.id.username)
    internal var username: EditText? = null

    @BindView(R.id.password)
    internal var password: EditText? = null

    @BindView(R.id.local_sign_in_button)
    internal var loginButton: Button? = null*/

    fun doLogin() {
        ifViewAttached { view -> view.showLoading() }

//        val subscriber = object: Subscriber<Account> {
//            override fun onNext(t: Account?) {
//            }
//
//            override fun onSubscribe(s: Subscription?) {
//            }
//
//            override fun onComplete() {
//                ifViewAttached { view -> view.loginSuccessful() }
//            }
//
//            override fun onError(t: Throwable?) {
//                ifViewAttached { view -> view.showError() }
//            }
//        }
    }
}