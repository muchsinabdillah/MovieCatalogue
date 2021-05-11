package com.mov.moviecatalogue

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.mov.moviecatalogue.databinding.ActivitySplashScreenBinding
import com.mov.moviecatalogue.ui.home.HomeActivity

class SplashScreen : AppCompatActivity() {
    private lateinit var splashScreenBinding: ActivitySplashScreenBinding
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashScreenBinding.root)
        handler = Handler()
        splashScreenBinding.progress.start()
        splashScreenBinding.progress.loadingColor = R.color.black
        handler.postDelayed({
            val intent = Intent(this@SplashScreen, HomeActivity::class.java)
            startActivity(intent)
            splashScreenBinding.progress.stop()
            finish()
        }, 3000)
    }
}