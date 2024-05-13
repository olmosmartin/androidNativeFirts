package com.example.androidfirst

fun main() {
    println(findMonth(12));
    println(encontrarTrimestre(8));
    println(encontrarSemestre(3));
    resultado("5");
}

fun findMonth (month:Int):String {
    return when (month){
        1 -> {
            return "Enero" // si lo pongo entre llave puedo hacer varias cosas en el caso 1
        }
        2 -> "Febrero"
        3 -> "Marzo"
        4-> "Abril"
        5 -> "Mayo"
        6 -> "Junio"
        7 -> "Julio"
        8 -> "Agosto"
        9 -> "Septiembre"
        10 -> "Octubre"
        11 -> "Noviembre"
        12 -> "Diciembre"
        else -> "error"
    }
}

fun encontrarTrimestre (month:Int):String = when (month){
        1, 2, 3 -> "primer trimestre"
        4, 5, 6 -> "segundo trimestre"
        7, 8, 9 -> "tercero trimestre"
        10, 11, 12 -> "cuarto trimestre"
        else -> "error"
}

fun encontrarSemestre (month:Int):String = when{ // se puede usar sin parametro
        month in 1..6 -> "primer semestre"
        month in 7..12 -> "segundo semestre"
        month < 1 || month > 12 -> "no es un numer válido"
        else -> "error"
}

fun resultado (value:Any):Unit { //Unit es como void
    when (value) {
        is Int -> println(value + value) //puedo chequear qué tipo de datos es con in Tipo
        is String -> println(value)
        is Boolean -> if (value) println("es verdadero")
        else -> println("otro tipo")
    }
}