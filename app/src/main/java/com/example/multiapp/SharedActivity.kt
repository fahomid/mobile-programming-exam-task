package com.example.multiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SharedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        // assigning buttons
        val btnOpenCalculatorWithData: Button = findViewById(R.id.btnOpenCalculatorWithData)
        val btnOpenSecondAppWithData: Button = findViewById(R.id.btnOpenSecondAppWithData)

        btnOpenCalculatorWithData.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra("input1", "100")
            startActivity(intent)
        }

        btnOpenSecondAppWithData.setOnClickListener {
            val intent = Intent(this, SecondAppActivity::class.java)
            intent.putExtra("data", Math.random())
            startActivity(intent)
        }
    }
}
