package com.example.androidfirst

//variables

fun main(){
    val name = "tincho"; //acá sabe solo qué tipo es aunque no se especifique
    var nameVar = "tincho"; // var es para variables y val para constantes
    val unString:String  = "holaa";
    val numero:Int = 24;
    val numero2:Long = 24;
    val decimal:Float = 10.8f;
    val decimalLargo:Double = 10.9;

    //variables alfanuméricas
    val caracter:Char = 'e'
    val caracter2:Char = '2'

    //boolean
    val bool:Boolean = true;


    //los print imprimen en la misma linea
    print("hola $unString $name mundo");
    print("holamundo");

    //println es para saltar de linea
    println("una linea")
    println("otra linea")

    var sumExample = numero + decimal; //esto es Float por defecto
    var sumExample2 = numero + decimal.toInt(); //convierto en decimal en int y devuelve un int
    var varParaImprimir:String = "$sumExample $sumExample2"
    println(varParaImprimir);

}