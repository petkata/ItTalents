import java.util.Scanner;

public class Task21 {
	public static void main(String[] args) {
//		Дадено е наредено тесте карти.
//		Наредбата по тежест на карта е: 2,3,4,5,6,7,8,9,10, Вале, Дама,
//		Поп, Асо.
//		Наредбата по цвят на картите е: спатия, каро, купа, пика.
//		Да се създаде програма, чрез която се въвежда N - число от
//		интервала [1..51] и се извеждат въведения номер карта и
//		останалите по-големи карти от тестето. 
//		
//		Dadeno e naredeno teste karti.
//		Naredbata po tezhest na karta e: 2,3,4,5,6,7,8,9,10, Vale, Dama,
//		Pop, Aso.
//		Naredbata po tsvyat na kartite e: spatiya, karo, kupa, pika.
//		Da se sazdade programa, chrez koyato se vavezhda N - chislo ot
//		intervala [1..51] i se izvezhdat vavedeniya nomer karta i
//		ostanalite po-golemi karti ot testeto. 
		
		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter number:");
		num = sc.nextInt();
		
		while(num < 1 || num > 51) {
			System.out.println("Enter a positive number between 1 and 51 including and try again!");
			num = sc.nextInt();
		}
		sc.close();
		
		char cardColour = 'N';
		char highCard = 'N';
		int counter = 1; 
		
		for (int j = num; j <= 52; j++) {
			for (int i = j; i <= 52 && i > 0; i -= 4) {
				switch (i) {
				case 1:
					cardColour = 'C'; // C - Clubs
					break;
				case 2:
					cardColour = 'D'; // D - Diamonds
					break;
				case 3:
					cardColour = 'H'; // H - Hearts
					break;
				case 4:
					cardColour = 'S'; // S - Spades
					break;
				default:
					break;
				}
				counter++;
				switch (counter) {
				case 11:
					highCard = 'J'; //Jack
					break;
				case 12:
					highCard = 'Q'; // Queen
					break;
				case 13:
					highCard = 'K'; // King
					break;
				case 14:
					highCard = 'A'; // Ace
					break;
				default:
					break;
				}
			}
			if (counter > 10) {
				System.out.print(highCard + "" + cardColour + " ");
			} else {
				System.out.print(counter + "" + cardColour + " ");
				}
			counter = 1;
		}
		
		
	}
}
