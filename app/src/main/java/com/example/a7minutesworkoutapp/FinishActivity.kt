package com.example.a7minutesworkoutapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_finish.*
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        setSupportActionBar(toolbar_finish_activity)
        val actionbar = supportActionBar

        if(actionbar!=null){
            //this will set a back button to the toolbar
            actionbar.setDefaultDisplayHomeAsUpEnabled(true)
        }

        toolbar_finish_activity.setNavigationOnClickListener {

            //this will go t the last activity, but since we finished the exercise activity usinf finish(), it will
            // go automatically to the home activity and not last exercise activity
            onBackPressed()
        }

        btnFinish.setOnClickListener{
            finish()
        }
        addDateToHistoryDatabase()
    }

    private fun addDateToHistoryDatabase(){
        val calender = Calendar.getInstance()
        val dateTime = calender.time
        Log.i("DATE", dateTime.toString())

        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)

        val dbHandler = SqliteOpenHelper(this,null)
        dbHandler.addDate(date)
        Log.i("DATE->","ADDED")

    }
}