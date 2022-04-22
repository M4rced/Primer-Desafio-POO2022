package com.desafiouno.calculadora.dominio;

import java.text.DecimalFormat;

public class Redondear {
    private DecimalFormat numeroRedondeado = new DecimalFormat("00");

    public double redondear(double numero){
        return Double.parseDouble(numeroRedondeado.format(numero).replace(",","."));
    }
}
