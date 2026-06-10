package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

// Splash screen - shows for 3 seconds then navigates to GearActivity
// AI assisted with structure - disclosed per exam rules
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Log to confirm splash loaded
        android.util.Log.d("CampsiteCommander", "Splash screen loaded")

        // Wait 3 seconds then move to GearActivity imma kms
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, GearActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}