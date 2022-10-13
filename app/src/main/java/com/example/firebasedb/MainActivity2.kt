package com.example.firebasedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var btnPrevious = findViewById<Button>(R.id.btn_previous_page)

        btnPrevious.setOnClickListener{
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        lateinit var recyclerbtn : Button
        recyclerbtn = findViewById(R.id.recyclerviewbtn)

        recyclerbtn.setOnClickListener {

            var i = Intent(this,UserlistActivity::class.java)
            startActivity(i)
            finish()


        }

    }
}