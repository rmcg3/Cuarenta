import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
		
	}
	
	public void makeDeck() {
		for(Suit cardSuit : Suit.values()){
			//Loop through Values
			for(FaceValue cardValue : FaceValue.values()){
				//Add new card to the mix
				this.cards.add(new Card(cardSuit,cardValue));
			}
		}
		
	}
	
	public String toString(){
		String cardListOutput = "";
		int i = 0;
		for(Card aCard : this.cards){
			cardListOutput += "\n" + aCard.toString();
			i++;
		}
		return cardListOutput;
	}

}
