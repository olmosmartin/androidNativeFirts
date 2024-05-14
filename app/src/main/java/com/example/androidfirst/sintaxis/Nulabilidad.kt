package com.example.androidfirst.sintaxis

fun main () {
    var variable:String? = null;

    println(variable?.get(0)); // si es null me dice null pero no se rompe, si no es null me trae el primer caracter

    println(variable?.get(0) ?: "es null"); // con el operador elvis puedo poner si es null (solo chequea null) que haga otra cosa

    println(null?:"algo")

    println(variable!!.get(1)); //cuando le pongo  !! estoy diciendo q no es null , si es null va a romper



}

