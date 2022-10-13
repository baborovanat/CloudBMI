package com.example.firebasedb

data class User(
    val weight: String? = null, val height: String? = null, val username: String? = null,
    val bmi: String?, val timestamp: MutableMap<String, String>
)
//mRef.child("timestamp").setValue(ServerValue.TIMESTAMP)