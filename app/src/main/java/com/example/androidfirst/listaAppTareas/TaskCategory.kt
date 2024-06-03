package com.example.androidfirst.listaAppTareas

//(var isSelected: Boolean = false) agrega por defecto isSelected en falso a todos los object
sealed class TaskCategory(var isSelected: Boolean = true) {
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other : TaskCategory()

}

