package EjExtra01.entities;
import java.util.Objects;


public class Person {
    private String name;
    private String surname;
    private int age;
    private int id;
    private Dog dog;


    public Person(String name, String surname, int age, int id, Dog dog) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
        setDog(dog); //To avoid reference trap. (Modify the object Dog in main and reference the same dog here).
    }

    //Constructor Persona without dog.
    public Person(String name, String surname, int age, int id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dog getDog() {
        if (this.dog == null )return null;
        return new Dog(this.dog); //So we cannot reference from main the object 'Dog' stored in this field.
    }

    public void setDog(Dog dog) {
        this.dog = new Dog(dog);
        //To avoid reference trap. (Modify the object Dog in main and reference the same dog here).
    }



    //Override hashCode() and equals() to compare only the attribute ID from each object. That way and using HashSet<Person>, it's impossible to store two different objects with same ID.
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    

    @Override
    public String toString() {
        return
            "\nName: " + getName() + 
            "\nSurname: " + getSurname() + 
            "\nAge: " + getAge() +
            "\nID: " + getId() + 
            "\nDog information: " + getDog();
    }
}
