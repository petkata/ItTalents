import java.util.Scanner;

public class Problem14 {

	public static void main(String[] args) {
		// Да се състави програма, която по въведени координати на 2 позиции
		// от шахматната дъска извежда отговор дали са оцветени в еднакъв или
		// различен цвят. 
		// Шахматната дъска е квадратна.
		// Въвеждат се две двойки числа от интервала [1..8].
		
		System.out.println("Enter the row of first position:");
		byte rowFirstPosition = 0;
		rowFirstPosition = CheckByte(rowFirstPosition);
		
		System.out.println("Enter the column of first position:");
		byte colFirstPosition = 0;
		colFirstPosition = CheckByte(colFirstPosition);
		
		System.out.println("Enter the row of second position:");
		byte rowSecondPosition = 0;
		rowSecondPosition = CheckByte(rowSecondPosition);
		
		System.out.println("Enter the column of second position:");
		byte colSecondPosition = 0;
		colSecondPosition = CheckByte(colSecondPosition);
		
		if (IsBlack(rowFirstPosition, colFirstPosition) && IsBlack(rowSecondPosition, colSecondPosition)) {
			System.out.println("They are the same colour!");
		} else {
			System.out.println("They are not the same colour!");
		}
	}
	
	private static Boolean IsBlack (byte pos1, byte pos2) {
		if ((pos1 % 2 != 0 && pos2 % 2 != 0) || (pos1 % 2 == 0 && pos2 % 2 == 0)) {
			return true;
		} else {
			return false;
		}
	}
	private static byte CheckByte (byte number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextByte();
            	if (number < 1 || number > 8) {
            		System.err.println("Must be between 1 and 8! Try again!");
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
