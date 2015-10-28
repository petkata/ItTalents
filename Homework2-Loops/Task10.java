import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) {
		/*
		 *  �������� ����� �� ������������ � ���������� ���� � 
		 *  ������. ������ ����� � ���� ����� �� ���� ���� �� 1 � �� ���� ��.
		 *   Vavedete chislo ot klaviaturata i opredelete dali e 
		 *   prosto. Prosto chislo e tova koeto se deli SAMO na 1 i na sebe si.
		 */

		int num = 0;
		boolean isPrime = true;
		Scanner sc = new Scanner(System.in);		
		
		while (num <= 0) {
			System.out.println("Please enter a positive number");
			num = sc.nextInt();
		}
		sc.close();
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println(num + " is a Prime number");
		} else {
			System.out.println(num + " is NOT a Prime number");
		}
	}

}
