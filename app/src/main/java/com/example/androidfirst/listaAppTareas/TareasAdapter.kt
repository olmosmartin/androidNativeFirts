package com.example.androidfirst.listaAppTareas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfirst.R

class TareasAdapter (var Tareas: List<Tarea>, private val onTareaSelected: (Int) -> Unit):
    RecyclerView.Adapter<TareasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarea, parent, false)
        return TareasViewHolder(view)
    }

    override fun onBindViewHolder(holder: TareasViewHolder, position: Int) {
        holder.render(Tareas[position])
        //uso itemview para acceder a la celda que se renderiza
        val cbTarea = holder.itemView.findViewById<CheckBox>(R.id.cbTarea)
        cbTarea.setOnClickListener{
            onTareaSelected(position)
        }
        // itemView es toda la celda entera del item que renderiza
        holder.itemView.setOnClickListener {onTareaSelected(position)}
    }

    override fun getItemCount()= Tareas.size
}