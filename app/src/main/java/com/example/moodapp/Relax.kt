package com.example.moodapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
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

class Relax : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_relax)

        val layout = findViewById<ScrollView>(R.id.relaxPage);
        val prefs = getSharedPreferences("themePrefs", MODE_PRIVATE)
        val isDark = prefs.getBoolean("darkMode",false)
        layout.setBackgroundColor(
            if (isDark) Color.parseColor("#0f172a")
            else Color.parseColor("#C495C1")
        )

        val input = findViewById<EditText>(R.id.input)
        val submit = findViewById<Button>(R.id.said)
        val boost = findViewById<Button>(R.id.boost)
        val watch = findViewById<Button>(R.id.watch)
        val message = findViewById<TextView>(R.id.message)
        val quote = findViewById<TextView>(R.id.quote)
        val layoutSplash = findViewById<ScrollView>(R.id.relaxPage);
        val fade = AnimationUtils.loadAnimation(this,R.anim.fade_in)
        layoutSplash.startAnimation(fade)
        Toast.makeText(this, "Relax Section", Toast.LENGTH_SHORT).show()

        submit.setOnClickListener{
            val userInput = input.text.toString().trim()
            if(userInput.isNotEmpty()){
                val b = AlertDialog.Builder(this)
                b.setTitle("Create Diary")
                b.setMessage("Do you want to tell something more or continue")
                b.setPositiveButton("Yes"){dialog,_-> finish() }
                b.setNegativeButton("No"){dialog,_-> dialog.dismiss()}
                b.setNeutralButton("No"){dialog,_ ->  Toast.makeText(this, "Ok fine", Toast.LENGTH_SHORT).show()}
                b.create().show()
                message.text = userInput
            }else{
                message.text = "It's ok if you don't won't to share. Remember all is well!!"
            }
            message.visibility = View.VISIBLE
        }

        boost.setOnClickListener{
            quote.visibility = View.VISIBLE
        }

        watch.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/jq0pIc9qqO8?si=lBAN8LP_Hw7ww11p"))
            startActivity(intent)
        }
    }
}