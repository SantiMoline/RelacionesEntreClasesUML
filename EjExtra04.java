import java.util.Scanner;

import EjExtra04.entities.Simulador;

public class EjExtra04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Egg Voting Simulator!");
        Simulador sim = new Simulador();
        
        System.out.print("How many students are in the class? ");
        int n = scan.nextInt();
        System.out.println("Generating the classroom......");
        sim.registerStudents(n);
        System.out.println("The classroom has been generated. Here is the list of students that are attending the course: ");
        sim.showStudents();
        System.out.println("Let's allow the students to vote...");
        sim.voting();

        System.out.println("Showing the each student and its casted votes: ");
        sim.showStudentsAndItsVotes();

        System.out.println("The facilitators are going to be: ");
        sim.showList(sim.getFacilitators());

        System.out.println("The substitutes facilitatores are going to be: ");
        sim.showList(sim.getSubstitutes());

        scan.close();
    }
}
/*
 * Desarrollar un simulador del sistema de votación de facilitadores en Egg-
El sistema de votación de Egg tiene una clase llamada Alumno con los siguientes atributos: nombre completo, DNI y cantidad de votos.
Además, crearemos una clase Simulador que va a tener los métodos para manejar los alumnos y sus votaciones. Estos métodos serán llamados desde el main.
• La clase Simulador debe tener un método que genere un listado de alumnos manera aleatoria y lo retorne.
Las combinaciones de nombre y apellido deben ser generadas de manera aleatoria. Nota: usar listas de tipo String para generar los nombres y los apellidos.
• Ahora hacer un generador de combinaciones de DNI posibles, deben estar dentro de un rango real de números de documentos. Y agregar a los alumnos su DNI.
Este método debe retornar la lista de dnis.
• Ahora tendremos un método que, usando las dos listas generadas, cree una cantidad de objetos Alumno, elegidos por el usuario, y le asigne los nombres y
los dnis de las dos listas a cada objeto Alumno. No puede haber dos alumnos con el mismo dni, pero si con el mismo nombre.
• Se debe imprimir por pantalla el listado de alumnos.
• Una vez hecho esto debemos generar una clase Voto, esta clase tendrá como atributos,
un objeto Alumno que será el alumno que vota y una lista de los alumnos a los que votó.
• Crearemos un método votación en la clase Simulador que, recibe el listado de alumnos y para cada alumno genera tres votos de manera aleatoria.
En este método debemos guardar al alumno que vota, a los alumnos a los que votó y sumarle uno a la cantidad de votos a cada alumno que reciba un voto, que es un atributo de la clase Alumno.
Tener en cuenta que un alumno no puede votarse a sí mismo o votar más de una vez al mismo alumno. Utilizar un hashset para resolver esto.
• Se debe crear un método que muestre a cada Alumno con su cantidad de votos y cuales fueron sus 3 votos.
 */