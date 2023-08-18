package Ej3.entities;

import Ej3.enums.Color;

public class Card {
    private int num;
    private Color color;
    public static final int[] valores = {1,2,3,4,5,6,7,10,11,12};


    //Constructor
    public Card(int num, Color color) {
        this.num = num;
        this.color = color;
    }
    
    //Getters & Setters.
    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //toString()
    @Override
    public String toString() {
        return
            this.num + " of " + getColor().toString().toLowerCase();
    }   
}


/*Una carta tiene un número entre 1 y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas).
 */