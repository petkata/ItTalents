import java.util.Scanner;

public class Problem9 {

	public static void main(String[] args) {
		// �� �� ������� ��������, ����� ���� �� ��������� 2 ����������
		// ���������� ����� a,b.
		// ���������� �� ������ � ��������� ���� ���������� ����� ��
		// �������������� �� ����� ����� � �����, ����� � ������ �����.
		// ������ �����: a,b - ���������� ����� �� ��������� [10..99].

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first number (10-99)");
		byte firstNumber = 0;
		firstNumber = CheckByte(firstNumber);
		
		System.out.println("Enter the second number (10-99)");
		byte secondNumber = 0;
		secondNumber = CheckByte(secondNumber);
		
		sc.close();
		
		short multip = (short) (firstNumber*secondNumber);
		byte lastDigit = (byte) (multip % 10);
		boolean isOdd = true;
		if (lastDigit % 2 == 0) {
			isOdd = false;
		}
		if (isOdd == true) {
			System.out.println(multip + ", " + lastDigit + " is odd.");
		} else {
			System.out.println(multip + ", " + lastDigit + " is even.");
		}
	}
	private static byte CheckByte (byte number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextByte();
            	if (number >= 10 && number <= 99) {
            		inputOk = true;
				} else {
					System.err.println("The number should be between 10 and 99. Please try again.");
				}
            } catch (Exception e) {
                System.err.println("That's not an integer! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return number;
	}
}
