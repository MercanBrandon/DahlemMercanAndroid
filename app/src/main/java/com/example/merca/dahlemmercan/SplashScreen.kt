package com.example.merca.dahlemmercan

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class SplashScreen : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val intent: Intent = if (Preferences.userName.isEmpty() && Preferences.userPwd.isEmpty())
                Intent(applicationContext, LoginActivity::class.java)
            else
                Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
