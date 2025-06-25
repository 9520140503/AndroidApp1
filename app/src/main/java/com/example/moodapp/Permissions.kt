package com.example.moodapp

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.core.app.ActivityCompat

class Permissions : AppCompatActivity() {

    private val CALL_REQUEST_CODE = 100  /* it is unique key*/
    private val telePhone = "09520140503"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_permissions)


        //permissions:
        val permission =  findViewById<Button>(R.id.phonePermission)
        permission.setOnClickListener{
            //Check self permission:Use to check permission :PERMISSION-GRANTED / PERMISSION-DENIED:
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                makeCall()
            }else{
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CALL_PHONE),CALL_REQUEST_CODE)
            }
        }

    }
    //Outside the oncreate
        private fun makeCall(){
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel: $telePhone")
            startActivity(callIntent)
        }
}