import java.util.Scanner;

public class Problem8 {

	public static void main(String[] args) {
		// Да се състави програма, която чете от конзолата 4-цифренo
		// естествено число от интервала [1000.. 9999]. От това число се
		// формират 2 нови 2-цифрени числа. Първото число се формира от 1-та
		// и 4-та цифра на въведеното число. Второто число се формира от 2-рa -
		// 3-та цифра на въведеното число. Като резултат да се изведе дали 1-то
		// ново число e по-малко <, равно = или по-голямо от 2-то число.

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter four digit integer between 1000 and 9999");
		short number = 0;
		number = CheckShort(number);
		
		sc.close();
		
		byte firstTwoNewNumbers = (byte) ((number / 1000) * 10 + (number % 10));
		byte secondTwoNewNumbers = (byte) (((number % 1000) - (number % 10))/10);
		if (firstTwoNewNumbers > secondTwoNewNumbers) {
			System.out.println(firstTwoNewNumbers + " is greater than " + secondTwoNewNumbers);
		} else if (firstTwoNewNumbers < secondTwoNewNumbers){
			System.out.println(firstTwoNewNumbers + " is less than " + secondTwoNewNumbers);
		} else {
			System.out.println(firstTwoNewNumbers + " is equal to " + secondTwoNewNumbers);
		}
	}
	private static short CheckShort (short number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextShort();
            	if (number / 1000 <= 9 && number /1000 > 0) {
            		inputOk = true;
				} else {
					System.err.println("Must be between 1000 and 9999");
				}
                
            } catch (Exception e) {
                System.err.println("That's not an integer! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return number;
	}
}
