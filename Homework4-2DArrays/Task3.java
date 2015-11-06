
public class Task3 {

	public static void main(String[] args) {
//		Имате двумерен масив от числа, чийто стойности са въведени
//		предварително. Да се отпечатат сумата на елементите на масива,
//		както и средноаритметичното на тези числа.
//
//		Imate dvumeren masiv ot chisla, chiyto stoynosti sa vavedeni
//		predvaritelno. Da se otpechatat sumata na elementite na masiva,
//		kakto i srednoaritmetichnoto na tezi chisla.

		int[][] arr = {
				{48,72,13,14,15},
				{21,22,53,24,75},
				{31,57,33,34,35},
				{41,95,43,44,45},
				{59,52,53,54,55},
				{61,69,63,64,65}
			  };
		
		double sum = 0;
		int countElements = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
				countElements++;
			}
		}
		
		double avg = sum / countElements;
		System.out.println("The sum of the elements is " + sum);
		System.out.println("The average value is " + avg);
	}
}
