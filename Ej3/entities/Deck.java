package Ej3.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import Ej3.enums.Color;

public class Deck {
    private Stack<Card> deck; 
    /*I used a Stack because the exercise only ask to shuffle, draw cards, show remaining cards, etc.
     *The Stack facilitates the draw action, because one method returns the element and removes it from the deck*/

    public Deck() {
        this.deck = new Stack<>();
        fillDeck();
    }

    /**
     * Function name: fillDeck
     * Description: it generates every card to fill the deck according to the permitted values (by the Card class) and the existing colors.
     */
    public void fillDeck() {
        for (int value : Card.valores) {
            //For each value that a card can have, it creates a card with that value and each of the four types.
            for (Color color : Color.values()) {
                this.deck.push(new Card(value, color));
            }
        }
    }

    //Shuffle the deck.
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Function name: nextCard 
     * @return  (Card)
     * 
     * Desription: Pop the last (next) card in the deck, returns it and removes it from the deck.
     */
    public Card nextCard() {
        if (this.deck.isEmpty()) {
            System.out.println("There are no cards left in the deck.");
            return null;
        }
        return deck.pop();
    }

    /**
     * Function name: numOfCardsInDeck
     * @return  (int)
     * 
     * Description: Returns the number of cards remaining in the deck.
     */
    public int remainingCardsInDeck() {
        return this.deck.size();
    }

    /**
     * Function name: drawCards
     * @param num   (int)
     * @return  (ArrayList<Card>)
     * 
     * Description: Recieves the number of cards the user wants to draw from the deck and returns them as part of an ArrayList.
     * Removes the cards from the deck.
     */
    public ArrayList<Card> drawCards(int num) {
        if (checkRemaining(num)) {
            ArrayList<Card> cards = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                cards.add(this.deck.pop());
            }
            return cards;
        } else {
            System.out.println("There are not enough cards remaining in the deck to draw.");
            return null;
        }
    }

    private boolean checkRemaining(int n) {
        return this.deck.size() >= n;
    }

    /**
     * Function name: showDeck
     * Description: prints every remaining card in the deck.
     */
    public void showDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }
    



}
