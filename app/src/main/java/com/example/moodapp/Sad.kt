package com.example.moodapp

import android.content.Intent
import android.graphics.Color
import android.health.connect.datatypes.units.Length
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import android.view.animation.AnimationUtils;
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatDelegate

class Sad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sad)

        val layout = findViewById<ScrollView>(R.id.sadPage) // your layout ID

        // Load saved state
        val prefs = getSharedPreferences("themePrefs", MODE_PRIVATE)
        val isDark = prefs.getBoolean("darkMode", false)

        // Apply background color
        layout.setBackgroundColor(
            if (isDark) Color.parseColor("#0f172a") else Color.parseColor("#C495C1")
        )

        var input = findViewById<EditText>(R.id.input);
        var submit = findViewById<Button>(R.id.said);
        val boost = findViewById<Button>(R.id.boost);
        val watch = findViewById<Button>(R.id.watch);
        val message = findViewById<TextView>(R.id.message);
        val qoute = findViewById<TextView>(R.id.quote);
        val layoutSplash = findViewById<ScrollView>(R.id.sadPage)
        val fade = AnimationUtils.loadAnimation(this,R.anim.fade_in)
        layoutSplash.startAnimation(fade);
        Toast.makeText(this, "Sad Section", Toast.LENGTH_SHORT).show()

        //Button Animation:
        val buttonAnimation = AnimationUtils.loadAnimation(this,R.anim.button_anim);
        submit.setOnTouchListener {view, event ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    view.startAnimation(buttonAnimation);
                }
            }
            false
        }


        //Messages Section:
        submit.setOnClickListener{
            val userText = input.text.toString().trim();
            if(userText.isNotEmpty()){
                val b = AlertDialog.Builder(this)
                b.setTitle("Creating Diary")
                b.setMessage("Do you want to tell more?")
                b.setPositiveButton ("Yes") {dialog,_ ->finish()}
                b.setNegativeButton("No"){dialog,_ -> dialog.dismiss()}
                b.setNeutralButton("No"){dialog,_ ->  Toast.makeText(this, "Ok fine", Toast.LENGTH_SHORT).show()}
                b.create().show();
                message.text = userText;
            }else{
                message.text = "It's ok if you don't won't to share. Remember all is well!!"
            }
            message.visibility = View.VISIBLE;
        }

        boost.setOnClickListener{
            qoute.visibility = View.VISIBLE;
        }

        //Explicit:
        watch.setOnClickListener {
            val popMenu = PopupMenu(this, watch) // Use context properly
            popMenu.menuInflater.inflate(R.menu.menu, popMenu.menu)

            popMenu.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.i1 -> {
                        Toast.makeText(this, "This is the pop1", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.i2 -> {
                        Toast.makeText(this, "This is the pop2", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
            popMenu.show()
        }

//        //Implicit:
//        watch.setOnClickListener{
//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivity(intent);
//        }
    }
}