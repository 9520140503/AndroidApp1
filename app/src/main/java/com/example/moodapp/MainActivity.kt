package com.example.moodapp

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.moodapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val layoutSplash = findViewById<LinearLayout>(R.id.mood)
        val fade = AnimationUtils.loadAnimation(this, R.anim.fade_in) // FIXED: use `loadAnimation`
        layoutSplash.startAnimation(fade)

        val sadBtn = findViewById<ImageButton>(R.id.sad)
        sadBtn.setOnClickListener {
            val intent = Intent(this, Sad::class.java) // FIXED: moved inside the click listener
            startActivity(intent)
        }
    }
}
