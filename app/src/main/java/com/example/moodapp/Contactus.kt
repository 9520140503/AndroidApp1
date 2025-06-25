package com.example.moodapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Contactus : AppCompatActivity() {
       private val CALL_REQUEST_CODE =100
       private val phone = "1234567890"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contactus)


        val layout = findViewById<LinearLayout>(R.id.contact) // your layout ID
        // Load saved state
        val prefs = getSharedPreferences("themePrefs", MODE_PRIVATE)
        val isDark = prefs.getBoolean("darkMode", false)
        layout.setBackgroundColor(
            if (isDark) Color.parseColor("#0f172a")
            else Color.parseColor("#C495C1")
        )

        //Permissions:
        val callPermission = findViewById<Button>(R.id.callPermission)

        callPermission.setOnClickListener{
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                makeCall()
            }else{
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CALL_PHONE),CALL_REQUEST_CODE)
            }
        }
    }
    private fun makeCall(){
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel: $phone")
        Toast.makeText(this,"Your call 📞 has been initiated",Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
}