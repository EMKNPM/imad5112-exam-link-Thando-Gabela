package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Detail screen - displays full gear list from arrays passed via Intent
// AI assisted - disclosed per exam rules
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Receive arrays from GearActivity via Intent
        val itemNames = intent.getStringArrayExtra("itemNames") ?: arrayOf()
        val categories = intent.getStringArrayExtra("categories") ?: arrayOf()
        val quantities = intent.getIntArrayExtra("quantities") ?: intArrayOf()
        val comments = intent.getStringArrayExtra("comments") ?: arrayOf()

        android.util.Log.d("CampsiteCommander", "DetailActivity loaded with ${itemNames.size} items")

        // Build gear list using loop
        val gearListText = findViewById<TextView>(R.id.gearListText)
        val sb = StringBuilder()

        for (i in itemNames.indices) {
            sb.append("🏕️ ${itemNames[i]}\n")
            sb.append("   Category: ${categories[i]}\n")
            sb.append("   Quantity: ${quantities[i]}\n")
            sb.append("   Notes: ${comments[i]}\n\n")
        }

        gearListText.text = sb.toString()

        // Back to Base button - returns to GearActivity
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}