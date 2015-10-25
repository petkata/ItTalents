import java.util.Scanner;

public class Problem5 {
	public static void main(String[] args) {
		//�������� 3 �������� ����� �� ��������� � �� ������������ � ��������
		// ���.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first integer");
		int firstNumber = 0;
		firstNumber = CheckInteger(firstNumber);
		
		System.out.println("Enter the second integer");
		int secondNumber = 0;
		boolean isDiff = false;
		while(!isDiff) {
			secondNumber = CheckInteger(secondNumber);
			if (secondNumber == firstNumber) {
				System.err.println("Enter different number");
			} else {
				isDiff = true;
			}
		}
		
		System.out.println("Enter the third integer");
		int thirdNumber = 0;
		isDiff = false;
		while(!isDiff) {
			thirdNumber = CheckInteger(thirdNumber);
			if (thirdNumber == firstNumber || thirdNumber == secondNumber) {
				System.err.println("Enter different number");
			} else {
				isDiff = true;
			}
		}
		sc.close();
		
		if (firstNumber > secondNumber && secondNumber > thirdNumber) {
			System.out.println(firstNumber + ", " + secondNumber + ", " + thirdNumber);
		} else if (secondNumber > firstNumber && firstNumber > thirdNumber) {
			System.out.println(secondNumber + ", " + firstNumber + ", " + thirdNumber);
		} else if (thirdNumber > firstNumber && firstNumber > secondNumber) {
			System.out.println(thirdNumber + ", " + firstNumber + ", " + secondNumber);
		} else if (firstNumber > thirdNumber && thirdNumber > secondNumber) {
			System.out.println(firstNumber + ", " + thirdNumber + ", " + secondNumber);
		} else if (secondNumber > thirdNumber && thirdNumber > firstNumber) {
			System.out.println(secondNumber + ", " + thirdNumber + ", " + firstNumber);
		} else {
			System.out.println(thirdNumber + ", " + secondNumber + ", " + firstNumber);
		}
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
}
