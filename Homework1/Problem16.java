import java.util.Scanner;

public class Problem16 {

	public static void main(String[] args) {
		// �������� � ���������� ���������� ����� �� ���� abc.
		// ������ �� �� ������� ����:
		// ��� a = b = c - �����: ������� �� �����;
		// ��� a>b>c - �����: ������� �� ��� �������� ���;
		// ��� a<b<c ������� �� � �������� ���;
		// � �����: ������� �� ����������, �� ����������� ������.
		// �� �� ������� ��������, ����� ������� ��������� �� ���������� ��
		// ������� �� ������� � �������. 

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
