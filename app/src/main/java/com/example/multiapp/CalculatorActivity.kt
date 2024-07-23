package com.example.multiapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        // assigning views
        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val etNumber1: EditText = findViewById(R.id.input1)
        val etNumber2: EditText = findViewById(R.id.input2)
        val etOperation: EditText = findViewById(R.id.operation)
        val tvResult: TextView = findViewById(R.id.result)

        // get intent input
        val input1 = intent.getStringExtra("input1")?.toDoubleOrNull()

        // check and set input value
        if(input1 != null) {

            // set input value
            etNumber1.setText(input1.toString())

            // show a toast message
            Toast.makeText(this, "Activity opened with intent data for input1: $input1", Toast.LENGTH_SHORT).show()
        }

        btnCalculate.setOnClickListener {
            val num1 = etNumber1.text.toString().toDoubleOrNull()
            val num2 = etNumber2.text.toString().toDoubleOrNull()
            val operation = etOperation.text.toString()

            if (num1 != null && num2 != null) {
                val result = when (operation) {
                    "+" -> num1 + num2
                    "-" -> num1 - num2
                    "*" -> num1 * num2
                    "/" -> if (num2 != 0.0) num1 / num2 else "Cannot divide by zero"
                    else -> "Invalid operation"
                }
                tvResult.text = result.toString()
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
