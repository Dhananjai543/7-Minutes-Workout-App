package com.example.a7minutesworkoutapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val url : String? = intent.getStringExtra("key")

        val actionbar = supportActionBar
        if(actionbar!=null){
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title = intent.getStringExtra("name")
            // show back button on toolbar
            actionbar.setDisplayHomeAsUpEnabled(true)
            // on back button press, it will navigate to parent activity
            actionbar.setDisplayShowHomeEnabled(true)
        }



        if(url!=null){
            detailWebView.settings.javaScriptEnabled = true
            detailWebView.settings.userAgentString = "Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"
            detailWebView.webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressBar.visibility = View.GONE
                    detailWebView.visibility = View.VISIBLE
                }
            }
            detailWebView.loadUrl(url)
        }

    }
}