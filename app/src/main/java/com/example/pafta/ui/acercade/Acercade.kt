package com.example.pafta.ui.acercade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pafta.R
import com.example.pafta.ui.home.Inicio

class Acercade : AppCompatActivity() {

    lateinit var botonInicioAcercade:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acercade)
        botonInicioAcercade = findViewById(R.id.botonInicioAcercade)
        botonInicioAcercade.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
            finish()
        }
    }


}