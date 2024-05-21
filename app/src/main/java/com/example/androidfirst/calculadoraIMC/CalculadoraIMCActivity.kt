package com.example.androidfirst.calculadoraIMC

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfirst.R

class CalculadoraIMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true;
    private lateinit var cardMale: CardView //lateinit significa q los voy a iniciar despues
    private lateinit var cardFemale: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_imcactivity)

        initComponent()
        initListeners()
        renderUI()
    }

    private fun initComponent() {
        this.cardMale = findViewById<CardView>(R.id.cardMale)
        this.cardFemale = findViewById<CardView>(R.id.cardFemale)
    }

    private fun initListeners() {
        cardMale.setOnClickListener{
            isMaleSelected = true
            setSelectdColor()
        }
        cardFemale.setOnClickListener{
            isMaleSelected = false
            setSelectdColor()
        }

    }

    private fun getColor(selected:Boolean):Int {
        return if (selected) {
            ContextCompat.getColor(
            this,
            R.color.IMC_background_card_selected)
        } else {
            ContextCompat.getColor(
                this,
                R.color.IMC_background_card)
        }
    }

    private fun setSelectdColor() {
        val maleColor = getColor(this.isMaleSelected)
        val femaleColor = getColor(!this.isMaleSelected)

        cardMale.setCardBackgroundColor(maleColor)
        cardFemale.setCardBackgroundColor(femaleColor)
    }

    private fun setCardColor() {
        cardMale.setCardBackgroundColor(getColor(this.isMaleSelected))
        cardFemale.setCardBackgroundColor(getColor(!this.isMaleSelected))
    }

    //este metodo va a setear el color cuando inicie la pantalla,
    // aunque ya este seteado en el layout por defecto en hombre
    private fun renderUI() {
        setCardColor()
    }

}