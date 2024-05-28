package com.example.androidfirst.listaAppTareas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfirst.R

class CategoryAdapter(private val Categories: List<TaskCategory>):
    RecyclerView.Adapter<CategoriesViewHolder>() {

    /*
        acá va la vista que se crearon de las cards,
        "infla" el layout con la card de una sola categoria
        y la pone en el viewHolder para retornar la vista de la categoria
    */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_categorias, parent, false)
        return CategoriesViewHolder((view))
    }

    /*
        le pasa una categoria en especial a cada view holder
     */
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(Categories[position])
    }

    /*
        Retorna el número total de elementos en el conjunto de datos. En este caso, sería el tamaño de la lista Categories
        en kotlin seria lo mismo poner esto: override fun getItemCount()= Categories.size
     */
    override fun getItemCount(): Int {
        return Categories.size
    }

}