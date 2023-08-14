package services;

import java.util.Scanner;

import entities.Perro;
import entities.Persona;

public class PersonaService {
    Scanner scan = new Scanner(System.in);

    public Persona crearPersona() {
        System.out.print("\nNombre: ");
        String name = scan.nextLine();
        System.out.print("\nApellido: ");
        String surname = scan.nextLine();
        System.out.print("\nEdad: ");
        int age = scan.nextInt();
        scan.nextLine();    //throwaway scan.
        System.out.print("\nDNI: ");
        int dni = scan.nextInt();
        scan.nextLine();//Throwaway scan.

        return new Persona(name, surname, age, dni);
    }

    public boolean adoptarMascota(Persona persona, Perro dog) {
        if (persona.getDog() == null) {
            persona.setDog(dog);
            return true;
        }
        System.out.println("La persona ya tenía mascota. No puede adoptar un nuevo perro.");
        return false;
    }

    public void mostrarPersona(Persona persona) {
        System.out.println(persona);
        System.out.println("Los datos de su mascota son: ");
        System.out.println(persona.getDog());
    }
}
