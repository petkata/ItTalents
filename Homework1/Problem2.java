import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		// Въведете 2 различни целочислени числа от конзолата. Запишете
		// тяхната сума, разлика, произведение, остатък от деление и
		// целочислено деление в отделни променливи и разпечатайте тези
		// резултати в конзолата. Опитайте същото с числа с плаваща запетая.
		
		System.out.println("Enter the first integer");
		int firstNumber = 0;
		firstNumber = CheckInteger(firstNumber);
		
		System.out.println("Enter the second integer");
		int secondNumber = 0;
		secondNumber = CheckInteger(secondNumber);
		
		int sum = firstNumber + secondNumber;
		int substraction = firstNumber - secondNumber;
		int multip = firstNumber * secondNumber;
		int div = firstNumber / secondNumber;
		int remainder = firstNumber % secondNumber;
		
		System.out.format("The sum of %d and %d is: %d%n", firstNumber, secondNumber , sum);
		System.out.format("The substraction of %d and %d is: %d%n", firstNumber, secondNumber , substraction);
		System.out.format("The multiplication of %d and %d is: %d%n", firstNumber, secondNumber , multip);
		System.out.format("The integer division of %d and %d is: %d%n", firstNumber, secondNumber , div);
		System.out.format("The remainder of dividing %d and %d is: %d%n", firstNumber, secondNumber , remainder);
		
		// Doubles
		System.out.println(" Doubles ");
		System.out.println("Enter the first double");
		double firstDouble = 0;
		firstDouble = CheckDouble(firstDouble);
		
		System.out.println("Enter the second doble");
		double secondDouble = 0;
		secondDouble = CheckDouble(secondDouble);
		
		double sumDouble = firstDouble + secondDouble;
		double substractionDouble = firstDouble - secondDouble;
		double multipDouble = firstDouble * secondDouble;
		double divDouble = firstDouble / secondDouble;
		double remainderDouble = firstDouble % secondDouble;
		
		System.out.format("The sum of %f and %f is: %f%n", firstDouble, secondDouble , sumDouble);
		System.out.format("The substraction of %f and %f is: %f%n", firstDouble, secondDouble , substractionDouble);
		System.out.format("The multiplication of %f and %f is: %f%n", firstDouble, secondDouble , multipDouble);
		System.out.format("The integer division of %f and %f is: %f%n", firstDouble, secondDouble , divDouble);
		System.out.format("The remainder of dividing %f and %f is: %f%n", firstDouble, secondDouble , remainderDouble);
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
	
	private static double CheckDouble (double number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk){
			try {
				number = sc.nextDouble();
				inputOk = true;
			} catch (Exception e) {
				System.err.println("That's not a double! TRY AGAIN!");
				sc.next();
			}
		}
		
		return number;
	}
}
