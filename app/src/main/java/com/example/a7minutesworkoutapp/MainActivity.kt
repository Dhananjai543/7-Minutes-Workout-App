package com.example.a7minutesworkoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        llStart.setOnClickListener {
            val intent = Intent(this,ExerciseActivity::class.java)
            startActivity(intent)
        }
        llBMI.setOnClickListener {
            val intent = Intent(this,BMI_Activity::class.java)
            startActivity(intent)
        }
        llHistory.setOnClickListener {
            val intent = Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }
        llInstruction.setOnClickListener {
            val intent = Intent(this,HowToDo_Activity::class.java)
            startActivity(intent)
        }
    }
}