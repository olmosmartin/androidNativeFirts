package com.example.androidfirst.listaAppTareas

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.androidfirst.R

class ListaAppMainActivity : AppCompatActivity() {

    //le paso las 3 opciones q hice en mi clase sealed TaskCategory para no hardcodearlas en la lista
    //seria como hacer listOf("business", "personal", "other")
    private var Categorias = listOf(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other
    )

    private var tareas = mutableListOf(
        Tarea("nombre1", TaskCategory.Business, false),
        Tarea("nombre2", TaskCategory.Personal, false),
        Tarea("nombre3", TaskCategory.Other,  false)
    )

    //los recyclerView necesitan un adapter y un viewHolder
    private lateinit var rvCategory: RecyclerView
    private lateinit var categoriesAdapter: CategoryAdapter

    private lateinit var rvTareas: RecyclerView
    private lateinit var tareasAdapter: TareasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_app_main)

        initComponent()
        renderUI()
    }

    private fun initComponent() {
        this.rvCategory = findViewById<RecyclerView>(R.id.rvCategorias)
        this.rvTareas = findViewById<RecyclerView>(R.id.rvTareas)
    }

    private fun renderUI() {
        categoriesAdapter = CategoryAdapter(Categorias)
        rvCategory.adapter = categoriesAdapter
        //esto es para poner la orientacion de la lista en horizontal, pero yo lo hice en el layout asi:
        //        android:orientation="horizontal"
        //        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        //rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        tareasAdapter = TareasAdapter(tareas)
        rvTareas.adapter = tareasAdapter
    }
}