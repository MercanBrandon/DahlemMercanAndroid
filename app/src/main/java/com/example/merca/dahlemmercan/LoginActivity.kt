package com.example.merca.dahlemmercan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.chibatching.kotpref.Kotpref
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
            Kotpref.init(context = applicationContext)

            btnConnexion.setOnClickListener {
                var userName : String = loginLogin.text.toString()
                var userPwd : String = loginPassword.text.toString()

                Preferences.userName = userName
                Preferences.userPwd = userPwd

                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
    }
}
