import java.util.Scanner;

public class Task9 {
	
	public static void main(String[] args) {
		/*
		 *  �� �� �������� 2 ����� �� ������������ � � �.
			�� �� ������� ������ ����� �� � �� � �� ������ 2(��������� �
			�������).��� ����� ����� � ������ �� 3, �� �� ������ ��������� ��
			������� �� �������� �skip 3�.��� ������ �� ������ �������� ����� (���
			������������) ����� ��-������ �� 200, �� �� �������� �����������.
			
			Da se prochetat 2 chisla ot klaviaturata A i V.
			Da se izvedat vsichki chisla ot A do V na stepen 2(razdeleni s
			zapetaya).Ako nyakoe chislo e kratno na 3, da se izvede saobshtenie che
			chisloto se propuska �skip 3�.Ako sumata ot vsichki izvedeni chisla (bez
			propusnatite) stane po-golyama ot 200, da se prekrati izvezhdaneto.
		 */
		
		int firstNum;
		int secondNum;
		int middleNum;
		int sum = 0;
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
		
		for (int i = 0; firstNum <= secondNum;i++, firstNum++) {
			if (i > 0 && i < secondNum) {
				System.out.print(", ");
			};
			if ((firstNum * firstNum) % 3 == 0) {
				System.out.print("skip 3");
				continue;
			}
			System.out.print(firstNum * firstNum);
			
			sum += firstNum * firstNum;
			if (sum > 200) {
				break;
			}
		}
		if (sum > 200) {
			System.err.printf("%nAborted! Reached max sum 200! Current sum is " + sum);
		}else {
			System.out.printf("%nThe sum is " + sum);
		}
	}
}
