import java.util.Scanner;

public class Task15 {

	public static void main(String[] args) {
//		 Да се състави програма, която да изчисли сумата на
//		 всички числа от 1 до въведено число N.
//
//		 Da se sastavi programa, koyato da izchisli sumata na
//		 vsichki chisla ot 1 do vavedeno chislo N.
		
		int num;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter number:");
		num = sc.nextInt();
		
		while(num < 0) {
			System.out.println("Enter a positive number and try again!");
			num = sc.nextInt();
		}
		sc.close();
		
		do {
			sum += num;
			num--;
		} while (num>=0);
		System.out.println(sum);
	}

}
