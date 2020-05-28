package com.example.kotlineksperiments

import android.content.Context

class ThemeState(context : Context) {
    private val sharedPreferences = context.getSharedPreferences("file", Context.MODE_PRIVATE)

    fun setDarkModeState(state : Boolean){
        sharedPreferences.edit().apply {
            putBoolean("isDarkMode", state)
            apply()
        }
    }

    fun isDarkMode() = sharedPreferences.getBoolean("isDarkMode", false)
}