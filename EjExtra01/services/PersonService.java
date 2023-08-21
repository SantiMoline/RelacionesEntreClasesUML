package EjExtra01.services;

import java.util.HashSet;
import java.util.Scanner;

import EjExtra01.entities.Dog;
import EjExtra01.entities.Person;

public class PersonService {

    HashSet<Person> persons;

    public PersonService() {
        persons = new HashSet<>(); //Used hashset to not allow two person with same ID to be registered in the system.
    }

    /**
     * Start the process to register a Person. Ask user input to create an object Person with all the information provided by the user.
     * Add the created Person to the HashSet<Person> 'persons' that is an atribute of this service. (don't have repository yet.)
     * @param scan
     */
    public Person createPerson(Scanner scan) {
        System.out.print("\nName: ");
        String name = scan.nextLine();
        System.out.print("\nSurname: ");
        String surname = scan.nextLine();
        System.out.print("\nAge: ");
        int age = scan.nextInt();
        scan.nextLine();//throwaway scan.
        System.out.print("\nID: ");
        int id = scan.nextInt();
        scan.nextLine();//Throwaway scan.

        return (new Person(name, surname, age, id));
    }

    public boolean registerPerson(Person person) {
        if (person == null)return false;
        persons.add(person);
        return true;
    }

    /**
     * Checks if a person is null or if it has already adopted a dog. Returns false in those cases.
     * @param person    (Person) checks if the person has already adopted a dog.
     * @return          (boolean) true if the person is not null and did not adopt a dog already.
     */
    public boolean canAdopt(Person person) {
        if (person == null)
            return false;

        return person.getDog() == null;
    }

    /**
     * Checks if Dog is not Null and if the Person can adopt. In those cases, assign the Dog to the Person's dog field. 
     * @param person    (Person) who's going to adopt the dog. Must not be null and couldn't adopted other dog already.
     * @param dog       (Dog) to be adopted.
     * @return          (boolean) true in case the Person adopted the dog.
     */
    public boolean adoptDog(Person person, Dog dog) {
        if (dog == null) return false;
        if (canAdopt(person)) {
            person.setDog(dog);
            return true;
        }
        return false;
    }

    /**
     * Iterate over the HashSet 'persons' to find the one that has the number of ID recieved.
     * @param id    (int) ID to iterate over the HashSet and find a person with that id.
     * @return      (Person) the object Person with the indicated number of ID.
     */
    public Person searchPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id)
                return person;
        }
        return null;
    }

    /**
     * Prints a Person's information and returns true. In case of being null, returns false.
     * @param person    (Person)
     * @return          (boolean) in case the object Person was null, returns false.
     */
    public boolean showPerson(Person person) {
        if (person == null)
            return false;

        System.out.println(person);
        return true;
    }

    /**
     * Prints all the information of every Person stored in the HashSet.
     */
    public void showPeople() {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    /**
     * Shows the old Person's information and then ask for all the new one. If the new one corresponds to the same ID, update the old information with the new one.
     * @param person    (Person) old element in the HashSet to be updated.
     * @param scan
     * @return          (boolean) in case the information has been succesfully replaced.
     */
    public boolean updatePerson(Person person, Scanner scan) {
        if (showPerson(person)) { //Shows person stored information and proceed, or breaks if it coudn't find Person's information
            Person modifiedPerson = createPerson(scan);
            modifiedPerson.setDog(person.getDog()); //Store the previous dog information in the new Person.
            
            if (persons.contains(modifiedPerson)) {
                persons.remove(person);
                persons.add(modifiedPerson);
                return true;
            }
        }
        return false;
    }
}
