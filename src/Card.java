

public class Card{

	private Suit suit;
	private FaceValue faceValue;
	
	public Card(Suit suit, FaceValue faceValue) {
		this.suit = suit;
		this.faceValue = faceValue;
	
	}
	
	public FaceValue getValue() {
		return this.faceValue;
	}
	public String toString(){
		return this.suit.toString() + "-" + this.faceValue.toString();
	}


}
