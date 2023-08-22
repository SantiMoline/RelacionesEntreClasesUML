package EjExtra02.entities;


public class Cinema {
    private Movie movie;
    private double price;
    private Spectator[][] movieTheater;
    private static final int MAX_ROWS = 8;
    private static final int MAX_COLUMNS = 6;
    private static final String[] ROW_NUMERATION = {"A","B","C", "D", "E", "F", "G", "H"};
    

    public Cinema() {
        movieTheater = new Spectator[MAX_ROWS][MAX_COLUMNS];
    }

    public Cinema(Movie movie, double price, Spectator[][] movieTheater) {
        this.movie = movie;
        this.price = price;
        this.movieTheater = movieTheater;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Spectator[][] getMovieTheater() {
        return this.movieTheater;
    }

    public void setMovieTheater(Spectator[][] movieTheater) {
        this.movieTheater = movieTheater;
    }

    public boolean addSpectator(Spectator spectator) {
        if (!canPayTicket(spectator)) return false;  //This methods checks if spectator is null && if it has enough cash to pay the ticket.

        int row;
        int column;
        do {
            row = (int) (Math.random() * MAX_ROWS + 1);
            column = (int) (Math.random() * MAX_COLUMNS + 1);
        } while (movieTheater[row][column] != null);
        
        movieTheater[row][column] = spectator;
        return true;
    }

    private boolean canPayTicket(Spectator spectator) {
        if (spectator == null) return false;
        return spectator.getCashAvailable() >= this.price;
    }


    public void showMovieTheater() {
        for (int i = 0; i < movieTheater.length; i++) {
            for (int j = 0; j < movieTheater[0].length; j++) {
                System.out.print(ROW_NUMERATION[i] + " " + j);
                if(movieTheater[i][j] == null)
                    System.out.print("   "); 
                else System.out.println(" X ");
            }
            System.out.print("\n");
        }
    }

}
