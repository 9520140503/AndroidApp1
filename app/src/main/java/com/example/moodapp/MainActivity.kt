package com.example.moodapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.moodapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Main Section", Toast.LENGTH_SHORT).show()
        val layoutSplash = findViewById<LinearLayout>(R.id.mood)
        val fade = AnimationUtils.loadAnimation(this, R.anim.fade_in) // FIXED: use `loadAnimation`
        layoutSplash.startAnimation(fade)

        val sadBtn = findViewById<ImageButton>(R.id.sad)
        val happyBtn = findViewById<ImageButton>(R.id.happy)
        val wowBtn = findViewById<ImageButton>(R.id.wow)
        val loveBtn = findViewById<ImageButton>(R.id.love)
        val relaxBtn = findViewById<ImageButton>(R.id.relax)
        val quietBtn = findViewById<ImageButton>(R.id.quiet)

        sadBtn.setOnClickListener {
            val intent = Intent(this, Sad::class.java) // FIXED: moved inside the click listener
            startActivity(intent)
        }

        happyBtn.setOnClickListener{
            val intent = Intent(this,Happy::class.java)
            startActivity(intent)
        }

        wowBtn.setOnClickListener{
            val intent = Intent(this, Wow::class.java) // FIXED: moved inside the click listener
            startActivity(intent)
        }

        loveBtn.setOnClickListener{
            val intent = Intent(this,Love::class.java)
            startActivity(intent)
        }

        relaxBtn.setOnClickListener{
            val intent = Intent(this,Relax::class.java)
            startActivity(intent)
        }

        quietBtn.setOnClickListener{
            val intent = Intent(this,Quiet::class.java)
            startActivity(intent)
        }

        //ActionBar:
        val actionBar = findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(actionBar)

        val hamBurger = ContextCompat.getDrawable(this,R.drawable.hamburger)
        hamBurger?.setTint(ContextCompat.getColor(this,android.R.color.white))
        actionBar.overflowIcon = hamBurger
//        actionBar.overflowIcon?.setTint(ContextCompat.getColor(this,android.R.color.white))

        //Theme toggle: **** After this to go diff sections to add/code
        val toggle = findViewById<ToggleButton>(R.id.themeToggle)
        val moodLayout = findViewById<LinearLayout>(R.id.mood) // Or any layout

        // Load saved state
        val prefs = getSharedPreferences("themePrefs", MODE_PRIVATE)
        var isDark = prefs.getBoolean("darkMode", false)

        // Apply saved color immediately
        moodLayout.setBackgroundColor(
            if (isDark) Color.parseColor("#0f172a")
            else Color.parseColor("#C495C1")
        )
        toggle.isChecked = isDark

        // Toggle click listener
        toggle.setOnClickListener {
            isDark = !isDark

            // Save to SharedPreferences
            prefs.edit().putBoolean("darkMode", isDark).apply()

            // Change background immediately
            moodLayout.setBackgroundColor(
                if (isDark) Color.parseColor("#0f172a")
                else Color.parseColor("#C495C1")
            )
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      return  when (item.itemId){
          R.id.i1 -> {
              Toast.makeText(this,"Rate us",Toast.LENGTH_SHORT).show()
              val intent = Intent(this,Rateus::class.java)
              startActivity(intent)
              true
          }
          R.id.i2 -> {
              Toast.makeText(this,"Terms and Conditions",Toast.LENGTH_SHORT).show()
              val intent = Intent(this,Terms::class.java)
              startActivity(intent)
              true
          }
          R.id.i3 -> {
              Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show()
              val intent = Intent(this,Contactus::class.java)
              startActivity(intent)
              true
          }
          R.id.i4 -> {
              Toast.makeText(this, "Profile Section", Toast.LENGTH_SHORT).show()
              val intent = Intent(this,Profile::class.java)
              startActivity(intent)
              true
          }
          else -> super.onOptionsItemSelected(item)
      }
    }
}
