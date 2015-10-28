import java.util.Scanner;

public class Task13 {

	public static void main(String[] args) {
//		 Да се състави програма, която извежда всички
//		 естествени трицифрени числа, които имат сбор на цифрите равен
//		 на дадено число.
//		 Дадено : sum, където 2>=sum<=27.
//		 Пример: 26
//		 Изход: 899, 989, 998.
//		 
//		 Da se sastavi programa, koyato izvezhda vsichki
//		 estestveni tritsifreni chisla, koito imat sbor na tsifrite raven
//		 na dadeno chislo.
//		 Dadeno : sum, kadeto 2>=sum<=27.
//		 Primer: 26
//		 Izhod: 899, 989, 998.

		int sum;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter sum:");
		sum = sc.nextInt();
		
		while(sum < 2 || sum > 27) {
			System.out.println("Enter a positive number between 2 and 27 including and try again!");
			sum = sc.nextInt();
		}
		sc.close();
		
		for (int i = 100; i <= 999; i++) {
			int firstDigit = i / 100;
			int secondDigit = (i % 100) /10;
			int thirdDigit = (i % 100) % 10;
			if ((firstDigit + secondDigit + thirdDigit) != sum) {
				continue;
			}
			System.out.print(i + " ");
		}
		
	}

}
