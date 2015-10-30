import java.util.Scanner;

public class Task22 {

	public static void main(String[] args) {
//		Да се състави програма, която извежда първите 10 най-малки
//		числа, които се делят на 2, 3 или на 5 и които са по-големи от
//		въведено естествено число.
//		Числата се извеждат, заедно с техния пореден номер.
//		Входни данни: число от интервала [1..999]
//
//		Da se sastavi programa, koyato izvezhda parvite 10 nay-malki
//		chisla, koito se delyat na 2, 3 ili na 5 i koito sa po-golemi ot
//		vavedeno estestveno chislo.
//		Chislata se izvezhdat, zaedno s tehniya poreden nomer.
//		Vhodni danni: chislo ot intervala [1..999]
		
		int num;
		int count = 1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter number:");
		num = sc.nextInt();
		
		while(num < 1 || num > 999) {
			System.out.println("Enter a positive number between 1 and 999 including and try again!");
			num = sc.nextInt();
		}
		sc.close();

		int nextNum = num +1;
		
		while (count <= 10) {
			if (nextNum % 2 == 0 || nextNum % 3 == 0 || nextNum % 5 == 0) {
				System.out.print(count + ":" + nextNum);
				if (count < 10) {
					System.out.print(", ");
				}
				count++;
			} 
			nextNum++;
		}
	}

}
