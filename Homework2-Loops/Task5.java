import java.util.Scanner;

public class Task5 {

	public static void main(String[] args) {
		/*
			�� �� ������� �� ����������� 2 �����. � �� ��
			������� �� ������ ������ ����� �� ��-������� �� ��-��������
			Da se vavedat ot potrebitelya 2 chisla. I da se
			izvedat na ekrana vsichki chisla ot po-malkoto do po-golyamoto
		 */
		
		int firstNum;
		int secondNum;
		int middleNum;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter first number:");
		firstNum = sc.nextInt();
		
		System.out.println("Please enter second number:");
		secondNum = sc.nextInt();
		
		sc.close();
		
		if (firstNum > secondNum) {
			middleNum = firstNum;
			firstNum = secondNum;
			secondNum = middleNum;
		}
		
		while (firstNum <= secondNum) {
			System.out.print(firstNum + " ");
			firstNum++;
		}
	}

}
