package com.example.moodapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
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
        sadBtn.setOnClickListener {
            val intent = Intent(this, Sad::class.java) // FIXED: moved inside the click listener
            startActivity(intent)
        }

        //ActionBar:
        val actionBar = findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(actionBar)

        val hamBurger = ContextCompat.getDrawable(this,R.drawable.hamburger)
        hamBurger?.setTint(ContextCompat.getColor(this,android.R.color.black))
        actionBar.overflowIcon = hamBurger
//        actionBar.overflowIcon?.setTint(ContextCompat.getColor(this,android.R.color.white))
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
