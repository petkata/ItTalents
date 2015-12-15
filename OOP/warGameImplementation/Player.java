package warGameImplementation;

public class Player {

	private String name;
	private int receivedCards = 0;//how many cards have been already dealt
	private Card[] dealtCards = new Card[26];//all cards the player has
	private int wonCards = 0;
	
	Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCardsWon() { return wonCards;}
	
	//called when the deck is being dealt
	void receiveCard(Card card) {
		dealtCards[receivedCards++] = card;
	}
	
	Card drawCard() {
		return dealtCards[receivedCards-- - 1];
	}
	
	void winCard() {
		wonCards++;
	}
	public int getReceivedCards(){
		return this.receivedCards;
	}
	boolean outOfCards() {
		return receivedCards == 0;
	}
}
