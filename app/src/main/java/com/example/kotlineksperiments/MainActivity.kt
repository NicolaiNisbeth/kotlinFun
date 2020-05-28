package com.example.kotlineksperiments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val themeState = ThemeState(this)
        if (themeState.isDarkMode())
            setTheme(R.style.AppThemeDark)
        else
            setTheme(R.style.AppThemeLight)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switcher.isChecked = themeState.isDarkMode()
        switcher.setOnCheckedChangeListener{_, isChecked ->
            themeState.setDarkModeState(isChecked)
            this.recreate()
        }
    }
}