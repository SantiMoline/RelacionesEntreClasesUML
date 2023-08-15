package Ej2.entities;

import java.util.ArrayList;

public class Juego {
    ArrayList<Jugador> jugadores;
    RevolverAgua weapon;


    public Juego() {
        jugadores = new ArrayList<>();
    }

    //Getters & Setters.
    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public RevolverAgua getWeapon() {
        return this.weapon;
    }

    public void setWeapon(RevolverAgua weapon) {
        this.weapon = weapon;
    }

    public void llenarJuego(int numOfPlayers) {
        for (int i = 0; i < numOfPlayers; i++) {
            this.jugadores.add(new Jugador());
        }
        this.weapon = new RevolverAgua();
    }

    public boolean ronda() {
        System.out.println("Comienza una nueva ronda! Good luck!");

        for (int i = 0; i < jugadores.size(); i++) {
            Jugador activePlayer = jugadores.get(i);
            if (activePlayer.disparo(weapon)) {
                System.out.println("El " + activePlayer.getName() + " se mojó :/. Game Over.");
                return true;
            }
            System.out.println("El " + activePlayer.getName() + " se salvó. Le pasa la pistola de agua al siguiente.");
        }
        return false;
    }





}
/*Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores y el revolver para guardarlos en los atributos del juego. 
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y aprieta el gatillo.
Sí el revolver tira el agua el jugador se moja y se termina el juego,
sino se moja, se pasa al siguiente jugador hasta que uno se moje.
Si o si alguien se tiene que mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.*/