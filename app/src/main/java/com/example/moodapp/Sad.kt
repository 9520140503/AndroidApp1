package com.example.moodapp

import android.os.Bundle
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

class Sad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sad)
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
    }
}