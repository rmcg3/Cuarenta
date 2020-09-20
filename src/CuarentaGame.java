package com.mycompany.cardgamecuarenta;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class CuarentaGame {

    public static void main(String[] args) {

        System.out.println("CUARENTA CARD GAME");
        Deck activeDeck = new Deck();
        activeDeck.makeDeck();
        activeDeck.shuffle();
        Deck player1Hand = new Deck();
        Deck player2Hand = new Deck();
        Deck tablePile = new Deck();
        Deck pointsPile = new Deck();
        Scanner playerInput = new Scanner(System.in);

        System.out.println("Dealing cards . . .");

        /*try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(CuarentaGame.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        player1Hand.drawHand(activeDeck);
        player2Hand.drawHand(activeDeck);

        firstTurn(player1Hand, tablePile, playerInput);
        p2Turn(player2Hand, tablePile, playerInput);
        p1Turn(player1Hand, tablePile, playerInput);

    }

    public static void firstTurn(Deck player1Hand, Deck tablePile, Scanner playerInput) {
        System.out.println("Player1 Hand: " + player1Hand + "\n");
        //System.out.println("Player2 Hand: " + player2Hand);
        //System.out.println("Player1 first card value : " + player1Hand.getCard(0).getNumVal());
        System.out.println("Which card # would you like to play? ");

        int rp = playerInput.nextInt();
        /*if (rp == 1) {
            tablePile.playCard(player1Hand, 0);
        }*/

        switch (rp) {
            case 1:
                tablePile.playCard(player1Hand, 0);
                break;
            case 2:
                tablePile.playCard(player1Hand, 1);
                break;
            case 3:
                tablePile.playCard(player1Hand, 2);
                break;
            case 4:
                tablePile.playCard(player1Hand, 3);
                break;
            case 5:
                tablePile.playCard(player1Hand, 4);
                break;
        }

        System.out.println("Table Pile cards: " + tablePile);
        //System.out.println("Main deck " + activeDeck.toString());
        System.out.println("Cards in your hand now: " + player1Hand + "\n");

    }

    public static void p1Turn(Deck player1Hand, Deck tablePile, Scanner playerInput) {
        System.out.println("***Player 1's Turn***\n");
        System.out.println("Player1 Hand: " + player1Hand + "\n");
        //pick card
        System.out.println("Which card # would you like to play? ");

        int rp = playerInput.nextInt();
        isMatch(tablePile, player1Hand, rp);

        //see if play is possible
    }

    public static void p2Turn(Deck player2Hand, Deck tablePile, Scanner playerInput) {
        System.out.println("***Player 2's Turn***\n");
        Random rand = new Random();
        int rp = rand.nextInt(player2Hand.deckSize() - 1);
        switch (rp) {
            case 1:
                tablePile.playCard(player2Hand, 0);
                break;
            case 2:
                tablePile.playCard(player2Hand, 1);
                break;
            case 3:
                tablePile.playCard(player2Hand, 2);
                break;
            case 4:
                tablePile.playCard(player2Hand, 3);
                break;
            case 5:
                tablePile.playCard(player2Hand, 4);
                break;
        }
        /* try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(CuarentaGame.class.getName()).log(Level.SEVERE, null, ex);
        }*/

       
        System.out.println("Table Pile cards:" + tablePile + "\n");

    }

    public static boolean isMatch(Deck tablePile, Deck player1Hand, int rp) {

        int mostRecent = tablePile.getCard(tablePile.deckSize() - 1).getNumVal();
        int playerMatchCard = player1Hand.getCard(rp).getNumVal();

        //caida check
        if (playerMatchCard == mostRecent) {
            
            System.out.println(player1Hand.getCard(rp) + " matches " + 
                    tablePile.getCard(tablePile.deckSize() - 1));
            //play the matched cards, +2 points, caida
            
            if(tablePile.isEmpty() == true){
                System.out.println("Limpia y Caida, +4");
            }
                
            return true;
        } 
        
        //see if any card on the table matches the players chosen play card
        else {
            for (int i = 0; i < tablePile.deckSize() - 1; i++) {
                if (playerMatchCard == tablePile.getCard(i).getNumVal()) {
                    System.out.println(player1Hand.getCard(rp) + " matches " + tablePile.getCard(i));
                    //play the matched cards
                    return true;
                }
            }
        }

        return false;
    }
}
