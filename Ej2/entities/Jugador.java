package Ej2.entities;


public class Jugador {
    public static int id;
    private String name;
    private boolean mojado;

    //Empty constructor.
    public Jugador() {
        id++;
        setName("Player " + id);
        setMojado(false);
    }

    //Getters & Setters.
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMojado() {
        return this.mojado;
    }

    public boolean getMojado() {
        return this.mojado;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }
    
    public boolean disparo(RevolverAgua r) {
        if (r.mojar()) {
            setMojado(true);
            r.siguienteChorro();
            return true;   
        }
        r.siguienteChorro();
        return false;
    }
}
/*Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del jugador),
nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica si está mojado o no el jugador).
El número de jugadores será decidido por el usuario, pero debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
Métodos:
• disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de mojar() y siguienteChorro() de Revolver.
El jugador se apunta, aprieta el gatillo y si el revolver tira el agua, el jugador se moja.
El atributo mojado pasa a false y el método devuelve true, sino false. */