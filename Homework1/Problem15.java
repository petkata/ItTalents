import java.util.Scanner;

public class Problem15 {

	public static void main(String[] args) {
		// Да се състави програма, която въвежда естествено число от интервала
		// [0..24].
		// Програмата да изведе съответстващо съобщение съобразно въведения
		// час.
		// Периодите са:
		//	[18..4] - Добър вечер;
		//	[4..9] - Добро утро;
		//	[9..18] - Добър ден

		System.out.println("Please enter hour[0-24]");
		
		byte hour = 0;
		hour = CheckByte(hour);
		
		if (hour >= 18 || hour <= 4){
			System.out.println("Добър вечер!");
		} else if (hour > 4 && hour <= 9) {
			System.out.println("Добро утро!");
		} else {
			System.out.println("Добър ден!");
		}
	}
	private static byte CheckByte (byte number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextByte();
            	if (number < 0 || number > 24) {
            		System.err.println("Must be between 0 and 24! Try again!");
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
