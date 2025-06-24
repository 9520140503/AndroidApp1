package com.example.moodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SnackBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_snack_bar)

        val snackBtn = findViewById<Button>(R.id.snackBtn)
        snackBtn.setOnClickListener{
            //One way: We have to use of "view in this type
//        view -> Snackbar.make(view,"Moved to Trash",Snackbar.LENGTH_SHORT).setAction("Dsimiss"){
//        }.show()

            //Second Way: Assigning Name : We have to use of "it" in this type
            var s = Snackbar.make(it,"this is snackBar",Snackbar.LENGTH_SHORT)

//            s.setAction("Dismiss"){s.dismiss()
//                Snackbar.make(it,"Dismiss is done",Snackbar.LENGTH_SHORT).show()
//            }
//            s.show()

            s.setAction("Navigate to Home screen"){
               val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }.show()
        }
    }
}