// Kinda using deck class and its methods to handle interactions
// between players hand, table pile, active deck (aka whatever is an array of cards)
package com.mycompany.cardgamecuarenta;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();

    }

    public void makeDeck() {
        for (Suit cardSuit : Suit.values()) {
            //Loop through Values
            for (FaceValue cardValue : FaceValue.values()) {
                //Add new card to the mix
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }

    }

    public void shuffle() {
        //Create a new arraylist to hold the shuffled cards temporarily
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        //Randomly pick from the old deck and copy values to the new deck
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
            //gen random num according to int randomNum = rand.nextInt((max - min) + 1) + min;
            randomCardIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
            //throw random card into new deck
            tmpDeck.add(this.cards.get(randomCardIndex));
            //remove picked from old deck
            this.cards.remove(randomCardIndex);
        }
        //set this.deck to our newly shuffled deck
        this.cards = tmpDeck;
    }

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    public void playCard(Deck comingFrom, int which) {
        this.cards.add(comingFrom.getCard(which));
        comingFrom.removeCard(which);
    }

    public void draw(Deck comingFrom) {
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

    public void drawHand(Deck comingFrom) {
        for (int i = 0; i < 5; i++) {
            this.cards.add(comingFrom.getCard(i));
            comingFrom.removeCard(i);
        }
    }

    public String toString() {
        String cardListOutput = "";
        int i = 1;
        for (Card aCard : this.cards) {
            cardListOutput += "\n" + "(" + i + ")" + " " + aCard.toString() + " " + aCard.getNumVal();
            i++;
        }
        return cardListOutput;
    }

    public int deckSize() {
        return this.cards.size();
    }
    public boolean isEmpty(){
        return this.cards.isEmpty();
    }
}
