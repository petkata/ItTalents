package warGameImplementation;

import java.util.Random;

public class Deck {

	private static final int CARD_NUMBER = 52;
	private static final String[] CARD_STRENGTHS = 
		{"2", "3", "4", "5", "6", "7", "8","9", "10", "J", "Q", "K", "A"};
	private static final String[] CARD_SUITS = {"\u2663", "\u2665", "\u2666", "\u2660"};
	private Card[] cards;
	
	Deck() {
		cards = new Card[CARD_NUMBER];
		createCards();
		shuffleCards();
	}
	
	//creates all cards in the deck
	private void createCards() {
		int cnt = 0;
		for(int i = 0 ; i < CARD_STRENGTHS.length; i++) {
			for(int j = 0; j < CARD_SUITS.length; j++) {
				Card card = new Card(CARD_STRENGTHS[i], CARD_SUITS[j]);
				card.setPower(i);
				cards[cnt++] = card;
			}
		}
	}
	//shuffles all cards in the deck
	private void shuffleCards() {
		for(int i = 0; i < cards.length; i++) {
			Random r = new Random();
			int rand = r.nextInt(CARD_NUMBER-1);
			Card temp = cards[i];
			cards[i] = cards[rand];
			cards[rand] = temp;
		}
	}
	
	void deal(Player p1, Player p2) {
		for(int i = 0; i < cards.length; i+=2) {
			p1.receiveCard(cards[i]);
			p2.receiveCard(cards[i+1]);
		}
	}
	
	void printAllCards() {
		for(int i = 0; i < cards.length; i++) {
			cards[i].printInfo();
		}
	}
}

