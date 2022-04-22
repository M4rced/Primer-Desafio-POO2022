package com.desafiouno.juego.app;

import com.desafiouno.juego.dominio.Juego;

/*Desarrollado por:
-Cristian David Ospina Ospina
-Yenny Marcela Vargas Rincón
 */

import javax.swing.*;
import java.util.Arrays;

public class AppJuego {
    static ImageIcon icono = new ImageIcon(AppJuego.class.getResource("/Imagenes/sensei tres elementos.png"));
    private static final int OPCION_JUGAR = 0;
    private static final int OPCION_PUNTAJE = 1;
    private static final int OPCION_INSTRUCCIONES = 2;
    private static final int OPCION_CAMBIAR_NOMBRE = 3;

    public static void main(String[] args) {
        Juego juego = new Juego("🕹SENSEI DE LOS TRES ELEMENTOS🔥🚿⛰ ");

        while (true) {
            int opcion = JOptionPane.showOptionDialog(null, "SENSEI DE LOS TRES ELEMENTOS", "Card Jitsu",
                    0, 0, icono,
                    Arrays.asList("Jugar", "Puntaje", "Instrucciones", "Cambiar Nombre Jugador").toArray(), null);

            switch (opcion) {

                case OPCION_JUGAR:
                    if(juego.getNombreJugador() == null){
                        juego.setNombreJugador(IngresarNombre());
                    }
                    JOptionPane.showMessageDialog(null,"Bienvenido(a)  " + juego.getNombreJugador());
                    int JugadaPc = juego.jugadaPc();
                    int jugadaElegidaJugador = JOptionPane.showOptionDialog(null,juego.getNombreJugador()+", Selecciona la carta que deseas lanzar a tu oponente: \n "+
                            "                              Exitos mi querido(a) Ninja"
                            , "Card Jitsu",0,
                            JOptionPane.QUESTION_MESSAGE,icono,Arrays.asList("FUEGO","AGUA","HIELO").toArray(),null);
                    JOptionPane.showMessageDialog(null, juego.getNombreJugador() +" Selecciono: \n"+
                            Jugada(jugadaElegidaJugador)+"\n"+"Pc selecciono:\n"+Jugada(JugadaPc));
                    String MostrarResultado = juego.jugar(jugadaElegidaJugador,JugadaPc);
                    JOptionPane.showMessageDialog(null,MostrarResultado);
                    break;

                case OPCION_PUNTAJE:
                    if(juego.getNombreJugador() == null){
                        juego.setNombreJugador(IngresarNombre());
                    }
                    JOptionPane.showMessageDialog(null,"                PUNTAJES \n "+ juego.getNombreJugador()+": "+juego.getGanadasJugador()
                    +"\n Pc: " +juego.getGanadasPC()+"\n Empates: "+ juego.getEmpate());
                    break;

                case OPCION_INSTRUCCIONES:
                    JOptionPane.showMessageDialog(null,"INSTRUCCIONES\n\n Las reglas del Card Jitsu, " +
                            "son muy sencillas mi querido(a) Ninja \n Para lograr ser un sensei y ganarle a tu oponente, solo debestes tener en cuenta las siguientes reglas:\n " +
                            "1.El fuego vence al hielo derritiendolo \n 2.El hielo vence al agua cogelandolo\n 3." +
                            "El agua vence al fuego apagandolo \n\n  " +
                            "Importante: Debes recordar que si tu jugada es la misma que la de tu oponente, quedaran en empate, en tal " +
                            "caso deveran volver a jugar hasta que se decida un ganador\n\n                                   " +
                            "                                                       Si logras dominar el arte del Card Jitsu, te convertiras en todo un SENSEI! \n\n"+
                            "                                                                                                  Muchos exitos y que la fuerza de la naturaleza te acompane");
                    break;

                case OPCION_CAMBIAR_NOMBRE:
                    juego.setNombreJugador(IngresarNombre());
                    juego.setGanadasJugador(0);
                    juego.setGanadasPC(0);
                    juego.setEmpate(0);
                    break;

                case JOptionPane.CLOSED_OPTION:
                    return;
            }
        }
    }

    public static String IngresarNombre(){
        String nombreJugador;

        do {
            nombreJugador = JOptionPane.showInputDialog(null,"Ingrese un nombre: ");
        }while(nombreJugador == null || nombreJugador.trim().isEmpty());
        return nombreJugador;
    }

    public static String Jugada(int jugada){
        if(jugada == 0){
            return "FUEGO";
        }else if (jugada == 1){
            return "AGUA";
        }else{
            return "HIELO";
        }
    }
}

