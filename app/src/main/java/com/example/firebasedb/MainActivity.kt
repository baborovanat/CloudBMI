package com.example.firebasedb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasedb.databinding.ActivityMainBinding
//import com.example.firebaserecyclerviewkotlin.MainActivity2
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import java.time.LocalDateTime
import java.util.*


class MainActivity : AppCompatActivity() {

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var database : DatabaseReference

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSave.setOnClickListener {

            val weight = binding.weight.text.toString()
            val height = binding.height.text.toString()
            val username = binding.username.text.toString()
            val bmi = binding.result.text.toString()

           // mRef.child("timestamp").setValue(ServerValue.TIMESTAMP)
            database = FirebaseDatabase.getInstance().getReference("Users")

           //val timestamp = b
           val timestamp = ServerValue.TIMESTAMP
              timestamp.setValue(ServerValue.TIMESTAMP)
          //  val timestampstring: String = timestamp.getValue(LocalDateTime.).toString()
            // val timestamp  = binding.root.ServerValue.TIMESTAMP
            val User = User(weight,height,username, bmi, timestamp)

            database.child(username).setValue(User).addOnSuccessListener {

                binding.weight.text.clear()
                binding.height.text.clear()
                binding.username.text.clear()
                binding.result.setText("")
                binding.resultText.setText("")
                val white = theme.resources.getColor(R.color.white)
               binding.resultText.background.mutate().setTint(white)
                binding.result.background.mutate().setTint(white)

                Toast.makeText(this,"Successfully Saved", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


            }
        }
        var btnCalculate = findViewById<Button>(R.id.btnCalculate)
        var resultText = findViewById<TextView>(R.id.result_text)
        btnCalculate.setOnClickListener{

            val grey = theme.resources.getColor(R.color.grey)
            val grey2 = theme.resources.getColor(R.color.grey_2)
            val green = theme.resources.getColor(R.color.green)
            val green2 = theme.resources.getColor(R.color.green_2)
            val yellow = theme.resources.getColor(R.color.yellow)
            val yellow2 = theme.resources.getColor(R.color.yellow_2)
            val red = theme.resources.getColor(R.color.red)
            val red2 = theme.resources.getColor(R.color.red_2)
            val white = theme.resources.getColor(R.color.white)

            val w = binding.weight.text.toString().toFloat()
            val h  = binding.height.text.toString().toFloat()/100
            val res :Float = (w/(h*h))

            if (h==0.0f || w==0.0f) {
                binding.result.text = "-"
                resultText.setText("Don't enter 0")}
else {
                binding.result.text = "%.2f".format(res)

                if (res <18.5) {
                    binding.result.background.mutate().setTint(grey)
                    resultText.setText("Oh no!\n You're Underweight")
                    resultText.background.mutate().setTint(grey2)
                }
                if (res >= 18.5 && res < 25) {
                    binding.result.background.mutate().setTint(green)
                    resultText.setText("Your weight is alright,\n Congratulations!")
                    resultText.background.mutate().setTint(green2)
                }
                if (res >= 25 && res < 30) {
                    binding.result.background.mutate().setTint(yellow)
                    resultText.setText("Oh no!\n You're Overweight")
                    resultText.background.mutate().setTint(yellow2)
                }
                if (res >= 30) {
                    binding.result.background.mutate().setTint(red)
                    resultText.setText("Oh no!\n You're Obese")
                    resultText.background.mutate().setTint(red2)
                }
            }

            }

       var btnNextPage = findViewById<Button>(R.id.btnNextPage)
               btnNextPage.setOnClickListener{
            val Intent = Intent(this, MainActivity2::class.java)
         startActivity(Intent)
      }


        }


private fun <K, V> MutableMap<K, V>.setValue(thisRef: Map<V, V>) {

}
}
