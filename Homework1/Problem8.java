import java.util.Scanner;

public class Problem8 {

	public static void main(String[] args) {
		// �� �� ������� ��������, ����� ���� �� ��������� 4-������o
		// ���������� ����� �� ��������� [1000.. 9999]. �� ���� ����� ��
		// �������� 2 ���� 2-������� �����. ������� ����� �� ������� �� 1-��
		// � 4-�� ����� �� ���������� �����. ������� ����� �� ������� �� 2-�a -
		// 3-�� ����� �� ���������� �����. ���� �������� �� �� ������ ���� 1-��
		// ���� ����� e ��-����� <, ����� = ��� ��-������ �� 2-�� �����.

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter four digit integer between 1000 and 9999");
		short number = 0;
		number = CheckShort(number);
		
		sc.close();
		
		byte firstTwoNewNumbers = (byte) ((number / 1000) * 10 + (number % 10));
		byte secondTwoNewNumbers = (byte) (((number % 1000) - (number % 10))/10);
		if (firstTwoNewNumbers > secondTwoNewNumbers) {
			System.out.println(firstTwoNewNumbers + " is greater than " + secondTwoNewNumbers);
		} else if (firstTwoNewNumbers < secondTwoNewNumbers){
			System.out.println(firstTwoNewNumbers + " is less than " + secondTwoNewNumbers);
		} else {
			System.out.println(firstTwoNewNumbers + " is equal to " + secondTwoNewNumbers);
		}
	}
	private static short CheckShort (short number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextShort();
            	if (number / 1000 <= 9 && number /1000 > 0) {
            		inputOk = true;
				} else {
					System.err.println("Must be between 1000 and 9999");
				}
                
            } catch (Exception e) {
                System.err.println("That's not an integer! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return number;
	}
}
