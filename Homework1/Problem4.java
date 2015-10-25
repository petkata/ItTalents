import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		// Въведете 2 различни числа от конзолата и ги разпечатайте в
		// нарастващ ред.

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first integer");
		int firstNumber = 0;
		firstNumber = CheckInteger(firstNumber);
		
		System.out.println("Enter the second integer");
		int secondNumber = 0;
		boolean isDiff = false;
		while(!isDiff) {
			secondNumber = CheckInteger(secondNumber);
			if (secondNumber == firstNumber) {
				System.err.println("Enter different number");
			} else {
				isDiff = true;
			}
		}
		
		
		sc.close();
		
		if (firstNumber > secondNumber) {
			System.out.println(secondNumber + ", " + firstNumber);
		} else {
			System.out.println(firstNumber + ", " + secondNumber);
		}
	}
	private static int CheckInteger (int number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextInt();
                inputOk = true;
            } catch (Exception e) {
                System.err.println("That's not an integer! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return number;
	}

}
