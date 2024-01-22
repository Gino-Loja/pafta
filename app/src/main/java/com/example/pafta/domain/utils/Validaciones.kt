package com.example.pafta.domain.utils

class Validaciones {

    companion object {
        fun isValidEmail(email: String): Boolean {
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            return email.matches(emailPattern.toRegex())
        }

        fun isValidInput(
            email: String,
            password: String,
            confirmPassword: String,
            userName: String
        ): Boolean {
            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || userName.isEmpty()) {
                return false
            }
            return true
        }
        fun isValidInputLogin(
            email: String,
            password: String
        ): Boolean {
            if (email.isEmpty() || password.isEmpty() ) {
                return false
            }
            return true
        }

        fun passwordMacht(password: String, password2: String): Boolean{

            if ( password == password2){
                return true
            }

            return false

        }

    }


}