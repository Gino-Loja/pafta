package com.example.pafta.ui.historial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pafta.R
import com.example.pafta.ui.home.Inicio

class Historial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        findViewById<Button>(R.id.btnFechaInicio).setOnClickListener {
            val newFragment = DatePickerFragment()
            newFragment.show(supportFragmentManager, "datePicker")
        }
        findViewById<Button>(R.id.btnFechaFinal).setOnClickListener {
            val newFragment = DatePickerFragment()
            newFragment.show(supportFragmentManager, "datePicker")
        }

        findViewById<Button>(R.id.btnInicio).setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }


    }
}