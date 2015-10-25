import java.util.Scanner;

public class Problem11 {

	public static void main(String[] args) {
		// Съставете програма, която по дадено трицифренo число проверява
		// дали числото се дели на всяка своя цифра. Във въведеното число да
		// няма цифра 0.

		System.out.println("Enter 3 digit number without zeroes");
		
		int number = 0;
		number = CheckInteger(number);
		
		int firstDigit = number / 100 ;
		int secondDigit = (number - (number / 100) * 100) /10;
		int thirdDigit = number % 10;	
		
		if ((number % firstDigit == 0) && 
			(number % secondDigit == 0) && 
			(number % thirdDigit == 0)) {
			
			System.out.println("The number " + number + " can be divided by each of the consisting digits!");
		} else {
			System.out.println("The number " + number + " can't be divided!");
		}
		
	}
	private static int CheckInteger (int number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextInt();
            	if (number < 111 || number > 999) {
            		System.err.println("Must be between 111 and 999! Try again!");
				} else if (((number / 10) % 10 != 0) && number % 10 != 0) {
					inputOk = true;
				}else {
					System.err.println("Can't contain '0'! Try again!");
				}
            } catch (Exception e) {
                System.err.println("That's not an integer! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return number;
	}

}
