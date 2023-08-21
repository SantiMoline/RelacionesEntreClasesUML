package EjExtra01.services;

import java.util.ArrayList;
import java.util.Scanner;

import EjExtra01.entities.Dog;
import EjExtra01.enums.Size;

public class DogService {

    ArrayList<Dog> dogs;

    public DogService() {
        dogs = new ArrayList<>();
    }

    /**
     * Start the process for registering a dog. Ask user input to create an object Dog with all the information provided by the user.
     * Add the created Dog to the ArrayList 'dogs' that is an atribute of this service (don't have repository yet).
     * @param scan
     */
    public void registerDog(Scanner scan) {
        System.out.print("Dog's name: ");
        String name = scan.nextLine();
        System.out.print("Breed: ");
        String breed = scan.nextLine();
        System.out.print("Age: ");
        int age = scan.nextInt();
        scan.nextLine(); //Throwaway scan.
        String size = promptForSize(scan);

        dogs.add(new Dog(name, breed, age, Size.valueOf(size.toUpperCase())));
    }

    /**
     * Ask the user to indicate a Size for the dog. Shows the possible values (stored in an Enum Size).
     * Didn't implement validation on the user input because without using exception handling is impossible to use the method Enum.valueOf(String).
     * @param scan
     * @return  (String) the Size indicated by the user.
     */
    private String promptForSize(Scanner scan) {
        System.out.print("Size (");
        for (Size type : Size.values()) {
            System.out.print(type.toString().toLowerCase() + ", ");
        }
        System.out.print("): ");
        String size = scan.nextLine();
        return size;
    }

    /**
     * Search for a dog with the chosen name.
     * @param name  (String)
     * @return      (Dog) the element Dog with the chosen name. If couldn't find it, returns null
     */
    public Dog searchDogByName(String name) {
        for (Dog dog : dogs) {
            if(dog.getName().equalsIgnoreCase(name))
                return dog;
        }
        return null;
    }

    /**
     * Checks if the dog can be adopted (its adopted field == false).
     * @param dog   (Dog) to check adopted status.
     * @return      (boolean) true if the Dog's adopted field is false.
     */
    public boolean canBeAdopted(Dog dog) {
        if (dog == null) return false;
        return !dog.getAdopted();
    }

    /**
     * Check if a dog can be adopted and if so, change its adopted attribute to true. Returns true when can perfom that action.
     * @param dog   (Dog) to be adopted
     * @return      (boolean) Return true if the dog can be adopted 
     */
    public boolean adoptDog(Dog dog) {
        if (canBeAdopted(dog)) {
            dog.setAdopted(true);
            return true;
        }
        return false;
    }

    /**
     * Prints a Dog's information and returns true. In case of being null, returns false.
     * @param dog   (Dog)
     * @return      (boolean) in case the object Person was null, returns false.
     */
    public boolean showDog(Dog dog) {
        if (dog == null) 
            return false;
        System.out.println(dog);
        return true;
    }

}
