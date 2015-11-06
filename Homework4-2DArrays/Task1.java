
public class Task1 {

	public static void main(String[] args) {
//		Имате двумерен масив 6х5 от естествени числа, чийто стойности са
//		въведени предварително.
//		Да се състави програма, чрез която се извеждат елементите от масива
//		с най-малката и най-голямата стойност.
//
//		Imate dvumeren masiv 6h5 ot estestveni chisla, chiyto stoynosti sa
//		vavedeni predvaritelno.
//		Da se sastavi programa, chrez koyato se izvezhdat elementite ot masiva
//		s nay-malkata i nay-golyamata stoynost.

		int[][] arr = {
						{48,72,13,14,15},
						{21,22,53,24,75},
						{31,57,33,34,35},
						{41,95,43,44,45},
						{59,52,53,54,55},
						{61,69,63,64,65}
					  };
		
		int max = 0;
		int min = arr[0][0];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
				}
				if (arr[i][j] < min) {
					min = arr[i][j];
				}
			}
		}
		
		System.out.println("Max number is : " + max);
		System.out.println("Min number is : " + min);
	}
}
