package com.example.moodapp

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContextMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_context_menu)
        val img = findViewById<ImageView>(R.id.imageView2)
        registerForContextMenu(img)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        //Menu after long press:
        menuInflater.inflate(R.menu.image_view,menu);
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val img = findViewById<ImageView>(R.id.imageView2)
        return when(item.itemId) {
            R.id.rot -> {
                img.rotation = img.rotation+45f
                true
            }

            R.id.fil -> {
                img.setColorFilter(Color.GRAY)
                true
            }

            else -> super.onContextItemSelected(item);

        }
    }
}