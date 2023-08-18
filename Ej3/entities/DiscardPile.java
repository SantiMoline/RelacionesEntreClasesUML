package Ej3.entities;

import java.util.ArrayList;
import java.util.Stack;

public class DiscardPile {
    private Stack<Card> discardPile;

    //Empty constructor.
    public DiscardPile() {
        discardPile = new Stack<>();
    }

    //Getters & Setters.
    public Stack<Card> getDiscardPile() {
        return this.discardPile;
    }

    public void setDiscardPile(Stack<Card> discardPile) {
        this.discardPile = discardPile;
    }

    /**
     * Function name: addCard
     * @param card  (Card)
     * 
     * Description: revieves a card and put in last in the discardpile.
     */
    public void addCard(Card card) {
        discardPile.push(card);
    }

    /**
     * Function name: addMultipleCards
     * @param cards     (ArrayList<Card>)
     * 
     * Description: recieves multiple cards and add them all to the discard pile.
     */
    public void addMultipleCards(ArrayList<Card> cards) {
        for (Card card : cards) {
            discardPile.push(card);
        }
    }

    /**
     * Function name: showDiscardPile
     * Description: prints every card that is in the discard pile. If the discard pile is empty, prints that information.
     */
    public void showDiscardPile() {
        if (discardPile.isEmpty()) {
            System.out.println("You didn't discard a card yet.\nThere are no cards in the discard pile.");
            return;
        }
        for (Card card : discardPile) {
            System.out.println(card);
        }
    }

    public int cardsInDiscardPile() {
        return discardPile.size();
    }
}
