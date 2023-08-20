package EjExtra01.entities;


import EjExtra01.enums.Size;


public class Dog {
    private String name;
    private String breed;
    private int age;
    private Size size;
    private boolean adopted;

    public Dog(String name, String breed, int age, Size size) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.size = size;
        this.adopted = false;
    }

    //Copy Constructor.
    public Dog(Dog source) {
        this.name = source.name;
        this.breed = source.breed;
        this.age = source.age;
        this.size = source.size;
        this.adopted = source.adopted;
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

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean getAdopted() {
        return this.adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    @Override
    public String toString() {
        return
            "\n---------------------------" + 
            "\n\tName: " + getName() +
            "\n\tBreed: " + getBreed() +
            "\n\tAge:" + getAge() + 
            "\n\tSize: " + getSize().toString().toLowerCase() + 
            "\n\tHas been adopted?: " + getAdopted() +
            "\n---------------------------";
    }
}
