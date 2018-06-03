package com.example.fairshare.auth.signin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.fairshare.R

class SignInActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SignInFragment())
                    .commit()
        }
    }
}