package com.example.fairshare.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fairshare.R
import com.example.fairshare.domain.auth.ICurrentUserService
import kotlinx.android.synthetic.main.activity_app.*
import org.koin.android.ext.android.inject

class AppActivity : AppCompatActivity() {

    val serviceCurrent:ICurrentUserService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        hello_world.text = serviceCurrent.getSignedInAccount()?.test
    }
}
