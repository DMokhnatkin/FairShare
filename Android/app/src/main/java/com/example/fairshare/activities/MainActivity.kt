package com.example.fairshare.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fairshare.R
import com.example.fairshare.domain.auth.ICurrentUserService
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val serviceCurrent: ICurrentUserService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val t = serviceCurrent.getSignedInAccount()
        if (t == null) {
            val siginIntent = Intent(this, SignInActivity::class.java)
            startActivityForResult(siginIntent, SIGN_IN_REQUEST)
        } else {
            startApp()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            SIGN_IN_REQUEST -> {
                startApp()
            }
        }
    }

    private fun startApp() {
        val appIntent = Intent(this, AppActivity::class.java)
        appIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        appIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(appIntent)
    }

    companion object {
        private const val SIGN_IN_REQUEST = 10
    }
}
