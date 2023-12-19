package com.example.pafta.data
class Persona {
    val nombre: String = "Scrum"

    init {
        println("Mi nombre es: $nombre")
    }
}

fun main() {
    val personaObj = Persona()
}

