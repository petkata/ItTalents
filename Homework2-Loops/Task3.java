
public class Task3 {

	public static void main(String[] args) {
		/*
		 *  �� �� ������� �� ������ ������ ������� ����� �� -10 �� 10
		 *  Da se izvedat na ekrana vsichki nechetni chisla ot -10 do 10
		 * 
		 */

		int num = -10;
		while (num <= 10) {
			if (num % 2 != 0) {
				System.out.println(num);
			}
			
			num++;
		}
	}

}
