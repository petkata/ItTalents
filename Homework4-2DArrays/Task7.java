
public class Task7 {

	public static void main(String[] args) {
//		Имате предварително въведени стойности от естествени числа,
//		въведени в квадратна таблица с размери 6 реда и 6 колони.
//		Да се състави програма , чрез която се намира сумата на всички
//		елементи, чиято сума на индекси за ред и колона е четно число.
//		Програмата да извежда формираните суми за всеки отделен ред на
//		квадратната таблица, както и общата сума от тези елементи.
//		Да се използва само един цикъл.
//		
//		Imate predvaritelno vavedeni stoynosti ot estestveni chisla,
//		vavedeni v kvadratna tablitsa s razmeri 6 reda i 6 koloni.
//		Da se sastavi programa , chrez koyato se namira sumata na vsichki
//		elementi, chiyato suma na indeksi za red i kolona e chetno chislo.
//		Programata da izvezhda formiranite sumi za vseki otdelen red na
//		kvadratnata tablitsa, kakto i obshtata suma ot tezi elementi.
//		Da se izpolzva samo edin tsikal.
		
		int[][] arr = {
				{11,12,13,14,15,16},
				{21,22,23,24,25,26},
				{31,32,33,34,35,36},
				{41,42,43,44,45,46},
				{51,52,53,54,55,56},
				{61,62,63,64,65,66}
			   };
		
		int sumEvenRow = 0;
		int sumOddRow = 0;
		int sumAllRows = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if ( i % 2 == 0 && j % 2 == 0) {
					sumEvenRow += arr[i][j];
				} 
				if (i % 2 != 0 && j % 2 != 0) {
					sumOddRow += arr[i][j];
				}
			}
			for (int j = 0; j < arr[i].length; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					System.out.print(arr[i][j]);
					if (j < arr[i].length - 1) {
						System.out.print(", ,");
					}
				} 
				if (i % 2 != 0 && j % 2 != 0) {
					System.out.print(arr[i][j]);
					if (j < arr[i].length - 1) {
						System.out.print(", ,");
					}
				} 
			}
			sumAllRows += sumEvenRow + sumOddRow;
			
			System.out.println(" sum is " + ((i % 2 == 0)? sumEvenRow : sumOddRow));
			
			if (i % 2 == 0) {
				sumEvenRow = 0;
			} else {
				sumOddRow = 0;
			}
		}
		System.out.println("Total sum of even rows : " + sumAllRows);
	}
}
