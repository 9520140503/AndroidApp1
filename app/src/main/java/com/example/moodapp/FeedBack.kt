package com.example.moodapp

import android.graphics.Color
import android.os.Bundle
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class FeedBack : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feed_back)

        //ToggleTheme:
        val layout = findViewById<ScrollView>(R.id.feed) // your layout ID
        val prefs = getSharedPreferences("themePrefs", MODE_PRIVATE)
        val isDark = prefs.getBoolean("darkMode", false)
        layout.setBackgroundColor(
            if (isDark) Color.parseColor("#0f172a")
            else Color.parseColor("#C495C1")
        )



        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val submitratingBtn = findViewById<Button>(R.id.submitratingBtn)
        val editFeedBack = findViewById<EditText>(R.id.editFeedBack)
        var charCount = findViewById<TextView>(R.id.charCount)
        val submitFeedBack = findViewById<Button>(R.id.submitFeedBack)

        //Getting Rating:
        ratingBar.setOnRatingBarChangeListener{_, rating, _->
            if(rating > 0f){
                submitratingBtn.visibility = Button.VISIBLE
                submitratingBtn.text = "Good"
            }
        }
        submitratingBtn.setOnClickListener{
           var rating = ratingBar.rating
            Snackbar.make(it,"You rated us $rating to us",Snackbar.LENGTH_SHORT).setAction("Undo"){}.show()
        }

        //Edittext Counter: textWatcher Class -->> three functions
        editFeedBack.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
//            val length = s?.length ?: 0
            val length = if(s!=null) s.length else 0
                charCount.text = "$length/250"
                submitFeedBack.visibility = if(length > 0) Button.VISIBLE else Button.GONE
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}


        })

       submitFeedBack.setOnClickListener{
          val b = AlertDialog.Builder(this)
           b.setTitle("Submit FeedBack")
           b.setMessage("Do you want to finish it")
           b.setPositiveButton("Yes"){dialog,_ -> finish()}
           b.setNegativeButton("No"){dialog,_-> dialog.dismiss()}
           b.show()
       }
    }
}