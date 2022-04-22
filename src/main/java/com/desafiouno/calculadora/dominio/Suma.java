package com.desafiouno.calculadora.dominio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Suma {
    private List<Double> numeros;
    private static final int AGREGAR = 0;
    private static final int SUMAR = 1;

    public double sumar() {
        double suma = 0;
        boolean ciclo = true;
        numeros = new ArrayList<>();
        do {
            try {
                Double numero = Double.valueOf(JOptionPane.showInputDialog(null, "Ingrese un numero: ",
                        "Sumar", JOptionPane.QUESTION_MESSAGE));
                this.numeros.add(numero);
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un numero valido", "Sumar",
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (this.numeros.size() < 2) {
                ciclo = true;
            } else {
                int opcion = JOptionPane.showOptionDialog(null, "Desea agregar otro numero?", "Sumar",
                        0, JOptionPane.INFORMATION_MESSAGE, null, Arrays.asList("Agregar", "Sumar").toArray(), null);
                switch (opcion) {
                    case AGREGAR -> {
                        ciclo = true;
                        break;
                    }
                    case SUMAR -> {
                        ciclo = false;
                        break;
                    }
                    case JOptionPane.CLOSED_OPTION -> {
                        System.exit(0);
                    }
                }
            }
        }while (ciclo);
        for (double num: this.numeros){
            suma += num;
        }
        numeros.clear();
        return suma;
    }
}
