package com.taurus.modernandroiddevelopmentkata.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.taurus.modernandroiddevelopmentkata.MainActivity
import com.taurus.modernandroiddevelopmentkata.R

private const val SPLASH_DELAY = 2000L

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()
        handler.postDelayed({ goToMainActivity() }, SPLASH_DELAY)
    }

    private fun goToMainActivity() {
        if (!isFinishing) {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }
    }
}
