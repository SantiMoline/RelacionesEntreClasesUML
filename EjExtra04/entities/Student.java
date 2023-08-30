package EjExtra04.entities;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private int id;
    private int numberOfVotes;


    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.numberOfVotes = 0;
    }

    public Student(String name, int id, int numberOfVotes) {
        this.name = name;
        this.id = id;
        this.numberOfVotes = numberOfVotes;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfVotes() {
        return this.numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }


    /**
     * Overrided equals and hashCode method to consider equals 2 objects when they share same ID.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Student)) {
            return false;
        }
        Student alumno = (Student) o;
        return id == alumno.id;
    }

    /**
     *     * Overrided equals and hashCode method to consider equals 2 objects when they share same ID.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public String toString() {
        return "\n---------------------------------------" + 
            "\nName: " + getName() +
            "\nID: " + getId() + 
            "\nVotes Recieved: " + getNumberOfVotes() +
            "\n---------------------------------------";
    }

    @Override
    public int compareTo(Student o) {
        return numberOfVotes - o.getNumberOfVotes();
    }
}
