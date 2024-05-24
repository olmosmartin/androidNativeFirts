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
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class CalculadoraIMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true;

    private lateinit var cardMale: CardView //lateinit significa q los voy a iniciar despues
    private lateinit var cardFemale: CardView

    private lateinit var altura: TextView
    private lateinit var alturaSlider: RangeSlider

    private lateinit var textPeso: TextView
    private lateinit var btnPesoAdd: FloatingActionButton
    private lateinit var btnPesoRemove: FloatingActionButton

    private lateinit var textEdad: TextView
    private lateinit var btnEdadAdd: FloatingActionButton
    private lateinit var btnEdadRemove: FloatingActionButton

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

        this.textPeso = findViewById<TextView>(R.id.pesoNumero)
        this.btnPesoAdd = findViewById<FloatingActionButton>(R.id.btnPesoAdd)
        this.btnPesoRemove = findViewById<FloatingActionButton>(R.id.btnPesoRemove)

        this.textEdad = findViewById<TextView>(R.id.edadNumero)
        this.btnEdadAdd = findViewById<FloatingActionButton>(R.id.btnEdadAdd)
        this.btnEdadRemove = findViewById<FloatingActionButton>(R.id.btnEdadRemove)
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

        btnPesoAdd.setOnClickListener{
            //handlePeso(1)
            textPeso.text = handleEdadYPeso(textPeso.text.toString(), 1)
        }

        btnPesoRemove.setOnClickListener{
            //handlePeso(-1)
            textPeso.text = handleEdadYPeso(textPeso.text.toString(), -1)
        }

        btnEdadAdd.setOnClickListener{
            //handleEdad(1)
            textEdad.text = handleEdadYPeso(textEdad.text.toString(), 1)
        }

        btnEdadRemove.setOnClickListener{
            //handleEdad(-1)
            textEdad.text = handleEdadYPeso(textEdad.text.toString(), -1)
        }

    }

    private fun handleEdadYPeso (suma:String, numero: Int): String {
        return if (suma>"0") (suma.toInt()  + numero).toString() else suma
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

    private fun inicializarEdad() {
        textEdad.setText("30")
    }
    private fun inicializarPeso() {
        textPeso.setText("60")
    }

    //este metodo va a setear el color cuando inicie la pantalla,
    // aunque ya este seteado en el layout por defecto en hombre
    private fun renderUI() {
        setCardColor()
        inicializarEdad()
        inicializarPeso()
    }

}