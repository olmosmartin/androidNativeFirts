package com.example.androidfirst.constraintLayoutPractica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfirst.R
import com.example.androidfirst.firstapp.FirstAppActivity

class ConstraintLayoutPracticaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout_practica)

        val btnGuideline = findViewById<Button>(R.id.button2)

        btnGuideline.setOnClickListener { navegarGuideline() }

    }

    private fun navegarGuideline () {
        val intent = Intent(this, GuidelinePractiraActivity::class.java)
        startActivity(intent)
    }
}