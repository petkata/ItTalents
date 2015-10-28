import java.util.Scanner;

public class Task16 {

	public static void main(String[] args) {
//		Да се състави програма, чрез която се въвеждат 2 естествени
//		числа N, M от интервала [10..5555].
//		Програмата, чрез цикъл for, да извежда всички числа от
//		интервала, които са кратни на 50 в низходящ ред.
//		Пример: 25,249
//		Изход: 200,150,100, 50.
//		
//		Da se sastavi programa, chrez koyato se vavezhdat 2 estestveni
//		chisla N, M ot intervala [10..5555].
//		Programata, chrez tsikal for, da izvezhda vsichki chisla ot
//		intervala, koito sa kratni na 50 v nizhodyasht red.
//		Primer: 25,249
//		Izhod: 200,150,100, 50.

		int firstNum;
		int secondNum;
		int middleNum;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter first number [10-5555]:");
		firstNum = sc.nextInt();
		
		while(firstNum < 10 || firstNum > 5555) {
			System.out.println("Enter a positive number between 10 and 5555 including and try again!");
			firstNum = sc.nextInt();
		}
		
		System.out.println("Please enter second number [10-5555]:");
		secondNum = sc.nextInt();
		while(secondNum < 10 || secondNum > 5555) {
			System.out.println("Enter a positive number between 10 and 5555 including and try again!");
			secondNum = sc.nextInt();
		}
		sc.close();
		
		if (firstNum > secondNum) {
			middleNum = firstNum;
			firstNum = secondNum;
			secondNum = middleNum;			
		}		
		
		for (int i = secondNum ; i > firstNum; i --) {
			if (i % 50 != 0) {
				continue;
			}
			System.out.print(i + " ");
		}
	}

}
