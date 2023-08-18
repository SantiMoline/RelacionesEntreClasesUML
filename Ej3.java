import java.util.ArrayList;
import java.util.Scanner;

import Ej3.entities.Card;
import Ej3.entities.Deck;
import Ej3.entities.DiscardPile;

public class Ej3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("-------Welcome to the deck factory-------");
        System.out.println("Generating new deck.....");
        Deck deck = new Deck(); 
        DiscardPile discardPile = new DiscardPile();
        Card card;   
        System.out.println("The new deck is ready!");

        int opt = 0;
        while (opt != 9) {
            showMenu();
            opt = promptForInput(scan);
            switch (opt) {
                case 1: deck.shuffle(); break;
                case 2: 
                    card = deck.nextCard();
                    System.out.println("You draw: " + card);
                    discardPile.addCard(card);
                    break;
                case 3:
                    System.out.println("How many cards do you want to draw?");
                    int numb = promptForDraw(scan);
                    ArrayList<Card> cards = deck.drawCards(numb);
                    if(checkCards(cards)) {
                        showDraw(cards);
                    }
                    break;
                case 4:
                    System.out.println("There are " + discardPile.cardsInDiscardPile() + " cards in the deck.");
                    break;
                case 5:
                    System.out.println("There are " + deck.remainingCardsInDeck() + " cards in the deck.");
                    break;
                case 6: 
                    System.out.println("Showing cards remaining in the deck: ");
                    deck.showDeck();
                    break;
                case 7:
                    System.out.println("Showing cards in the discard pile: ");
                    discardPile.showDiscardPile();
                    break;
                case 8:
                    System.out.println("Initializating new deck & discard pile......");
                    deck = new Deck();
                    discardPile = new DiscardPile();
                    System.out.println("Ready to start from scratch!");
                    break;
                case 9:
                    System.out.println("See you next time!");
                    break;
            }
        }
    }
    
    public static void showMenu() {
        System.out.println("1. Shuffle deck.");
        System.out.println("2. Draw card.");
        System.out.println("3. Draw multiple cards.");
        System.out.println("4. Check how many cards are in the discard pile.");
        System.out.println("5. Check how many cards are remaining in the deck.");
        System.out.println("6. Show remaining cards in the deck.");
        System.out.println("7. Show cards in the discard pile.");
        System.out.println("8. Reset deck and discard pile.");
        System.out.println("9. Exit.");

    }

    public static int promptForInput(Scanner scan) {
        while (true) {
            System.out.print("Please enter a valid option (1-9): ");
            if (!scan.hasNextInt()) {
                scan.nextLine(); //to capture incorrect input from user.
                continue;
            }
            else {
                int opc = scan.nextInt();
                scan.nextLine(); //Throwaway scan.
                if (!invalidInput(opc)) return opc;
            }
        }
    }


    public static boolean invalidInput(int n) {
        return (n < 1 || n > 7);
    }


    public static int promptForDraw(Scanner scan) {
        while (true) {
            System.out.print("Please enter a valid option (1-40): ");
            if (!scan.hasNextInt()) {
                scan.nextLine(); //to capture incorrect input from user.
                continue;
            }
            else {
                int opc = scan.nextInt();
                scan.nextLine(); //Throwaway scan.
                if (!(opc < 1 || opc > 40)) return opc;
            }
        }
    }

    public static boolean checkCards(ArrayList<Card> cards) {
        return cards == null;
    }

    public static void showDraw(ArrayList<Card> cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

}
/*Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número entre 1 y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas).
Esta clase debe contener un método toString() que retorne el número de carta y el palo. La baraja estará compuesta por un conjunto de cartas, 40 exactamente.
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente.
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
se haya llegado al final, se indica al usuario que no hay más cartas.
• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero debemos indicárselo al usuario.
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna indicárselo al usuario
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y luego se llama al método, este no mostrara esa primera carta. */