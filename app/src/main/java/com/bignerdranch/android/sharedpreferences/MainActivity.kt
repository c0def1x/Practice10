package com.bignerdranch.android.sharedpreferences

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity()
{
    private lateinit var constraintLayout: ConstraintLayout
    private var number: Int = 0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val preferences = getSharedPreferences("launchCount", MODE_PRIVATE)
        val edit = preferences.edit()
        constraintLayout = findViewById(R.id.screen)
        number = preferences.getInt("launchCount", number)
        val launchCount = number + 1
        number = launchCount
        edit.putInt("launchCount", number)
        edit.apply()
        if(preferences.getInt("launchCount", number) == 1)
        {
            constraintLayout.setBackgroundResource(R.color.white)
            edit.putInt("launchCount", number)
            edit.apply()
        }
        else if(preferences.getInt("launchCount", launchCount) % 2 == 0)
        {
            constraintLayout.setBackgroundResource(R.color.blue)
            edit.putInt("launchCount", number)
            edit.apply()
        }
        else if(preferences.getInt("launchCount", number) % 2 != 0)
        {
            constraintLayout.setBackgroundResource(R.color.green)
            edit.putInt("launchCount", number)
            edit.apply()
        }
    }
}