package com.example.androidfirst.calculadoraIMC

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfirst.R
import com.google.android.material.slider.RangeSlider

class CalculadoraIMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true;

    private lateinit var cardMale: CardView //lateinit significa q los voy a iniciar despues
    private lateinit var cardFemale: CardView

    private lateinit var altura: TextView
    private lateinit var alturaSlider: RangeSlider

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
        this.altura = findViewById<TextView>(R.id.alturaNumero)
        this.alturaSlider = findViewById<RangeSlider>(R.id.rsAltura)
    }

    private fun initListeners() {
        cardMale.setOnClickListener {
            isMaleSelected = true
            setSelectdColor()
        }
        cardFemale.setOnClickListener {
            isMaleSelected = false
            setSelectdColor()
        }
        alturaSlider.addOnChangeListener { rangeSider, value, fromUser ->
            altura.text = value.toInt().toString() + "cm"
        }

    }

    private fun getColor(selected: Boolean): Int {
        return if (selected) {
            ContextCompat.getColor(
                this,
                R.color.IMC_background_card_selected
            )
        } else {
            ContextCompat.getColor(
                this,
                R.color.IMC_background_card
            )
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