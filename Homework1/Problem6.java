import java.util.Scanner;

public class Problem6 {

	public static void main(String[] args) {
		// Въведете 3 числа от клавиатурата а1, а2 и а3. Разменете стойностите
		// им така, че а1 да има стойността на а2, а2 да има стойността на а3, а
		// а3 да има старата стойност на а1.

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first integer");
		int firstNumber = 0;
		firstNumber = CheckInteger(firstNumber);
		
		System.out.println("Enter the second integer");
		int secondNumber = 0;
		secondNumber = CheckInteger(secondNumber);
		
		System.out.println("Enter the third integer");
		int thirdNumber = 0;
		thirdNumber = CheckInteger(thirdNumber);
		
		sc.close();
		
		System.out.println("First number: " + firstNumber);
		System.out.println("Second number: " + secondNumber);
		System.out.println("Third number: " + thirdNumber);
		
		System.out.println("After the change:");
		
		int middleNumber = firstNumber;
		
		firstNumber = secondNumber;
		secondNumber = thirdNumber;
		thirdNumber = middleNumber;
		
		System.out.println("first number: " + firstNumber);
		System.out.println("second number: " + secondNumber);
		System.out.println("Third number: " + thirdNumber);
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
