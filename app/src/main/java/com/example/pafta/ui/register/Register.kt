package com.example.pafta.ui.register

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pafta.R
import com.example.pafta.ui.login.Login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var userEmailEditText: EditText
    private lateinit var userPasswordEditText: EditText
    private lateinit var userNameEditText: EditText
    private lateinit var userLastNameEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button

    // ...
// Initialize Firebase Auth // ...
// Initialize Firebase Authz
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = Firebase.auth
        userEmailEditText = findViewById(R.id.userEmail)
        userPasswordEditText = findViewById(R.id.userPassword)
        userNameEditText = findViewById(R.id.userName)
        confirmPasswordEditText = findViewById(R.id.confirmPassword)
        registerButton = findViewById(R.id.registerButton)
        registrarOnclick()
    }

    private fun registrarOnclick() {
        registerButton.setOnClickListener onClick@{
            val email = userEmailEditText.text.toString()
            val password = userPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()
            val userName = userNameEditText.text.toString()
            if (!isValidEmail(email)) {
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
                return@onClick
            }

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || userName.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@onClick

            }

            if (password == confirmPassword) {
                // Lógica para registrar un nuevo usuario con Firebase
                createAccount(email, password)
                return@onClick
            } else {
                // Muestra un mensaje si las contraseñas no coinciden
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@onClick
            }

        }
    }
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }
    private fun createAccount(email: String, password: String) {

        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)

                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    updateUI(null)
                }
            }
        // [END create_user_with_email]
    }

    private fun updateUI(user: FirebaseUser?) {

    }
}