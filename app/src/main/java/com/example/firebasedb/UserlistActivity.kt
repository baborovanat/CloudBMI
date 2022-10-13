package com.example.firebasedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class UserlistActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<User>
    private lateinit var recyc_adapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist)

        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<User>()
        recyc_adapter = MyAdapter(userArrayList)
        userRecyclerview.adapter = recyc_adapter //MyAdapter(userArrayList)
        getUserData()

        var btnPrevious = findViewById<Button>(R.id.btn_previous_page)

        btnPrevious.setOnClickListener{
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
    }
    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("Users")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){
                    userArrayList.clear()
                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!)

                    }
                    //val adapter = MyAdapter(userArrayList)
                    recyc_adapter.notifyDataSetChanged()
                    //userRecyclerview.adapter = adapter;//MyAdapter(userArrayList)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}