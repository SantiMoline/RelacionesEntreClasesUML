import java.util.ArrayList;

import entities.Perro;
import entities.Persona;
import services.PerroService;
import services.PersonaService;

public class Ej1 {
    public static void main(String[] args) {
        PersonaService ps = new PersonaService();
        PerroService perroService = new PerroService();

        ArrayList<Persona> personas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            personas.add(ps.crearPersona());
            System.out.println("Persona " + (i+1) + " registrada.");
        }

        ArrayList<Perro> mascotas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            mascotas.add(perroService.crearPerro());
            System.out.println("Mascota " + (i+1) + " registrada.");
        }

        System.out.println("Se asignan los perros a las personas generadas.");
        for (int i = 0; i < personas.size(); i++) {
            ps.adoptarMascota(personas.get(i),mascotas.get(i));
        }

        System.out.println("Se muestra la información final");
        for (Persona persona : personas) {
            ps.mostrarPersona(persona);
        }
    }
}
/*Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño;
y la clase Persona con atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo,
mostrar desde la clase Persona, la información del Perro y de la Persona. */