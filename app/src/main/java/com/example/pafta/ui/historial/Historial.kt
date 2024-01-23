package com.example.pafta.ui.historial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.pafta.R
import com.example.pafta.ui.home.Inicio

class Historial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)


        val spinner: Spinner = findViewById(R.id.spinnerHistorial)

        // Obtén el array de valores desde los recursos
        val valores: Array<String> = resources.getStringArray(R.array.spinner_values)

        // Crea un ArrayAdapter usando el array de valores y un diseño de spinner predeterminado
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, valores)

        // Especifica el diseño del drop-down que se mostrará cuando el Spinner esté abierto
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Asigna el adaptador al Spinner

        spinner.adapter = adapter


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
            finish()
        }




    }
}