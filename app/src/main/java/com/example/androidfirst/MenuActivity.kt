package com.example.androidfirst

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfirst.constraintLayoutPractica.ConstraintLayoutPracticaActivity
import com.example.androidfirst.firstapp.FirstAppActivity
import com.example.androidfirst.firstapp.ResultActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnPulsar = findViewById<Button>(R.id.btnPrimero)
        val btnPulsar2 = findViewById<Button>(R.id.btnSegundo)

        btnPulsar.setOnClickListener { navegarPrimerBoton() }
        btnPulsar2.setOnClickListener { navegarSegundoBoton() }

    }

    private fun navegarPrimerBoton () {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
    private fun navegarSegundoBoton () {
        val intent = Intent(this, ConstraintLayoutPracticaActivity::class.java)
        startActivity(intent)
    }
}