package com.example.webviewtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        webViewSetup()
    }

    private fun webViewSetup() {
        val myWebView: WebView = findViewById(R.id.myWebView)
        val webSettings = myWebView.settings

        // Enable JavaScript and DOM storage
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        // Set WebViewClient to handle navigation within the WebView
        myWebView.webViewClient = WebViewClient()

        // Load the initial URL
        myWebView.loadUrl("https://7b21-122-100-74-191.ngrok-free.app/")
    }
}
