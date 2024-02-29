package com.example.miniproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.miniproject.ui.login.Calculator1Activity
import com.example.miniproject.ui.login.Calculator2Activity

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chapter1Button = findViewById<Button>(R.id.chapter1)
        val chapter2Button = findViewById<Button>(R.id.chapter2)

        chapter1Button.setOnClickListener {
            val intent = Intent(this, Calculator1Activity::class.java)
            startActivity(intent)
        }
        chapter2Button.setOnClickListener {
            val intent = Intent(this, Calculator2Activity::class.java)
            startActivity(intent)
        }

    }
}
