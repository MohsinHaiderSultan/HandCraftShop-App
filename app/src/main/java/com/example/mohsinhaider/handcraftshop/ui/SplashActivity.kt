package com.example.mohsinhaider.handcraftshop.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mohsinhaider.handcraftshop.R
import com.example.mohsinhaider.handcraftshop.ui.auth.LoginActivity
import com.example.mohsinhaider.handcraftshop.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(mainLooper).postDelayed(
            {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()

            }, 3000)


    }
}