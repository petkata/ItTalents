import java.util.Scanner;

public class Problem15 {

	public static void main(String[] args) {
		// �� �� ������� ��������, ����� ������� ���������� ����� �� ���������
		// [0..24].
		// ���������� �� ������ ������������� ��������� ��������� ���������
		// ���.
		// ��������� ��:
		//	[18..4] - ����� �����;
		//	[4..9] - ����� ����;
		//	[9..18] - ����� ���

		System.out.println("Please enter hour[0-24]");
		
		byte hour = 0;
		hour = CheckByte(hour);
		
		if (hour >= 18 || hour <= 4){
			System.out.println("����� �����!");
		} else if (hour > 4 && hour <= 9) {
			System.out.println("����� ����!");
		} else {
			System.out.println("����� ���!");
		}
	}
	private static byte CheckByte (byte number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextByte();
            	if (number < 0 || number > 24) {
            		System.err.println("Must be between 0 and 24! Try again!");
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
