package com.example.androidfirst

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