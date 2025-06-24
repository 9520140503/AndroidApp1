package com.example.moodapp

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Contactus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contactus)

        val layout = findViewById<LinearLayout>(R.id.contact) // your layout ID

        // Load saved state
        val prefs = getSharedPreferences("themePrefs", MODE_PRIVATE)
        val isDark = prefs.getBoolean("darkMode", false)

        // Apply background color
        layout.setBackgroundColor(
            if (isDark) Color.parseColor("#0f172a")
            else Color.parseColor("#C495C1")
        )
    }
}