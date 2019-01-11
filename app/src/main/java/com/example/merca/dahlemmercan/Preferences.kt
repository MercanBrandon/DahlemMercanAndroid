package com.example.merca.dahlemmercan

import com.chibatching.kotpref.KotprefModel

object Preferences : KotprefModel() {
    var userName by stringPref()
    var userPwd by stringPref()

}