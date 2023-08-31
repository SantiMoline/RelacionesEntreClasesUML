package EjExtra04.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import static EjExtra04.Constants.*;

public class Simulador {
    private HashSet<Student> students;
    private ArrayList<Vote> votes;

    
    public Simulador() {
        students = new HashSet<>();
        votes = new ArrayList<>();
    }

    private ArrayList<String> generateNames() {
        ArrayList<String> fullNames = new ArrayList<>();
        for (int i = 0; i < MAX_COMBINATIONS; i++) {
            int randomIndexName = (int) (Math.random() * NAMES.length);
            int randomIndexSurname = (int) (Math.random() * SURNAMES.length);
            fullNames.add(NAMES[randomIndexName] + " " + SURNAMES[randomIndexSurname]);
        }

        return fullNames;
    }

    private ArrayList<Integer> generateIds() {
        ArrayList<Integer> idsAvailable = new ArrayList<>();
        for (int i = 0; i < MAX_COMBINATIONS; i++) {
            int random = (int) (Math.random() * 15_000_000);
            idsAvailable.add(MIN_ID + random);
        }
        return idsAvailable;
    }

    public void registerStudents(int n) {
        ArrayList<String> names = generateNames();
        ArrayList<Integer> ids = generateIds();

        int i = 0;
        while (students.size() < n) {
            students.add(new Student(names.get(i), ids.get(i)));
            i++;
        }
    }

    public void voting() {
        for (Student student : students) {
            votes.add(new Vote(student, castRandomVotes(student)));
        }
    }

    public HashSet<Student> castRandomVotes(Student student) {
        HashSet<Student> castedVotes = new HashSet<>();
        castedVotes.add(student); //Add the students to the castedVotes HashSet so he cannot cast a vote to itself.
        Student[] studentArray = students.toArray(new Student[students.size()]);

        while(castedVotes.size() < NUMBER_OF_VOTES + 1) {
            Random rndm = new Random();
            int rndmInt = rndm.nextInt(students.size());
            Student votedStudent = studentArray[rndmInt];
            castedVotes.add(votedStudent);
            assignVote(votedStudent);
        }
        castedVotes.remove(student); //Remove the student who is voting from his votes.

        return castedVotes;
    }

    public void assignVote(Student votedStudent) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student actualStudent = iterator.next();
            if (actualStudent.equals(votedStudent)) {
                actualStudent.setNumberOfVotes(actualStudent.getNumberOfVotes() + 1);
                return;
            }
        }
    }

    public void showStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void showStudentsAndItsVotes() {
        for (Student student : students) {
            System.out.println(student);
            for (Vote vote : votes) {
                if(vote.getStudent().equals(student)) {
                    System.out.println("Casted votes to: " + vote.getCastedVotes().toString());
                }
            }
        }
    }

    private ArrayList<Student> getStudentsOrderedByVotes() {
        ArrayList<Student> studentsOrderedByVotes = new ArrayList<>(students);
        Collections.sort(studentsOrderedByVotes);
        Collections.reverse(studentsOrderedByVotes);
        return studentsOrderedByVotes;
    }

    public ArrayList<Student> getFacilitators() {
        ArrayList<Student> studentsOrderedByVotes = getStudentsOrderedByVotes();
        ArrayList<Student> facilitators = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_FACILITATORS; i++) {
            facilitators.add(studentsOrderedByVotes.get(i));
        }
        return facilitators;       
    }

    public ArrayList<Student> getSubstitutes() {
        ArrayList<Student> studentsOrderedByVotes = getStudentsOrderedByVotes();
        ArrayList<Student> substitutes = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_SUBSTITUTE_FACILITATORS; i++) {
            substitutes.add(studentsOrderedByVotes.get(i+NUMBER_OF_FACILITATORS));
        }
        return substitutes;    
    }

    public void showList(ArrayList<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
