package com.example.firebasedb

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.database.ServerValue
import java.time.LocalDateTime

@SuppressLint("NewApi")
data class User @RequiresApi(Build.VERSION_CODES.O) constructor(
    val weight: String= "", val height: String = "", val username: String = "",
    val bmi: String = "",  val timestamp: String = LocalDateTime.now().toString()     //MutableMap<String, String> = ServerValue.TIMESTAMP
)
//mRef.child("timestamp").setValue(ServerValue.TIMESTAMP)