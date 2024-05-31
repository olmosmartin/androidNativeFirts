package com.example.androidfirst.listaAppTareas

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaAppMainActivity : AppCompatActivity() {

    //le paso las 3 opciones q hice en mi clase sealed TaskCategory para no hardcodearlas en la lista
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

    private lateinit var btnAddTarea: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_app_main)

        initComponent()
        initListeners()
        renderUI()
    }

    private fun initComponent() {
        this.rvCategory = findViewById<RecyclerView>(R.id.rvCategorias)
        this.rvTareas = findViewById<RecyclerView>(R.id.rvTareas)
        this.btnAddTarea = findViewById<FloatingActionButton>(R.id.btnAddTarea)
    }

    private fun initListeners() {
        btnAddTarea.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_tareas)

        val btnDialog: Button = dialog.findViewById(R.id.btnDialog)
        val etAddTarea: EditText = dialog.findViewById(R.id.etAddTarea)
        val rgAddTarea: RadioGroup = dialog.findViewById(R.id.rgAddTarea)

        btnDialog.setOnClickListener{
            if (etAddTarea.text.toString().isNotEmpty()) {
                //obtengo el ID del radiobutton seleccionado
                val selectedId = rgAddTarea.checkedRadioButtonId
                //obtengo el radiobutton seleccionado a partir de su ID
                val selectedRadioButton: RadioButton = rgAddTarea.findViewById(selectedId)
                //asigna un TaskCategory según el texto q tenga el radio button
                val CategoriaSeleccionada: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.business) -> TaskCategory.Business
                    getString(R.string.personal) -> TaskCategory.Business
                    else -> TaskCategory.Other
                }

                tareas.add(Tarea(etAddTarea.text.toString(), CategoriaSeleccionada, false))
                //hay q agregarlo al adapter para q lo pinte en la vida
                actualizarTarea()
                dialog.hide()
            }
        }

        dialog.show()
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

    private fun actualizarTarea() {
        tareasAdapter.notifyDataSetChanged()
    }
}