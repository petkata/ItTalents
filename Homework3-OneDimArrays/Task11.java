import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		
//		Да се състави програма, която въвежда от клавиатурата 7 цели числа
//		в едномерен масив
//		Програмата да изведе всички числа кратни на 5, но по големи от 5.
//
//		Da se sastavi programa, koyato vavezhda ot klaviaturata 7 tseli chisla
//		v ednomeren masiv
//		Programata da izvede vsichki chisla kratni na 5, no po golemi ot 5.

		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[7];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Please enter value for position [" + i + "]");
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		int countNumbers = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 5 == 0 && arr[i] > 5 ) {
				System.out.print(arr[i] + " ");
				countNumbers++;
			}
		}
		System.out.println("- " + countNumbers + " numbers");
	}
}
