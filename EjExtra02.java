import java.util.Scanner;

import EjExtra02.entities.Cinema;
import EjExtra02.entities.Movie;
import EjExtra02.services.MovieService;
import EjExtra02.services.SpectatorService;

public class EjExtra02 {
        static SpectatorService ss = new SpectatorService();
        static MovieService ms = new MovieService();
        static final double TICKET_PRICE = 12.25;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Cinema cinema = new Cinema();
        cinema.setPrice(TICKET_PRICE);


        System.out.println("Welcome to the cinema!");
        boolean active = true;
        while (active) {
            showMenu();
            int opc = promptForOption(scan);
            switch (opc) {
                case 1:
                    ms.registerMovie(ms.createMovie(scan));
                    break;
                case 2:
                    cinema.setMovie(searchMovieByTitle(scan));
                    System.out.println("The theater is now set to cast " + cinema.getMovie().getTitle());
                    break;
                case 3:
                    if(!ms.showMovie(searchMovieByTitle(scan)))
                        System.out.println("Sorry, we don't have that movie in our database.");
                    break;
                case 4:
                    System.out.println("----------This is our catalogue----------");
                    ms.showMovies(); break;
                case 5:
                    ss.registerSpectator(ss.createSpectator(scan));
                    break;
                case 6:
                    System.out.println("----------This is our spectators database----------");
                    ss.showSpectators(); 
                    break;
                case 7:
                    cinema.fillTheaterWithSpectators(ss.getSpectators()); break;
                case 8:
                    System.out.println("This is the current status of the movie theater for the film " + cinema.getMovie().getTitle());
                    cinema.showMovieTheater(); break;
                case 9:
                    System.out.println("The current price of the ticket is: $" + TICKET_PRICE);
                    break;
                default: 
                    System.out.println("Thanks for coming!!! Hope you enjoyed it!");
                    active = false;
                    break;
            }

        }
    }


    /**
     * Show menu with the options available to the user.
     */
    public static void showMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Register a movie.");
        System.out.println("2. Select movie to cast in theater.");
        System.out.println("3. Search for movie's information by name.");
        System.out.println("4. View every stored movie's information.");
        System.out.println("5. Register spectator.");
        System.out.println("6. View every registered spectator's information.");
        System.out.println("7. Fill movie theater with spectators.");
        System.out.println("8. View current Movie theater status.");
        System.out.println("9. Ask for the current price of the ticket.");
        System.out.println("10. Exit.");
    }

    /**
     * Ask the user for a valid input that corresponds to one option in the menu.
     * 
     * @param scan (Scanner)
     * @return (int) The option chosen by the user.
     *
     */
    public static int promptForOption(Scanner scan) {
        while (true) {
            System.out.print("Please enter a valid option (1-9): ");
            if (!scan.hasNextInt()) {
                scan.nextLine(); // To catch incorrect input from user.
                continue;
            }
            int opc = scan.nextInt();
            scan.nextLine();//Throwaway scan.
            if (isInvalidOption(opc))
                continue;
            return opc;
        }
    }

    /**
     * Returns true if the option corresponds to one existing in the menu.
     * 
     * @param opt (int) Option that will be validated.
     * @return (boolean) True if the option exists.
     */
    public static boolean isInvalidOption(int opt) {
        return opt < 1 || opt > 9;
    }

        /**
     * Ask the user for a valid title (not null or blank). Force the user to input
     * some kind of String before returning it.
     * 
     * @param scan
     * @return (String)
     */
    public static String promptForTitle(Scanner scan) {
        while (true) {
            System.out.print("Please enter a valid title: ");
            String title = scan.nextLine();
            if (!isNullOrBlank(title))
                return title;
        }
    }

    /**
     * Ask the user to write a valid title (not null or blank.) Then, go on to search the movie and returns it if it exists.
     * @param scan
     * @return      (Movie) the movie with the same title the user just wrote.
     */
    public static Movie searchMovieByTitle(Scanner scan) {
        String title = promptForTitle(scan);
        return ms.getMovieByTitle(title);
    }

    /**
     * Checks if a String is null or blank.
     * 
     * @param phrase
     * @return (Boolean) True if the String is null or blank.
     */
    public static boolean isNullOrBlank(String phrase) {
        return (phrase.isBlank() || phrase == null);
    }
}
/*Nos piden hacer un programa sobre un Cine, que tiene una sala con un conjunto de asientos (8 filas por 6 columnas). De Cine nos interesa conocer la película que se está reproduciendo,
la sala con los espectadores y el precio de la entrada. Luego, de las películas nos interesa saber el título, duración, edad mínima y director.
Por último, del espectador, nos interesa saber su nombre, edad y el dinero que tiene disponible.
Para representar la sala con los espectadores vamos a utilizar una matriz. Los asientos son etiquetados por una letra y un número la fila A1 empieza al final del mapa
como se muestra en la tabla. También deberemos saber si el asiento está ocupado por un espectador o no, si esta ocupado se muestra una X, sino un espacio vacío. 
Se debe realizar una pequeña simulación, en la que se generen muchos espectadores y se los ubique en los asientos aleatoriamente (no se puede ubicar un espectador donde ya este ocupado el asiento).
Los espectadores serán ubicados de uno en uno y para ubicarlos tener en cuenta que sólo se podrá sentar a un espectador si tiene el dinero suficiente para pagar la entrada,
si hay espacio libre en la sala y si tiene la edad requerida para ver la película. En caso de que el asiento este ocupado se le debe buscar uno libre.
Al final del programa deberemos mostrar la tabla, podemos mostrarla con la letra y numero de cada asiento o solo las X y espacios vacíos.
*/