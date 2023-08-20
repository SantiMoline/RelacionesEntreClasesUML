import java.util.Scanner;

import EjExtra01.entities.Dog;
import EjExtra01.entities.Person;
import EjExtra01.services.DogService;
import EjExtra01.services.PersonService;

public class EjExtra01 {
    static PersonService ps = new PersonService();
    static DogService ds = new DogService();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean active = true;

        System.out.println("-------Welcome to the dog refuge!-------");

        while (active) {
            showMenu();
            int opc = promptForOption(scan);
            switch (opc) {
                case 1:
                    ps.registerPerson(scan);
                    break;
                case 2:
                    ds.registerDog(scan);
                    break;
                case 3:
                    if(!ds.showDog(searchDogByName(scan)))
                        System.out.println("There is no Dog in our database with that name.");
                    break;
                case 4:
                    if (!ps.showPerson(searchPersonById(scan)))
                        System.out.println("There is no person with that ID in our database.");
                    break;
                case 5:
                    if (adopt(scan))
                        System.out.println("Congrats on the adoption! =)");
                    else 
                        System.out.println("Sorry we couldn't complete the process....");
                    break;
                case 6:
                    ps.showPeople();
                    break;
                case 7:
                    System.out.println("Thanks for coming. See you next time!");
                    active = false;
                    scan.close();
                    break;
            }

        }

    }

    /**
     * Prints the available options in a menu.
     */
    public static void showMenu() {
        System.out.println("1. Register person.");
        System.out.println("2. Register dog.");
        System.out.println("3. Search dog's information by name.");
        System.out.println("4. Search for a person's information by ID.");
        System.out.println("5. Adopt a dog.");
        System.out.println("6. Show the information of every person registered.");
        System.out.println("7. Exit.");
    }

    /**
     * Ask the user for a valid input that corresponds to one option in the menu.
     * 
     * @param scan (Scanner)
     * @return (int) The option chosen by the user.
     *
     */
    public static int promptForOption(Scanner scan) {
        while (true) {
            System.out.print("Please enter a valid option (1-6): ");
            if (!scan.hasNextInt()) {
                scan.nextLine(); // To catch incorrect input from user.
                continue;
            }
            int opc = scan.nextInt();
            scan.nextLine();//Throwaway scan.
            if (isInvalidOption(opc))
                continue;
            return opc;
        }
    }

    /**
     * Returns true if the option corresponds to one existing in the menu.
     * 
     * @param opt (int) Option that will be validated.
     * @return (boolean) True if the option exists.
     */
    public static boolean isInvalidOption(int opt) {
        return opt < 1 || opt > 6;
    }

    /**
     * Ask the user for a valid name (not null or blank). Force the user to input
     * some kind of String before returning it.
     * 
     * @param scan
     * @return (String)
     */
    public static String promptForName(Scanner scan) {
        while (true) {
            System.out.print("Please enter a valid name: ");
            String name = scan.nextLine();
            if (!isNullOrBlank(name))
                return name;
        }
    }

    /**
     * Ask the user for a valid ID. Checks that it's and int and returns it.
     * 
     * @param scan
     * @return (int) a valid ID indicated by the user.
     */
    public static int promptForId(Scanner scan) {
        while (true) {
            System.out.print("Please enter a valid ID: ");
            if (!scan.hasNextInt()) {
                scan.nextLine(); // To capture incorrect input.
                continue;
            }
            int id = scan.nextInt();
            scan.nextLine();//Throwaway scan
            return id;
        }
    }


    /**
     * Ask user input and then search for a Person with that ID.
     * @param scan
     * @return      (Person) object with the ID provided by the user. Null there was no Person with that ID.
     */
    public static Person searchPersonById(Scanner scan) {
        int id = promptForId(scan);
        return ps.searchPersonById(id);
    }


    /**
     * Ask user input and then search for a Dog with that name.
     * @param scan
     * @return      (Dog) object with the name provided by the user. Null there was no dog with that name.
     */
    public static Dog searchDogByName(Scanner scan) {
        String name = promptForName(scan);
        return ds.searchDogByName(name);
    }


    /**
     * Search for a person (by id) and a dog (by name). Validates that neither is null and that the Person doesn't have already a dog. The dog hasn't been adopted yet.
     * If all the conditions are met, assign the Dog to the Person's dog attribute, and then change the Dog's adopted field to true.
     * @param scan
     * @return      (boolean) true in case the process was completed.
     */
    public static boolean adopt(Scanner scan) {
        Person p1 = searchPersonById(scan);
        Dog d1 = searchDogByName(scan);

        if (ds.canBeAdopted(d1) && ps.canAdopt(p1)) {
            ps.adoptDog(p1, d1);
            ds.adoptDog(d1);
            return true;
        }
        return false;
    }

    /**
     * Checks if a String is null or blank.
     * 
     * @param phrase
     * @return (Boolean) True if the String is null or blank.
     */
    public static boolean isNullOrBlank(String phrase) {
        return (phrase.isBlank() || phrase == null);
    }
}

/*
 * Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro
 * programa va a tener que contar con muchas personas y muchos perros.
 * El programa deberá preguntarle a cada persona, que perro según su nombre,
 * quiere adoptar. Dos personas no pueden adoptar al mismo perro, si la persona
 * eligió un perro que ya estaba adoptado,
 * se le debe informar a la persona.
 * Una vez que la Persona elige el Perro se le asigna, al final deberemos
 * mostrar todas las personas con sus respectivos perros.
 */