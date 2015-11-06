
public class Task6 {

	public static void main(String[] args) {
//		Имате предварително въведени стойности от естествени числа.
//		Числата са въведени в квадратна таблица с размери 6 реда и 6
//		колони.
//		Да се състави програма, чрез която се намира сумата на всички
//		елементи от редовете с четни номера: 2,4 и 6.
//		Програмата да извежда и сумата на всеки отделен ред.
//	
//		Imate predvaritelno vavedeni stoynosti ot estestveni chisla.
//		Chislata sa vavedeni v kvadratna tablitsa s razmeri 6 reda i 6
//		koloni.
//		Da se sastavi programa, chrez koyato se namira sumata na vsichki
//		elementi ot redovete s chetni nomera: 2,4 i 6.
//		Programata da izvezhda i sumata na vseki otdelen red.
		
		int[][] arr = {
				{11,12,13,14,15,16},
				{21,22,23,24,25,26},
				{31,32,33,34,35,36},
				{41,42,43,44,45,46},
				{51,52,53,54,55,56},
				{61,62,63,64,65,66}
			   };
		
		int sumEvenRow = 0;
		int sumAllEvenRows = 0;
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if ( i % 2 != 0) {
					sumEvenRow += arr[i][j];
				}
			}
			for (int j = 0; j < arr[i].length; j++) {
				if ( i % 2 != 0) {
					System.out.print(arr[i][j]);
					if (j < arr[i].length - 1) {
						System.out.print(",");
					}
				}
			}
			if (i % 2 != 0) {
				System.out.println(" sum is " + sumEvenRow);
				sumAllEvenRows += sumEvenRow;
				sumEvenRow = 0;
			}
		}
		System.out.println("Total sum of even rows : " + sumAllEvenRows);
	}
}
