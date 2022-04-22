package com.desafiouno.juego.dominio;

import java.util.Arrays;
import java.util.List;

public class Juego {
    private String nombreJugador;
    private int ganadasJugador;
    private int ganadasPC;
    private int empate;
    private String njuego;

    public static final int FUEGO = 0;
    public static final int AGUA = 1;
    public static final int HIELO = 2;
    public static final List<Integer> OPCION = Arrays.asList(FUEGO,AGUA,HIELO);

    public Juego(String njuego){
        this.njuego = njuego;
    }

    public int jugadaPc(){
        int respPc = (int) (Math.random() * 2 + 1);
        return respPc;
    }

    public String jugar(int jugadaJugador, int jugadaPc ){
        if(jugadaJugador == FUEGO && jugadaPc == HIELO){
            ganadasJugador++;
            return "Ganaste " + getNombreJugador();
        }else if (jugadaJugador == HIELO && jugadaPc == AGUA){
            ganadasJugador++;
            return "Ganaste " + getNombreJugador();
        }else if (jugadaJugador == AGUA && jugadaPc == FUEGO){
            ganadasJugador++;
            return "Ganaste " + getNombreJugador();
        } else if (jugadaJugador == jugadaPc){
            empate++;
            return "Empate";
        }else{
            ganadasPC++;
            return "Gana Pc";
        }
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getGanadasJugador() {
        return ganadasJugador;
    }

    public void setGanadasJugador(int ganadasJugador) {
        this.ganadasJugador = ganadasJugador;
    }

    public int getGanadasPC() {
        return ganadasPC;
    }

    public void setGanadasPC(int ganadasPC) {
        this.ganadasPC = ganadasPC;
    }

    public int getEmpate() {
        return empate;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }
}
