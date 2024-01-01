package com.example.pafta.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.pafta.R

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val spinner: Spinner = findViewById(R.id.spinner)

        // Obtén el array de valores desde los recursos
        val valores: Array<String> = resources.getStringArray(R.array.spinner_values)

        // Crea un ArrayAdapter usando el array de valores y un diseño de spinner predeterminado
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, valores)

        // Especifica el diseño del drop-down que se mostrará cuando el Spinner esté abierto
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Asigna el adaptador al Spinner
        spinner.adapter = adapter


    }
}