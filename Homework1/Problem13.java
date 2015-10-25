import java.util.Scanner;

public class Problem13 {

	public static void main(String[] args) {
		// Да се състави програма, която да отгатне колко е студено/топло по
		// въведената температура t в градус Целзий.
		// Температурните интервали са:
		// под -20 ледено студено;
		// между 0 и -20 - студено;
		// между 15 и 0 - хладно;
		// между 25 и 15 - топло;
		// над 25 – горещо.
		// Входни данни: цяло число от интервала [-100..100].

		System.out.println("Please enter temperature:");
		
		byte temp = 0;
		temp =CheckByte(temp);
		
		if (temp < -20) {
			System.out.println("It's freezing!!!");
		} else if (temp >= -20 && temp <= 0){
			System.out.println("it's cold!");
		} else if (temp > 0 && temp <= 15) {
			System.out.println("It's cool.");
		} else if (temp > 15 && temp <= 25) {
			System.out.println("It's warm!");
		} else {
			System.out.println("It's hot!!");
		}
	}
	private static byte CheckByte (byte number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextByte();
            	if (number < -100 || number > 100) {
            		System.err.println("Must be between -100 and 100! Try again!");
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
