package com.example.androidfirst.listaAppTareas

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfirst.R

class TareasViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val tvTareaNombre: TextView = view.findViewById(R.id.tvTareaNombre)
    private val cbTarea:CheckBox = view.findViewById(R.id.cbTarea)
    private val context: Context = view.context // Agregamos una referencia al contexto

    fun render(Tarea: Tarea) {

        if (Tarea.isChecked){
            //este codigo sirve para tacharlo
            this.tvTareaNombre.paintFlags = tvTareaNombre.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            //este codigo sirve para destacharlo
            this.tvTareaNombre.paintFlags = tvTareaNombre.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        this.cbTarea.isChecked = Tarea.isChecked

        this.cbTarea.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(context,
                //selecciono el color segun la categoría
                when (Tarea.categoria) {
                    TaskCategory.Personal -> R.color.lista_personal
                    TaskCategory.Business -> R.color.lista_negocios
                    else -> R.color.lista_otros
                })
            )

        this.tvTareaNombre.text = Tarea.titulo
    }

}