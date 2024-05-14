package com.example.androidfirst.ejercicios

/*

Imagina que necesitas crear una app de reproducción de música.

Crea una clase que pueda representar la estructura de una canción. La clase Song debe incluir estos elementos de código:

Propiedades para el título, el artista, el año de publicación y el recuento de reproducciones
Propiedad que indica si la canción es popular (si el recuento de reproducciones es inferior a 1,000, considera que es poco popular)
Un método para imprimir la descripción de una canción en este formato:
"[Título], interpretada por [artista], se lanzó en [año de lanzamiento]".

RESULTADO
 */

fun main() {
    val cancion1 = Song("cancion nombre", "nombre del artista", 1990, 1000000)
    cancion1.printDescripcion();
    println(cancion1.esPopular);
    println(cancion1.esPopular2);
    println(cancion1.esPopular(1000001));
}

class Song(val titulo: String, val artista: String, val publicación: Int, val recuentoReproducciones: Int) {

    val esPopular: Boolean
        get() = recuentoReproducciones >= 1000

    //otra forma
    val esPopular2: Boolean = recuentoReproducciones >= 1000

    // Definición de la función esPopular que recibe un parámetro para decidir si es popular o no
    fun esPopular(limite: Int): Boolean {
        return recuentoReproducciones >= limite
    }

    fun printDescripcion() {
        println("$titulo, interpretada por $artista, se lanzó en $publicación.")
    }
}