package com.example.androidfirst.listaAppTareas

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfirst.R

//acá en el viewHolder es donde se puede acceder a los elemento adentro de la vista que
//cree especialmente para poner en el adapter en el onCreateViewHolder y que va a renderizar como
//elemento en mi lista de recyclerview
class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvCategorias:TextView = view.findViewById(R.id.tvCategoriaNombre)
    private val vDivider:View = view.findViewById(R.id.vDivider)
    private val context: Context = view.context // Agregamos una referencia al contexto

    fun render(taskCategory: TaskCategory) {
        when (taskCategory) {
            TaskCategory.Business -> {
                tvCategorias.text = context.getString(R.string.business)
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context, R.color.lista_negocios))
            }
            TaskCategory.Other -> {
                tvCategorias.text = context.getString(R.string.other)
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context, R.color.lista_otros))
            }
            TaskCategory.Personal -> {
                tvCategorias.text = context.getString(R.string.personal)
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context, R.color.lista_personal))
            }
        }
    }
}