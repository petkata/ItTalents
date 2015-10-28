import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
		/*
		 * Да се прочете число от екрана(конзолата) и да се 
		 * изведе сбора на всички числа между 1 и въведеното число.
		 * Da se prochete chislo ot ekrana(konzolata) i da se 
		 * izvede sbora na vsichki chisla mezhdu 1 i vavedenoto chislo.
		 */
		
		int num;
		boolean isNegative = false;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter a number");
		num = sc.nextInt();
		
		sc.close();
		
		if (num < 0) {
			num *= -1;
			isNegative = true;;
		}
		
		for (int i = 1; i <= num; i++) {
			sum+=i;
		}
		
		if (isNegative) {
			System.out.println((sum *= -1) +1 );
		} else {
			System.out.println(sum);
		}
		
	}

}
