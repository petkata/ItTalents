package warGameImplementation;

public class Card {

	private String strength;
	private String suit;
	private int power;
	
	public Card(String strength, String suit) {
		this.strength = strength;
		this.suit = suit;
	}
	
	void setPower(int power) {
		this.power = power;
	}

	public String printInfo() {
		return strength + " " + suit;
		
	}

	public boolean warWith(Card c2) {
		return this.power == c2.power;
	}
	
	public boolean greater(Card c2) {
		return this.power > c2.power;
	}
}
