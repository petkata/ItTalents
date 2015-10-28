import java.util.Scanner;

public class Task14 {

	public static void main(String[] args) {
//		Да се състави програма, която по въведено
//		естествено число N от интервала [10..200] извежда в обратен
//		ред всички числа, които са кратни на 7 и са по-малки от N.
//
//		Da se sastavi programa, koyato po vavedeno
//		estestveno chislo N ot intervala [10..200] izvezhda v obraten
//		red vsichki chisla, koito sa kratni na 7 i sa po-malki ot N.
		
		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter number [10-200]:");
		num = sc.nextInt();
		
		while(num < 10 || num > 200) {
			System.out.println("Enter a positive number between 10 and 200 including and try again!");
			num = sc.nextInt();
		}
		sc.close();
		
		for (int i = num - 1; i > 0; i --) {
			if (i % 7 != 0) {
				continue;
			}
			System.out.print(i + " ");
		}
	}

}
