import java.util.Scanner;

public class Problem13 {

	public static void main(String[] args) {
		// �� �� ������� ��������, ����� �� ������� ����� � �������/����� ��
		// ���������� ����������� t � ������ ������.
		// �������������� ��������� ��:
		// ��� -20 ������ �������;
		// ����� 0 � -20 - �������;
		// ����� 15 � 0 - ������;
		// ����� 25 � 15 - �����;
		// ��� 25 � ������.
		// ������ �����: ���� ����� �� ��������� [-100..100].

		System.out.println("Please enter temperature:");
		
		byte temp = 0;
		temp =CheckByte(temp);
		
		if (temp < -20) {
			System.out.println("It's freezing!!!");
		} else if (temp >= -20 && temp <= 0){
			System.out.println("it's cold!");
		} else if (temp > 0 && temp <= 15) {
			System.out.println("It's cool.");
		} else if (temp > 15 && temp <= 25) {
			System.out.println("It's warm!");
		} else {
			System.out.println("It's hot!!");
		}
	}
	private static byte CheckByte (byte number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextByte();
            	if (number < -100 || number > 100) {
            		System.err.println("Must be between -100 and 100! Try again!");
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
