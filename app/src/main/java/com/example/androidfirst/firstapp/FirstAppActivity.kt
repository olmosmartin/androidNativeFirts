package com.example.androidfirst.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfirst.R

// Definición de tu clase FirstAppActivity que hereda de AppCompatActivity
class FirstAppActivity : AppCompatActivity() { //FirstAppActivity hereda de AppCompatActivity
    // Sobrescribiendo el método onCreate que se llama al crear la Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llamada al método original de la clase padre
        //enableEdgeToEdge() // Habilita el diseño de borde a borde para esta Activity
        setContentView(R.layout.activity_first_app) // Establece el diseño de la Activity usando el archivo XML correspondiente

        // Inicia la pantalla desde acá

        val btnPulsar = findViewById<Button>(R.id.btnPulsar)
        val texto = findViewById<EditText>(R.id.editTexto)

        btnPulsar.setOnClickListener {
            val nombre: String = texto.text.toString()
            Log.i("tag", "texto: " + nombre)
            if (nombre.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", nombre)
                startActivity(intent)
            }
        }

        /*
        // Configura un listener que se llama al aplicar los insets de la ventana
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Obtiene los insets del sistema (como la barra de estado y la barra de navegación)
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Aplica un padding a la vista para que el contenido no sea cubierto por las barras del sistema
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets // Retorna los insets para seguir con el procesamiento de otros listeners
        }

         */
    }
}