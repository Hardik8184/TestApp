package com.hardik.testapplication.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.hardik.testapplication.R

class SplashActivity : AppCompatActivity() {

  val handler = Handler()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    handler.postDelayed(startApp, 2000)
  }

  private var startApp: Runnable = object : Runnable {
    override fun run() {
      handler.removeCallbacks(this)
      startActivity(Intent(this@SplashActivity, MainActivity::class.java))
      finish()
      overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
  }
}