package com.example.segundoparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var usernameET: EditText
    private lateinit var passwordET: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        usernameET = findViewById(R.id.UsernameET)
        passwordET = findViewById(R.id.PasswordET)
        registerButton = findViewById(R.id.RegisterButton)

        // Acción del botón de registro
        registerButton.setOnClickListener {
            val username = usernameET.text.toString().trim()
            val password = passwordET.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)
            with(preferences.edit()) {
                putString("username", username)
                putString("password", password)
                apply()
            }

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Finaliza esta actividad
        }
    }
}
