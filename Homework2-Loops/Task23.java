
public class Task23 {

	public static void main(String[] args) {
//		�� �� ������� ��������, ����� ���� ����� while �������
//		��������� �� ���������, �� ��� ����������.
//		�.�. ��� � �������� 4*5 �� �� ������� 5*4. 
//		
//		Da se sastavi programa, koyato chrez tsikal while izvezhda
//		tablitsata za umnozhenie, no bez povtorenie.
//		T.e. ako e izvedeno 4*5 ne se izvezhda 5*4. 

		int row = 1;
		int col = 1;
		int count = 1;
		while (row < 10) {
			col = count;
			while (col < 10) {
				System.out.print(row + "*" + col );
				if (col < 9) {
					System.out.print("; ");
				}
				col++;
			}
			count++;
			row++;
			System.out.println();
		}
	}

}
