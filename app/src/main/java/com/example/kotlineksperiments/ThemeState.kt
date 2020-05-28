package com.example.kotlineksperiments

import android.content.Context

class ThemeState(private val ctx: Context) {

    private val sharedPreferences =
        ctx.getSharedPreferences("file", Context.MODE_PRIVATE)

    fun applyTheme(){
        if (isDarkMode())
            ctx.setTheme(R.style.AppThemeDark)
        else
            ctx.setTheme(R.style.AppThemeLight)
    }

    fun isDarkMode() = sharedPreferences.getBoolean("isDarkMode", false)

    fun setDarkModeState(state : Boolean){
        sharedPreferences.edit().apply {
            putBoolean("isDarkMode", state)
            apply()
        }
    }
}