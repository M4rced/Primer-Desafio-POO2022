package com.desafiouno.calculadora.app;

/*Desarrollado por:
-Cristian David Ospina Ospina
-Yenny Marcela Vargas Rincón
 */

import com.desafiouno.calculadora.dominio.Calculadora;

import javax.swing.*;
import java.util.Arrays;

public class AppCalculadora {
    static ImageIcon icono = new ImageIcon(AppCalculadora.class.getResource("/Imagenes/calculadora.jpg"));
    private static final int SUMAR = 0;
    private static final int RESTAR = 1;
    private static final int MULTIPLICAR = 2;
    private static final int DIVIDIR = 3;

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        JCheckBox redondear = new JCheckBox("Redondear");
        do {
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione la operacion que desea realizar ",
                    "Calculadora", 0, JOptionPane.PLAIN_MESSAGE, icono, Arrays.asList("Sumar", "Restar", "Multiplicar", "Dividir",
                            redondear).toArray(), null);
            switch (seleccion){
                case SUMAR -> {
                    double suma = Calculadora.sumar();
                    if (redondear.isSelected()){
                        suma = calculadora.redondear(suma);
                    }
                    mostrarResultado(suma,"Sumar");
                    break;
                }
                case RESTAR -> {
                    double resta = Calculadora.restar();
                    if (redondear.isSelected()){
                        resta = Calculadora.redondear(resta);
                    }
                    mostrarResultado(resta,"Restar");
                    break;
                }
                case MULTIPLICAR -> {
                    double multiplicacion = Calculadora.multiplicar();
                    if(redondear.isSelected()){
                        multiplicacion = Calculadora.redondear(multiplicacion);
                    }
                    mostrarResultado(multiplicacion,"Multiplicar");
                    break;
                }
                case DIVIDIR -> {
                    double division = Calculadora.dividir();
                    if(redondear.isSelected()){
                        division = calculadora.redondear(division);
                    }
                    mostrarResultado(division,"Dividir");
                    break;
                }
                case JOptionPane.CLOSED_OPTION -> {
                    System.exit(0);
                }
            }
        }while (true);
    }
    private static void mostrarResultado(double resultado, String titulo){
        JOptionPane.showMessageDialog(null,"El resultado es: " + resultado, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
