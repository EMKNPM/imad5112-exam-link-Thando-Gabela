package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Main screen - shows total items and navigation buttons
// AI assisted - disclosed per exam rules
class GearActivity : AppCompatActivity() {

    // Parallel arrays storing campsite gear data
    val itemNames = arrayOf("Tent", "Marshmallows", "Flashlight")
    val categories = arrayOf("Shelter", "Food", "Safety")
    val quantities = intArrayOf(1, 3, 2)
    val comments = arrayOf("4-person waterproof", "For S'mores", "Check batteries (AA)")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gear)

        // Calculate total items using loop
        var totalItems = 0
        for (qty in quantities) {
            totalItems += qty
        }

        android.util.Log.d("CampsiteCommander", "Total items calculated: $totalItems")

        // Display total
        val totalText = findViewById<TextView>(R.id.totalItemsText)
        totalText.text = "Total Items Packed: $totalItems"

        // Navigate to detail screen
        val viewListBtn = findViewById<Button>(R.id.viewListButton)
        viewListBtn.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("itemNames", itemNames)
            intent.putExtra("categories", categories)
            intent.putExtra("quantities", quantities)
            intent.putExtra("comments", comments)
            startActivity(intent)
        }
    }
}