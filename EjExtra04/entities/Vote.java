package EjExtra04.entities;

import java.util.HashSet;

public class Vote {
    private Student student;
    private HashSet<Student> castedVotes;

    
    public Vote(Student student, HashSet<Student> castedVotes) {
        this.student = student;
        this.castedVotes = castedVotes;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public HashSet<Student> getCastedVotes() {
        return this.castedVotes;
    }

    public void setCastedVotes(HashSet<Student> castedVotes) {
        this.castedVotes = castedVotes;
    }

}
/*• Una vez hecho esto debemos generar una clase Voto, esta clase tendrá como atributos,
un objeto Alumno que será el alumno que vota y una lista de los alumnos a los que votó. */