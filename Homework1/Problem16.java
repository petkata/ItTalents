import java.util.Scanner;

public class Problem16 {

	public static void main(String[] args) {
		// Въведено е трицифрено естествено число от вида abc.
		// Трябва да се провери дали:
		// ако a = b = c - Изход: цифрите са равни;
		// ако a>b>c - Изход: цифрите са във възходящ ред;
		// ако a<b<c цифрите са в низходящ ред;
		// и изход: цифрите са ненаредени, за неописаните случаи.
		// Да се състави програма, която извежда резултата от проверката за
		// наредба на цифрите в числото. 

System.out.println("Enter 3 digit number");
		
		Scanner sc = new Scanner(System.in);
		
		int number = 0;
		number = CheckByte(number);
		
		int firstDigit = number / 100 ;
		int secondDigit = (number - (number / 100) * 100) /10;
		int thirdDigit = number % 10;
		
		if (firstDigit == secondDigit && firstDigit == thirdDigit) {
			System.out.println("Digits are equal!");
		} else if (firstDigit > secondDigit && secondDigit > thirdDigit) {
			System.out.println("Digits are in descending order");
		} else if (firstDigit < secondDigit && secondDigit < thirdDigit) {
			System.out.println("Digits are in ascending order!");
		} else {
			System.out.println("Digits are unordered!");
		}
	}
	private static int CheckByte (int number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextInt();
            	if (number < 100 || number > 999) {
            		System.err.println("Must be between 100 and 999! Try again!");
				} else {
					inputOk = true;
				}
            } catch (Exception e) {
                System.err.println("That's not an integer! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return number;
	}

}
