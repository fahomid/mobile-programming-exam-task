package com.example.multiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning buttons
        val btnOpenCalculator: Button = findViewById(R.id.btnOpenCalculator)
        val btnOpenSecondApp: Button = findViewById(R.id.btnOpenSecondApp)
        val btnOpenSharedActivity: Button = findViewById(R.id.btnOpenSharedActivity)


        btnOpenCalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        btnOpenSecondApp.setOnClickListener {
            val intent = Intent(this, SecondAppActivity::class.java)
            startActivity(intent)
        }

        btnOpenSharedActivity.setOnClickListener {
            val intent = Intent(this, SharedActivity::class.java)
            startActivity(intent)
        }
    }
}
