import java.util.Scanner;

public class Task14 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Да се състави метод, който приема за стойност число N и връща
//		стойността на N! (N факториел).
		
		System.out.println("Please enter a number:");
		
		int num = validateInput(sc.nextInt());
		
		sc.close();
		
		printFactorial(num);
	}
	
	static int validateInput(int num){
		if (num <= 0) {
			System.out.println("Please enter a positive number!");
			num = validateInput(sc.nextInt());
		}
		return num;
	}
	
	static void printFactorial (int num) {
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact *= i;
		}
		System.out.println(fact);
	}
}
