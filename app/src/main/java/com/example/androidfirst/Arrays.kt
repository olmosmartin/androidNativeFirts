package com.example.androidfirst

fun main() {
    val dias = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo");

    println("array a string:" +  dias.contentToString())
    println("dias pos 1: " + dias[1])
    println("tramaño array: " + dias.size);

    //bucles

    for(index in dias.indices){
        println("dia by index: " + dias[index])
    }

    for( (index,  dia) in dias.withIndex()){
        println("posicion: $index valor: $dia");
    }

    for(dia in dias){
        println("dia: $dia")
    }

    // Supongamos que quieres añadir " - Día" a cada elemento del array
    val diasModificados = dias.map { dia -> "$dia - Día" }

    // Ahora, si quieres imprimir cada elemento del nuevo array
    diasModificados.forEach { diaModificado ->
        println(diaModificado)
    }

    ///////////////////////////////////////////////////////

    val numeros = arrayOf(1, 2, 3, 4, 5)

    // Usar 'map' para transformar el array
    // los lambda DEVUELVE SIEMPRE LA ULTIMA LINEA DEL ARRAY
    val numerosModificados = numeros.map { numero ->
        println("paso por el numero $numero")
        if (numero%2==0){
            numero + 2
        } else {
            numero + 3 // No se necesita 'return' como en javascript porque siempre devuelve la ultima linea del array
        }
        //8 // si debaja esta linea con un numero hardcodeado como "8" iba a devolver un array con 7 numeros 8
    }

    // Imprimir el nuevo array
    numerosModificados.forEach { numeroModificado ->
        println(numeroModificado)
    }

    val numeros2 = arrayOf(1, 2, 3, 4, 5)
    val numerosPares = numeros2.filter { it % 2 == 0 }
    println(numerosPares) //como numeros pares es una lista se puede usar asi porque usa el toString() por defecto

    val desordenados = arrayOf(5, 3, 1, 4, 2)
    val ordenados = desordenados.sorted()
    println(ordenados)

    val suma = numeros.reduce { acumulado, numero -> acumulado + numero }
    println(suma)

    //takeWhile toma elementos de una colección mientras se cumpla una condición.

    val numeros3 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    val menoresA5 = numeros3.takeWhile { it < 5 }
    println(menoresA5) // Imprime: [1, 2, 3, 4]

    //dropWhile descarta elementos mientras se cumpla una condición.
    val numeros4 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    val mayoresA5 = numeros4.dropWhile { it < 5 }
    println(mayoresA5) // Imprime: [5, 6, 7, 8]

}