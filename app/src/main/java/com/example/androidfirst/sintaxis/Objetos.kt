package com.example.androidfirst.sintaxis

class Auto(private var marca: String, var modelo: String) { //marca es private asi que solo se puede modificar con un metodo publico como un setter

    // Constructor sobrecargado
    constructor(marca: String) : this(marca, "Modelo no especificado")

    // puedo declarar el atributo anio aparte sin que este en el constructor y toma el valor por defecto
    var anio: Int = 0
        get() = field // Este getter pertenece a la propiedad 'anio'
        set(value) {
            if (value > 0) {
                field = value // Este setter también pertenece a 'anio'
            } else {
                println("Año no válido")
            }
        }
    // puedo declarar el atributo pintura aparte sin que este en el constructor y toma el valor por defecto
    var pintura: String = "Color no especificado"
        get() = field // Este getter pertenece a la propiedad 'pintura'
        set(value) {
            if (value.isNotBlank()) {
                field = value // Este setter pertenece a 'pintura'
            } else {
                println("Pintura no válida")
            }
        }

    // Setter personalizado para 'marca'
    var marcaVisible: String
        get() = marca
        set(value) {
            if (value.isNotBlank()) {
                this.marca = value
            } else {
                println("Marca no puede estar vacía")
            }
        }

    override fun toString(): String {
        return "Auto(marca='$marca', modelo='$modelo', año=$anio, color=$pintura)"
    }
}

fun main() {
    val auto: Auto = Auto("Reno", "12")
    val auto2: Auto = Auto("Reno" )

    println("auto: $auto")
    println("auto2: $auto2")

    auto.anio = 1990;
    auto.pintura = "roja";
    auto.marcaVisible = "marcaNueva";

    println("auto: $auto")

    // auto.marca = "marcaNueva2"; //esto no se puede porque marca es private

}