package com.example.a7minutesworkoutapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_how_to_do.*

@Suppress("DEPRECATION")
class HowToDo_Activity : AppCompatActivity() {

    private lateinit var mAdapter: InstructionsAdapter

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_do)

        val actionbar = supportActionBar
        if(actionbar!=null){
            actionbar.title = "How to Do?"
            // show back button on toolbar
            actionbar.setDisplayHomeAsUpEnabled(true)
            // on back button press, it will navigate to parent activity
            actionbar.setDisplayShowHomeEnabled(true)
        }
        //Glide.with(this).load(intent.getStringExtra("image").toString()).into(instruction_image);
//        howtodo_activity_toolbar.setNavigationOnClickListener {
//
//            //this will go to the last activity, but since we finished the exercise activity using finish(), it will
//            // go automatically to the home activity and not last exercise activity
//            onBackPressed()
//        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = InstructionsAdapter(this)
        recyclerView.adapter = mAdapter
    }

//    override fun onItemClicked(item: ExerciseModel) {
//        val url = item.getUrl()
////        val builder = CustomTabsIntent.Builder();
////        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorAccent));
////        builder.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorAccent));
////        builder.setStartAnimations(this, android.R.anim.slide_in_left, android.R.anim.slide_in_left);
////        builder.setExitAnimations(this, android.R.anim.slide_in_left,
////            android.R.anim.slide_out_right);
////        val customTabsIntent = builder.build();
////        customTabsIntent.launchUrl(this, Uri.parse(url));
//        val browserIntent = Intent(Intent.ACTION_VIEW,Uri.parse(url))
//        startActivity(browserIntent)
//    }
}