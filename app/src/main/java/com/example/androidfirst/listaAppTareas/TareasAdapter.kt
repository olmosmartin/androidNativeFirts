package com.example.androidfirst.listaAppTareas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfirst.R

class TareasAdapter (private val Tareas: List<Tarea>):
    RecyclerView.Adapter<TareasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarea, parent, false)
        return TareasViewHolder(view)
    }

    override fun onBindViewHolder(holder: TareasViewHolder, position: Int) {
        holder.render(Tareas[position])
    }

    override fun getItemCount()= Tareas.size
}