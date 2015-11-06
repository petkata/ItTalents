
public class Task5 {

	public static void main(String[] args) {
//		Да се състави програма, при която предварително са въведени
//		естествени числа в двумерен масив 4*4 елемента.
//		Програмата да извежда резултат от проверката какво е съотношението
//		на най-голямата сума по редове спрямо най-голямата сума по колони.
//		
//		Da se sastavi programa, pri koyato predvaritelno sa vavedeni
//		estestveni chisla v dvumeren masiv 4*4 elementa.
//		Programata da izvezhda rezultat ot proverkata kakvo e saotnoshenieto
//		na nay-golyamata suma po redove spryamo nay-golyamata suma po koloni.
		
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
			   };
		int sumRow = 0;
		int sumCol = 0;
		int maxSumRow = 0;
		int maxSumCol = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sumRow += arr[i][j];
			}
			if (sumRow > maxSumRow) {
				maxSumRow = sumRow;
			}
			sumRow = 0;
		}
		
		for (int j = 0; j < arr[j].length; j++) {
			for (int i = 0; i < arr.length; i++) {
				sumCol += arr[i][j];
			}
			if (sumCol > maxSumCol) {
				maxSumCol = sumCol;
			}
			sumCol = 0;
			if (j == arr[j].length - 1) {
				break;
			}
		}
		System.out.println("Maximum row sum is " + maxSumRow);
		System.out.println("Maximum column sum is " +maxSumCol);
		System.out.println("Maximum row sum is " + 
							((maxSumRow > maxSumCol)? ">" : "<") + 
							" than maximum column sum.");
	}
}
