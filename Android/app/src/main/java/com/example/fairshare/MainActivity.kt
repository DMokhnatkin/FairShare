package com.example.fairshare

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fairshare.auth.signin.SignInActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startApp()
    }

    private fun startApp() {
        val appIntent = Intent(this, SignInActivity::class.java)
        appIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        appIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(appIntent)
    }

    companion object {
        private const val SIGN_IN_REQUEST = 10
    }
}
