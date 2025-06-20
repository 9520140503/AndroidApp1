package com.example.moodapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycle)
        Toast.makeText(applicationContext,"onCreate", Toast.LENGTH_SHORT).show();
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext,"onPause", Toast.LENGTH_SHORT).show();
    }

    override fun onStart() {
        super.onStart();
        Toast.makeText(applicationContext,"onStart",Toast.LENGTH_SHORT).show();
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext,"onResume", Toast.LENGTH_SHORT).show();
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext,"onRestart", Toast.LENGTH_SHORT).show();
    }


    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext,"onStop", Toast.LENGTH_SHORT).show();
        Log.d("Main Acitivity","onStop Executed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"onDestroy", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","OnDestroy executed")
    }


}