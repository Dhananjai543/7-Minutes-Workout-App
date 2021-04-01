package com.example.a7minutesworkoutapp

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_exercise.*
import kotlinx.android.synthetic.main.custom_dialog_back.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class ExerciseActivity : AppCompatActivity() , TextToSpeech.OnInitListener{
    @SuppressLint("RestrictedApi")

    private var restTimer: CountDownTimer? = null
    private var restProgress = 0

    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProgress = 0

    private var exerciseDuration : Long = 30
    private var restDuration: Long = 10
    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var currentExercisePosition = -1

    private var tts: TextToSpeech? = null
    private var player: MediaPlayer? = null

    private var exerciseAdapter : Exercise_Status_Adapter? = null
    private var isCurrentRest: Boolean = false
    private var isCurrentExercise: Boolean = false

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        setSupportActionBar(toolbar_excercise_activity)
        val actionbar = supportActionBar
        if(actionbar!=null){
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
        toolbar_excercise_activity.setNavigationOnClickListener {
            customDialogBackButton()
        }

        tts = TextToSpeech(this,this)

        exerciseList = Constants.defaultExerciseList()
        setUpRestView()

        setUpExcerciseStatusRecyclerView()
    }

    override fun onDestroy() {
        if(restTimer!=null){
            restTimer!!.cancel()
            restProgress = 0
        }
        if(exerciseTimer != null) {
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }
        if(tts != null){
            tts!!.stop()
            tts!!.shutdown()
        }
        if(player!=null){
            player!!.stop()
        }
        super.onDestroy()
    }

    private fun setExerciseProgressBar(){
        progressBarExercise.progress = exerciseProgress
        //milliseconds
        exerciseTimer = object: CountDownTimer(exerciseDuration*1000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                progressBarExercise.progress = exerciseDuration.toInt()-exerciseProgress
                tvExerciseTimer.text = (exerciseDuration.toInt()-exerciseProgress).toString()
            }

            override fun onFinish() {
                if(currentExercisePosition < exerciseList?.size!!-1){
                    exerciseList!![currentExercisePosition].setIsSelected(false)
                    exerciseList!![currentExercisePosition].setIsCompleted(true)
                    exerciseAdapter!!.notifyDataSetChanged()
                    setUpRestView()
                }else{
                    finish()
                    val intent : Intent = Intent(this@ExerciseActivity,FinishActivity::class.java)
                    startActivity(intent)

                }
            }
        }.start()
    }

    private fun setRestProgressBar(){
        progressBar.progress = restProgress
        //milliseconds
        restTimer = object: CountDownTimer(restDuration*1000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                progressBar.progress = 10-restProgress
                tvTimer.text = (10-restProgress).toString()
            }

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onFinish() {
                currentExercisePosition++

                exerciseList!![currentExercisePosition].setIsSelected(true)
                exerciseAdapter!!.notifyDataSetChanged()
                setUpExerciseView()
            }
        }.start()
    }

    private fun setUpRestView(){
        try {
            player = MediaPlayer.create(applicationContext,R.raw.press_start)
            player!!.isLooping = false
            player!!.start()
        }catch (e: Exception){
            e.printStackTrace()
        }

        llExerciseView.visibility = View.GONE
        llRestView.visibility = View.VISIBLE
        if(restTimer!=null){
            restTimer!!.cancel()
            restProgress = 0
        }
        isCurrentRest = true
        isCurrentExercise = false
        setRestProgressBar()

        tvUpcomingExercise.text = exerciseList!![currentExercisePosition+1].getName()
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setUpExerciseView(){

        llRestView.visibility = View.GONE
        llExerciseView.visibility = View.VISIBLE

        if(exerciseTimer!=null){
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }

        speakOut(exerciseList!![currentExercisePosition].getName())

        isCurrentRest = false
        isCurrentExercise = true
        setExerciseProgressBar()

        ivImage.setImageResource(exerciseList!![currentExercisePosition].getImage())
        tvExerciseName.text = exerciseList!![currentExercisePosition].getName()
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            val result = tts!!.setLanguage(Locale.US)

            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTs", "The language specified is not supported by the device")
            }
        }else{
            Log.e("TTS","Initialization failed")
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun speakOut(text: String){
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "" )
    }

    private fun setUpExcerciseStatusRecyclerView(){
        rvExerciseStatus.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        exerciseAdapter = Exercise_Status_Adapter(exerciseList!!,this)
        rvExerciseStatus.adapter = exerciseAdapter
    }

    private fun pauseTimer(){
        if(isCurrentRest){
            restTimer!!.cancel()
        }else{
            exerciseTimer!!.cancel()
        }
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun customDialogBackButton(){
        val customDialog : Dialog = Dialog(this)
        customDialog.setContentView(R.layout.custom_dialog_back)
        pauseTimer()
        customDialog.tvYes.setOnClickListener {
            finish()
            customDialog.dismiss()
        }
        customDialog.tvNo.setOnClickListener {
            if(isCurrentRest){
                setUpRestView()
            }else{
                setUpExerciseView()
            }
            customDialog.dismiss()
        }
        customDialog.show()
    }
}
