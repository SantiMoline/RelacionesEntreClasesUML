package Ej2.entities;

public class RevolverAgua {
    private int currentPos;
    private int waterPos;


    public RevolverAgua() {
        this.currentPos = (int) (Math.random() * 6) + 1;
        this.waterPos = (int) (Math.random() * 6) + 1;
    }


    public int getCurrentPos() {
        return this.currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public int getWaterPos() {
        return this.waterPos;
    }

    public void setWaterPos(int waterPos) {
        this.waterPos = waterPos;
    }

    public void llenarRevolver() {
        setCurrentPos((int) (Math.random()*6) + 1);
        setWaterPos((int) (Math.random()*6) + 1);
    }

    public boolean mojar() {
        return getCurrentPos() == getWaterPos();
    }

    public void siguienteChorro() {
        if (this.currentPos == 6) {
            setCurrentPos(1);
        } else setCurrentPos(this.getCurrentPos() + 1);
    }


    @Override
    public String toString() {
        return
            "\nPosición actual: " + getCurrentPos() +
            "\nPosición del agua: " + getWaterPos();
    }

}
/*Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición del tambor que se dispara, puede que esté el agua o no) y
posición agua (la posición del tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
Métodos: 
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)*/