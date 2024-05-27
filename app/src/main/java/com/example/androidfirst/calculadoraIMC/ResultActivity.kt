package com.example.androidfirst.calculadoraIMC

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.androidfirst.R
import com.example.androidfirst.calculadoraIMC.CalculadoraIMCActivity.Companion.IMC_RESULT

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResultType: TextView
    private lateinit var resultadoIMC: TextView
    private lateinit var tvDesc: TextView
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resilt)
        val result = intent.extras?.getFloat(IMC_RESULT) ?: -1.0f
        initComponent()
        initListeners()
        renderUI(result)
    }

    private fun initComponent() {
        this.tvResultType = findViewById<TextView>(R.id.tvResultType)
        this.resultadoIMC = findViewById<TextView>(R.id.resultadoIMC)
        this.tvDesc = findViewById<TextView>(R.id.tvDesc)
        this.btnCalcular = findViewById<Button>(R.id.btnCalcular)
    }

    private fun initListeners() {
        btnCalcular.setOnClickListener {
            navigateToIMC()
        }
    }

    private fun navigateToIMC() {
        val intent = Intent(this, CalculadoraIMCActivity::class.java)
        startActivity(intent)
    }

    fun clasificarIMC(imc: Float): Unit {
        resultadoIMC.text = imc.toString()
        when (imc) {
            in 0.00..18.49 -> {
                tvResultType.text = getString(R.string.inferior)
                tvResultType.setTextColor(ContextCompat.getColor(this, R.color.amarillo))
                tvDesc.text = getString(R.string.descinferior)
            }

            in 18.50..24.99 -> {
                tvResultType.text = getString(R.string.normal)
                tvResultType.setTextColor(ContextCompat.getColor(this, R.color.green))
                tvDesc.text = getString(R.string.descnormal)
            }

            in 25.00..29.99 -> {
                tvResultType.text = getString(R.string.superior)
                tvResultType.setTextColor(ContextCompat.getColor(this, R.color.amarillo))
                tvDesc.text = getString(R.string.descsuperior)
            }

            in 30.0..99.99 -> {
                tvResultType.text = getString(R.string.obesidad)
                tvResultType.setTextColor(ContextCompat.getColor(this, R.color.rojo))
                tvDesc.text = getString(R.string.descobesidad)
            }

            else -> {
                tvResultType.text = getString(R.string.error)
                tvResultType.setTextColor(ContextCompat.getColor(this, R.color.rojo))
                resultadoIMC.text = getString(R.string.error)
                tvDesc.text = getString(R.string.error)
            }
        }
    }

    private fun renderUI(result: Float) {
        clasificarIMC(result)
    }

}