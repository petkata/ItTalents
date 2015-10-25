import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		// Въведете 2 различни числа от конзолата и разменете стойността им.
		//Разпечатайте новите стойности
		
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
		
		System.out.println("First number: " + firstNumber);
		System.out.println("Second number: " + secondNumber);
		
		System.out.println("After the change:");
		
		int middleNumber = firstNumber;
		
		firstNumber = secondNumber;
		secondNumber = middleNumber;
		
		System.out.println("first number: " + firstNumber);
		System.out.println("second number: " + secondNumber);
		
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
