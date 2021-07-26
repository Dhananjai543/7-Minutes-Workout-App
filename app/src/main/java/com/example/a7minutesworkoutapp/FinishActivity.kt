package com.example.a7minutesworkoutapp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_finish.*
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size
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

            //this will go to the last activity, but since we finished the exercise activity using finish(), it will
            // go automatically to the home activity and not last exercise activity
            onBackPressed()
        }

        btnFinish.setOnClickListener{
            finish()
        }
        addDateToHistoryDatabase()

        viewKonfetti.build()
            .addColors(Color.YELLOW, Color.GREEN, Color.RED)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(2000L)
            .addShapes(Shape.Square, Shape.Circle)
            .addSizes(Size(12))
            .setPosition(-50f, viewKonfetti.width + 50f, -50f, -50f)
            .streamFor(300, 5000L)

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