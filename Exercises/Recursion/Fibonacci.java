import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
//		Да се състави програма, която изчислява N-тото число на Фибоначи.
//		Първото и второто число на Фибоначи са 1-ци, всяко следващо е равно
//		на сбора на предходните 2.

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int num = sc.nextInt();
		sc.close();
		showFibNumber(num);
	}

	private static void showFibNumber(int num) {
		System.out.printf("the %d fibonacci number is %d" , num, calculateFibNum(num));
	}

	private static int calculateFibNum(int num) {
		//considering that there is no '0' Fibonacci number
		if (num == 1) {
			return 1;
		}
		if (num == 2) {
			return 1;
		}
		return (calculateFibNum(num-1) + calculateFibNum(num -2));
	}
}
