import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		// �� �� ������� ��������� ��� ����������� � �� �� �������� 2 ����� ��
		// ������������ A � B (���� �� �� � ������� ������� � double).
		// ����� �� �� ������� 3-�� ����� C � �� �� ������� ���� �� � �/� A � B.
		// �� �� ������ ��������� ��������� �� ���� ���� C � ����� A � B.

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the first number (can be floating point number)");
		double firstNumber = sc.nextDouble();
		
		System.out.println("Please enter the second number (can be floating point number)");
		double secondNumber = sc.nextDouble();
		
		System.out.println("Please enter the third number (can be floating point number)");
		double thirdNumber = sc.nextDouble();
		
		sc.close();
		
		if ((thirdNumber > firstNumber && thirdNumber < secondNumber) || (thirdNumber < firstNumber && thirdNumber > secondNumber)) {
			if (thirdNumber > firstNumber && thirdNumber < secondNumber) {
				System.out.println("The number " + thirdNumber + " is between " + firstNumber + " and " + secondNumber + ".");
			} else {
				System.out.println("The number " + thirdNumber + " is between " + secondNumber + " and " + firstNumber + ".");					
			}
		} else {
			if (firstNumber > secondNumber) {
				System.out.println("The number " + thirdNumber + " is not between " + secondNumber + " and " + firstNumber + ".");
			} else if(thirdNumber == firstNumber) {
				System.out.println("The number " + thirdNumber + " is equal to " + firstNumber + ".");
			} else if(thirdNumber == secondNumber) {
				System.out.println("The number " + thirdNumber + " is equal to " + secondNumber + ".");
			}
			
			else {
				System.out.println("The number " + thirdNumber + " is not between " + firstNumber + " and " + secondNumber + ".");
			}
			
		}

	}

}
