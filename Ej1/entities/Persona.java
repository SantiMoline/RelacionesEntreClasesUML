package entities;

public class Persona {
    private String name;
    private String surname;
    private int age;
    private int document;
    private Perro dog;


    public Persona(String name, String surname, int age, int document, Perro dog) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.document = document;
        setDog(dog); //To avoid reference trap. (Modify the object Dog in main and reference the same dog here).
    }

    //Constructor Persona without dog.
    public Persona(String name, String surname, int age, int document) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.document = document;
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

    public int getDocument() {
        return this.document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public Perro getDog() {
        if (this.dog == null )return null;
        return new Perro(this.dog); //So we cannot reference from main the object 'Perro' stored in this field.
    }

    public void setDog(Perro dog) {
        this.dog = new Perro(dog);
        //To avoid reference trap. (Modify the object Dog in main and reference the same dog here).
    }

    @Override
    public String toString() {
        return
            "\nName: " + getName() + 
            "\nSurname: " + getSurname() + 
            "\nAge: " + getAge() +
            "\nDocument: " + getDocument();
    }

}
/*la clase Persona con atributos: nombre, apellido, edad, documento y Perro. */