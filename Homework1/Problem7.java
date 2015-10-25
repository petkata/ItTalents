import java.math.BigDecimal;
import java.util.Scanner;

public class Problem7 {

	public static void main(String[] args) {
		// �������� 3 ���������� �� ������������ � ��� (���������� ���), ����
		// ���� (����� � ������� �������), ���� ��� ����� � ����� ���.
		// ��������� ��������, ����� ����� ������� �� ������ �� ���� ����� ��
		// ������� �����:
		// - ��� ��� �����, ���� �� �������
		// - ��� ���� ����, �� �� ���� ���������
		// - ��� ����� � �� ���� ����� � �� ��� ���
		// - ��� ��� �����, �� ����� �� ���� � ��������
		// - ��� ���� ��-����� �� 10 ��, �� ����� �� ����.
		// ���������� ������� �������� ���� ��������� � ���������.

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter hour (0-24)");
		byte hour = 0;
		hour = CheckHour(hour);
		
		System.out.println("Enter amount of money");
		BigDecimal money = new BigDecimal(0);
		money = CheckMoney(money);
		
		System.out.println("Am I ill? (enter true or false) ");
		boolean isIll = false;
		isIll = CheckIfIll(isIll);
		
		sc.close();
		
		if (isIll == true) {
			System.out.println("I am not going out!");
			
			if (money.compareTo(BigDecimal.ZERO) > 0) {
				System.out.println("I will buy medicine!");
			} else {
				System.out.println("I am going to stay at home and drink tea!");
			}
		} else {
			if (money.compareTo(new BigDecimal(10F)) == 1){
				System.out.println("I am going to the cinema with my friends!");
			} else {
				System.out.println("I am going to a cafe.");
			}
		}
	}
	private static Byte CheckHour (byte number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextByte();
                inputOk = true;
            } catch (Exception e) {
                System.err.println("That's not a correct number! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return number;
	}
	
	private static BigDecimal CheckMoney (BigDecimal number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextBigDecimal();
                inputOk = true;
            } catch (Exception e) {
                System.err.println("That's not a correct number! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return number;
	}
	
	private static Boolean CheckIfIll (Boolean ifIll) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	ifIll = sc.nextBoolean();
                inputOk = true;
            } catch (Exception e) {
                System.err.println("That's not a correct statement! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return ifIll;
	}
}
