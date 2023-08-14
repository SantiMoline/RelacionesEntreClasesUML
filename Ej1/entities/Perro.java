package entities;

public class Perro {
    private String name;
    private String breed;
    private int age;
    private String size;

    public Perro(String name, String breed, int age, String size) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.size = size;
    }

    //Copy Constructor.
    public Perro(Perro source) {
        this.name = source.name;
        this.breed = source.breed;
        this.age = source.age;
        this.size = source.size;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return
            "\n---------------------------" + 
            "\n\tName: " + getName() +
            "\n\tBreed: " + getBreed() +
            "\n\tAge:" + getAge() + 
            "\n\tSize: " + getSize() + 
            "\n---------------------------";
    }

}
/*Perro, que tendrá como atributos: nombre, raza, edad y tamaño; */