import java.util.Scanner;
public class PrimaryNumber {

	public static void main(String[] args) {
//		Check if number is primary
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number");
		int inputNumber = validateNumber(sc);
		printWetherNumberIsPrime(inputNumber , 1);
	}

	private static void printWetherNumberIsPrime(int num, int i) {
		if (i == num) {
			System.out.println("Is prime");
			return;
		} 
		if (num % i == 0 && i != 1) {
			System.out.println("NOT prime");
			return;
		}
		else {
			printWetherNumberIsPrime(num, ++i);
		}
	}

	private static int validateNumber(Scanner sc) {
		int num = sc.nextInt();
		if (num <= 0) {
			System.out.println("Please enter a positive number!");
			return validateNumber(sc);
		} else {
			return num;
		}
	}
	
}
