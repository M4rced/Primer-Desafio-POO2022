package com.desafiouno.calculadora.dominio;

public class Calculadora {
    private static Suma sum = new Suma();
    private static Resta rest = new Resta();
    private static Multiplicacion multi = new Multiplicacion();
    private static Division divi = new Division();
    private static Redondear numeroRedondeado = new Redondear();

    public static double sumar(){
        return sum.sumar();
    }

    public static double restar(){
        return rest.restar();
    }

    public static double multiplicar(){
        return multi.multiplicar();
    }

    public static double dividir(){
        return divi.dividir();
    }

    public static double redondear(double numero){
        return numeroRedondeado.redondear(numero);
    }
}
