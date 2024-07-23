package com.example.multiapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_app)

        // assigning views
        val spinner: Spinner = findViewById(R.id.spinner)
        val btnShowToast: Button = findViewById(R.id.btnShowToast)
        val textView: TextView = findViewById(R.id.textView)

        // get intent input
        val data = intent.getDoubleExtra("data", 0.0)

        // check and set input value
        if(data > 0) {

            // show a toast message
            Toast.makeText(this, "Opened with a random number from another activity: $data", Toast.LENGTH_LONG).show()
        }

        val items = arrayOf("Item 1", "Item 2", "Item 3")
        var selectedItem = "Selected: Item 1" // default
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem = items[position]
            }
        }

        btnShowToast.setOnClickListener {
            textView.setText("Selected: $selectedItem")
            Toast.makeText(this, "Textview has been updated to: $selectedItem!", Toast.LENGTH_SHORT).show()
        }
    }
}
