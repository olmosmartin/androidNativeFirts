package com.example.androidfirst.listaAppTareas

import android.content.Context
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
        this.tvTareaNombre.text = Tarea.titulo
    }

}