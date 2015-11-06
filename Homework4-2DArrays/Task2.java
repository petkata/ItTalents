import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
//		Имате квадратен двумерен масив от естествени числа, чийто стойности
//		се въвеждат от конзолата. Да се отпечатат диагоналите на масива.
//
//		Imate kvadraten dvumeren masiv ot estestveni chisla, chiyto stoynosti
//		se vavezhdat ot konzolata. Da se otpechatat diagonalite na masiva.

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter size of the matrix");
		int sizeOfMatrix = sc.nextInt();
		while (sizeOfMatrix <= 0) {
			System.err.println("Must be a positive number! Try again!");
			sizeOfMatrix = sc.nextInt();
		}
		
		int[][] arr = new int[sizeOfMatrix][sizeOfMatrix];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("Please enter a positive number for index [" + i + "][" + j + "]");
				arr[i][j] = sc.nextInt();
				while (arr[i][j] <= 0) {
					System.err.println("Must be a positive number! Try again!");
					arr[i][j] = sc.nextInt();
				}
			}
		}
		sc.close();
		
//		For testing
//		int[][] arr = {
//						{1,4,6,3},
//						{5,9,7,2},
//						{4,8,1,9},
//						{2,3,4,5}
//					};
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == j) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i + 1 == arr.length - j) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
	}
}
