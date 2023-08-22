package EjExtra02.services;

import java.util.HashSet;
import java.util.Scanner;

import EjExtra02.entities.Movie;

public class MovieService {
    private HashSet<Movie> movies;

    //Constructor
    public MovieService() {
        movies = new HashSet<>(); //To avoid duplicates. Can't store two different Movie Objects with the same title. (Overrided equals & hashCode methods.)
    }

    /**
     * Ask the user to complete the information for a new movie. Create the object and returns it.
     * @param scan
     * @return      (Movie) the movie created with the information provided by the user.
     */
    public Movie createMovie(Scanner scan) {
        System.out.print("\nTitle: ");
        String title = scan.nextLine();
        System.out.print("\nDirector: ");
        String director = scan.nextLine();
        System.out.print("\nDuration: ");
        int duration = scan.nextInt();
        scan.nextLine();//Throwaway scan.
        System.out.print("\nMinimum Age: ");
        int minimumAge = scan.nextInt();
        scan.nextLine();//Throwaway scan.

        return new Movie(title, director, duration, minimumAge);
    }

    /**
     * Checks if the movie is not null, and then proceeds to adds to the HashSet (). 
     * @param movie (Movie to be stored).
     * @return      (boolean) True when the Movie has been registered correctly. False if the movie == null or already existed.
     */
    public boolean registerMovie(Movie movie) {
        if (movie == null) return false;
        return movies.add(movie);
    }

    /**
     * Search the HashSet and returns the movie with the title recieved
     * @param title     (String) Title used to search for the movie.
     * @return          (Movie) returns movie object or null if it couldn't find one with the indicated title.
     */
    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return new Movie(movie); //Using copy constructor to avoid reference trap and referencing from main a Movie stored object.
            }
        }
        return null;
    }

    /**
     * Prints the information of the recieved movie.
     * @param movie (Movie) movie to be shown.
     * @return      (boolean) true if the movie was not null.
     */
    public boolean showMovie(Movie movie) {
        if (movie == null) return false;
        System.out.println(movie);
        return true;
        
    }

    /**
     * Prints every movie stored in the HashSet.
     */
    public void showMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

}
