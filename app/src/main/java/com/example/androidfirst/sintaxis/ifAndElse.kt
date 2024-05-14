package com.example.androidfirst.sintaxis

fun main(){
    ifAndElse("pedrito")
}

fun ifAndElse(nombre:String):Unit {
    if( nombre == "martin" ) {
        println("bienvenido martin")
    } else if (nombre == "pedrito"){
        println("bienvenido pedrito")
    } else {
        println("nombre incorrecto")
    }
};