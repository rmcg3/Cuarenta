import java.util.Arrays;
import java.util.Scanner;

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
		player1Hand.drawHand(activeDeck);
		player2Hand.drawHand(activeDeck);

		System.out.println("Player1 Hand: " + player1Hand + "\n");
		//System.out.println("Player2 Hand: " + player2Hand);
		//System.out.println("Player1 first card value : " + player1Hand.getCard(0).getNumVal());
		System.out.println("Which card # would you like to play? ");
		int rp = playerInput.nextInt();
		if(rp == 1) {
			tablePile.playCard(player1Hand, 0);
		}
		System.out.println("Table Pile cards: " + tablePile);
		//System.out.println("Main deck " + activeDeck.toString());
		System.out.println("Cards in your hand now: " + player1Hand);

	}
}
