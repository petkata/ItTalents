import java.util.Scanner;

public class Task18 {

	public static void main(String[] args) {
//		�� �� ������� ��������, ���� ����� �� ������� ��� ����� ��
//		��������� [1..9].
//		���������� �� ������� ��������� �� ���������.
//		������������ �������� �� ����������� � ���������� �� 2-��
//		�����.
//
//		Da se sastavi programa, chrez koyato se vavezhda dve chisla ot
//		intervala [1..9].
//		Programata da izvezhda tablitsata za umnozhenie.
//		Maksimalnata stoynost na mnozhitelite e opredelena ot 2-te
//		chisla.
		
		int firstNum;
		int secondNum;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter first number [1-9]:");
		firstNum = sc.nextInt();
		
		while(firstNum < 1 || firstNum > 9) {
			System.out.println("Enter a positive number between 1 and 9 including and try again!");
			firstNum = sc.nextInt();
		}
		
		System.out.println("Please enter second number [1-9]:");
		secondNum = sc.nextInt();
		while(secondNum < 1 || secondNum > 9) {
			System.out.println("Enter a positive number between 1 and 9 including and try again!");
			secondNum = sc.nextInt();
		}
		sc.close();
		
		for (int i = 1; i <= firstNum; i++) {
			for (int j = 1; j <= secondNum; j++) {
				System.out.println(i + "*" + j + "=" + j * i);
			}
		}
	}

}
