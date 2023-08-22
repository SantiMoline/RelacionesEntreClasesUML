package EjExtra02.entities;
import java.util.Objects;


public class Movie {
    private String title;
    private int duration;
    private int minimumAge;
    private String director;


    public Movie(String title, String director, int duration, int minimumAge) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.minimumAge = minimumAge;
    }

    //Copy Constructor (to avoid reference trap from the main and alter Movie objects generated in main and later stored.)
    public Movie(Movie source) {
        this.title = source.title;
        this.director = source.director;
        this.duration = source.duration;
        this.minimumAge = source.minimumAge;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMinimumAge() {
        return this.minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    //equals and hashCode only take into consideration the title of the movie. That way, the user can't store in the HashSet two diffents objects Movie with the same title.
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    
    @Override
    public String toString() {
        return "\n--------------------------------------" + 
            "\nTitle: " + getTitle() +
            "\nDirector: " + getDirector() +
            "\nDuration: " + getDuration() +
            "\nMinimum Age: " + getMinimumAge() + 
            "\n--------------------------------------";
    }

}
