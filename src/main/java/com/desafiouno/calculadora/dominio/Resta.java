package com.desafiouno.calculadora.dominio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Resta {
    private List<Double> numeros;
    private static final int AGREGAR = 0;
    private static final int RESTAR = 1;

    public double restar(){
        double resta = 0;
        boolean ciclo = true;
        numeros = new ArrayList<>();
        do {
            try{
                double numero = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese un numero: ", "Restar",
                       JOptionPane.INFORMATION_MESSAGE ));
                this.numeros.add(numero);
            }
            catch (Exception error){
                JOptionPane.showMessageDialog(null,"Por favor, ingrese un numero valido","Restar",JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (this.numeros.size() < 2){
                ciclo = true;
            }
            else{
                int opcion = JOptionPane.showOptionDialog(null, "Desea agregar otro numero a esta operacion?",
                        "Restar",0,JOptionPane.INFORMATION_MESSAGE,null,Arrays.asList("Agregar","Restar").toArray(),null);
                switch (opcion){
                    case AGREGAR -> {
                        ciclo = true;
                        break;
                    }
                    case RESTAR -> {
                        ciclo = false;
                        break;
                    }
                    case JOptionPane.CLOSED_OPTION -> {
                        System.exit(0);
                    }
                }
            }
        }while (ciclo);
        for(double num : this.numeros){
            resta = num;
        }
        numeros.clear();
        return resta;
    }
}
