package com.example.androidfirst.firstapp

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfirst.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val texto = findViewById<TextView>(R.id.textresult);
        val nombre: String = intent.extras?.getString("EXTRA_NAME") ?: ""
        texto.text = nombre;
    }
}