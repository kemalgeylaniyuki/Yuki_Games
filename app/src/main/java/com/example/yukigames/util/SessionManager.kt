package com.example.yukigames.util

import android.content.SharedPreferences
import javax.inject.Inject

class SessionManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun getIsFirstRun() = sharedPreferences.getBoolean(Constants.FIRST_RUN_KEY, true)

    fun setIsFirstRun(value : Boolean){
        val editor = sharedPreferences.edit().putBoolean(Constants.FIRST_RUN_KEY, value).apply()
    }

}