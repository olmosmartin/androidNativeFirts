package com.example.androidfirst.sintaxis

//variables

fun main(){
    pruebasVariables();
    variablesNumericas();
    println(showName("tincho", "apellidoe.e"));
    println(showName("tincho"));
    println(returnPorDefecto("tincho"));
    println(funcionLambda("tincho", "ape"));
    funcionComoParametro(::showName);//se utiliza el operador de referencia de función :: para pasar la función showName sin invocarla
}

fun pruebasVariables () {
    val name = "tincho"; //acá sabe solo qué tipo es aunque no se especifique
    var nameVar = "tincho"; // var es para variables y val para constantes
    val unString:String  = "holaa";

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

}

fun variablesNumericas () {

    val numero:Int = 24;
    val numero2:Long = 24;
    val decimal:Float = 10.8f;
    val decimalLargo:Double = 10.9;
    var sumExample = numero + decimal; //esto es Float por defecto
    var sumExample2 = numero + decimal.toInt(); //convierto en decimal en int y devuelve un int
    var varParaImprimir:String = "$sumExample $sumExample2";
    println(varParaImprimir);
}

fun showName (name:String, apellido:String="apellidopordefecto"):String {
    return "tu nombre es $name $apellido";
}

fun returnPorDefecto (name:String, apellido:String="apellidopordefecto"):String = "tu nombre es $name $apellido";

fun funcionComoParametro (funcion: (String, String)->String){
    println(funcion("nombre", "apellido"));
}

val funcionLambda = { name:String, apellido:String -> "tu nombre es $name $apellido"};

