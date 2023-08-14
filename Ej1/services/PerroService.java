package services;

import java.util.Scanner;

import entities.Perro;

public class PerroService {
    Scanner scan = new Scanner(System.in);

    public Perro crearPerro() {
        System.out.print("Nombre del can: ");
        String name = scan.nextLine();
        System.out.print("Raza: ");
        String raza = scan.nextLine();
        System.out.println("Edad: ");
        int edad = scan.nextInt();
        scan.nextLine(); //Throwaway scan.
        System.out.println("Tamaño: ");
        String size = scan.nextLine();

        return new Perro(name, raza, edad, size);
    }

}
