package EjExtra02.entities;


public class Spectator {
    private String name;
    private int age;
    private double cashAvailable;


    //Constructor.
    public Spectator(String name, int age, double cashAvailable) {
        this.name = name;
        this.age = age;
        this.cashAvailable = cashAvailable;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCashAvailable() {
        return this.cashAvailable;
    }

    public void setCashAvailable(double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }
    

    @Override
    public String toString() {
        return
            "\nName: " + getName() +
            "\nAge: " + getAge() +
            "\nCashAvailable: " + getCashAvailable();
    }

}
