package com.example.moodapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar //
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ActionBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bar)
        val toolBar = findViewById<Toolbar>(R.id.toolbar);
        setSupportActionBar(toolBar)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.i1 -> {
                Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.i2 -> {
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}