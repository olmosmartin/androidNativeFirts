package com.example.androidfirst.sintaxis

fun main () {
    listaInmutable();
    listaMutable();
}

fun listaInmutable() {
    val soloLectura:List<String> =  listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    println(soloLectura.size);
    println(soloLectura); //usa un tostring por defecto
    println(soloLectura[0]);
    println(soloLectura.last()); //ultimo valor
    println(soloLectura.first());

    val ejemplo = soloLectura.filter { dia -> dia[0]=='M' } //estoy tomando el pimer char del string dia
    println("Días que empiezan con M $ejemplo");

    soloLectura.forEach{ dia -> println(dia)}

}

fun listaMutable() {
    var lista:MutableList<String> =  mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(lista);
    lista.add("itemnuevo")
    println(lista);
    lista.add(0,"primerdianuevo") //agrego en una posicion determinada
    println(lista);

    if(lista.isNotEmpty()){
        println("la lista no está vacia")
    }

}