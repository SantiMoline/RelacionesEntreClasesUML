package EjExtra02.services;

import java.util.ArrayList;
import java.util.Scanner;

import EjExtra02.entities.Spectator;

public class SpectatorService {
    ArrayList<Spectator> spectators;

    //Empty constructor.
    public SpectatorService() {
        spectators = new ArrayList<>();
    }


    public ArrayList<Spectator> getSpectators() {
        return this.spectators;
    }

    public void setSpectators(ArrayList<Spectator> spectators) {
        this.spectators = spectators;
    }


    public Spectator createSpectator(Scanner scan) {
        String name = promptForName(scan);
        int age = promptForAge(scan);
        double cash = promptForCash(scan);

        return new Spectator(name, age, cash);
    }

    public boolean registerSpectator(Spectator spectator) {
        if (spectator == null) return false;
        spectators.add(spectator);
        return true;
    }

    private boolean isInvalidAge(int age) {
        return age < 0 || age > 100;
    }

    private boolean isInvalidCash(double cash) {
        return cash < 0;
    }

    private boolean isInvalidName(String name) {
        return name.isBlank() || name == null;
    }

    private int promptForAge(Scanner scan) {
        while (true) {
            System.out.print("\nAge: ");
            if(!scan.hasNextInt()) {
                scan.nextLine(); //To capture incorrect input
                continue;
            }
            int age = scan.nextInt();
            scan.nextLine(); //Throwaway scan.
            if (isInvalidAge(age)) continue;
            return age;
        }
    }

    private double promptForCash(Scanner scan) {
        while (true) {
            System.out.print("\nCash Available: ");
            if(!scan.hasNextDouble()) {
                scan.nextLine(); //To capture incorrect input
                continue;
            }
            double cash = scan.nextDouble();
            scan.nextLine(); //Throwaway scan.
            if(isInvalidCash(cash)) continue;
            return cash;
        }
    }

    private String promptForName(Scanner scan) {
        while (true) {
            System.out.print("\nName: ");
            String name = scan.nextLine();
            if (isInvalidName(name)) continue;
            return name;
        }
    }

    public void showSpectators() {
        for (Spectator spectator : spectators) {
            System.out.println(spectator);
        }
    }

}
