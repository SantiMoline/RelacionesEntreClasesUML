package EjExtra02.services;

import java.util.HashSet;
import java.util.Scanner;

import EjExtra02.entities.Movie;

public class MovieService {
    private HashSet<Movie> movies;


    public MovieService() {
        movies = new HashSet<>();
    }

    public Movie createMovie(Scanner scan) {
        System.out.print("\nTitle: ");
        String title = scan.nextLine();
        System.out.print("\nDirector: ");
        String director = scan.nextLine();
        System.out.println("\nDuration: ");
        int duration = scan.nextInt();
        scan.nextLine();//Throwaway scan.
        int minimumAge = scan.nextInt();
        scan.nextLine();//Throwaway scan.

        return new Movie(title, director, duration, minimumAge);
    }

    public boolean registerMovie(Movie movie) {
        if (movie == null) return false;
        movies.add(movie);
        return true;
    }

    public Movie getMovieByName(String name) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(name)) {
                return new Movie(movie); //Using copy constructor to avoid reference trap and referencing from main a Movie stored object.
            }
        }
        return null;
    }

    public void showMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

}
