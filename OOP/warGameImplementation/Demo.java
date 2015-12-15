package warGameImplementation;

public class Demo {

	public static void main(String[] args) {
		Deck d = new Deck();
		Player krasi = new Player("Krasi");
		Player niki = new Player("Niki");
		d.deal(krasi, niki);
		startGame(krasi, niki);
		checkWinner(krasi, niki);
	}
	
	private static void startGame(Player p1, Player p2) {
		while(true) {
			if(p1.outOfCards() || p2.outOfCards()) {
				break;
			}
			Card c1 = p1.drawCard();
			Card c2 = p2.drawCard();
			System.out.println(p1.getName() + " draws " + c1.printInfo() + " VS " + p2.getName() + " draws " + c2.printInfo());
			
			if(c1.warWith(c2)) {
				startWar(p1, p2, 2);
			} else {
				if(c1.greater(c2)) {
					p1.winCard();
					p1.winCard();
					System.out.println(p1.getName() + " won ");// +p1.getCardsWon());
				} else {
					p2.winCard();
					p2.winCard();
					System.out.println(p2.getName() + " won ");// +p2.getCardsWon());
				}
			}
		}
	}
	
	private static void startWar(Player p1, Player p2, int winCards) {
		if (p1.getReceivedCards() == 0 || p2.getReceivedCards() == 0) {
			System.out.println("these were the last cards");
			return;
		}
		//if remaining cards are less than 3 then draw only one
		if (p1.getReceivedCards() <3 || p2.getReceivedCards() <3) {
			//
			System.out.println("Remaining " + p1.getReceivedCards() + " card"+((p2.getReceivedCards() > 1)? "s": "")+".Draw only one.");
			decidingCardCompare(p1, p2, winCards-4);
			//
			return;
		}
		System.out.println("WAR ");
		System.out.println("\t"+p1.getName() + " draws " + p1.drawCard().printInfo() + "  " + p2.getName() + " draws " + p2.drawCard().printInfo());
		System.out.println("\t"+p2.getName() + " draws " + p1.drawCard().printInfo() + "  " + p2.getName() + " draws " + p2.drawCard().printInfo());
		//
		decidingCardCompare(p1, p2, winCards);
		//
	}
	
	private static void checkWinner(Player p1, Player p2) {
		int p1won = p1.getCardsWon();
		int p2won = p2.getCardsWon();
		if(p1won > p2won) {
			System.out.println(p1.getName() + " is the winner with " + p1won + " cards");
		}
		else
		if(p1won < p2won) {
			System.out.println(p2.getName() + " is the winner with " + p2won + " cards");
		}
		else {
			System.out.println("Both have " + p1.getCardsWon());
		}
	}
	
	private static void decidingCardCompare(Player p1, Player p2, int winCards){
		Card decidingCard1 = p1.drawCard();
		Card decidingCard2 = p2.drawCard();
		System.out.println("\t"+p1.getName() + " draws deciding card " + decidingCard1.printInfo() + " VS " + p2.getName() + " draws deciding card " + decidingCard2.printInfo());
		if(decidingCard1.warWith(decidingCard2)) {
			System.out.print("\t");
			startWar(p1, p2, winCards+6);
		} else {
			if(decidingCard1.greater(decidingCard2)) {
				for(int i = 0; i < winCards+6; i++) {
					p1.winCard();
					
				}
				System.out.println(p1.getName() + " won the war");// +p1.getCardsWon());
			}
			else {
				for(int i = 0; i < winCards+6; i++) {
					p2.winCard();
					
				}
				System.out.println(p2.getName() + " won the war");// +p2.getCardsWon());
			}
		}
	}
}
