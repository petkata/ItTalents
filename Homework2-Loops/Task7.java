import java.util.Scanner;

public class Task7 {

	public static void main(String[] args) {
		/*
		 * ���������� �� 3, �� �� ������� �� ������ ������� n
		 * ����� ����� �� ����� �� 3. ������� �� �� ��������� ��� �������.
		 * Zapochvayki ot 3, da se izvedat na ekrana parvite n
		 * chisla koito se delyat na 3. Chislata da sa razdeleni sas zapetaya.
		 */
		
		int numSeries = 3 ;
		int count;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter number");
		count = sc.nextInt();
		sc.close();
		
		for (int i = 0; i < count ; i++ , numSeries +=3) {
			System.out.print(numSeries);
			if (i < count - 1) {
				System.out.print(",");
			}
			
		}
	}

}
