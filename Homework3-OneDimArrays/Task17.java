import java.util.Scanner;

public class Task17 {

	public static void main(String[] args) {
//		Една редица от естествени числа ще наричаме зигзагообразна нагоре,
//		ако за елементите и са изпълняват условията:
//		N1 < N2 > N3 < N4 > N5 <..
//		Съставете програма, която проверява дали въведени в едномерен
//		масив редица от числа изпълняват горните изисквания.
//
//		Edna reditsa ot estestveni chisla shte narichame zigzagoobrazna nagore,
//		ako za elementite i sa izpalnyavat usloviyata:
//		N1 < N2 > N3 < N4 > N5 <..
//		Sastavete programa, koyato proveryava dali vavedeni v ednomeren
//		masiv reditsa ot chisla izpalnyavat gornite iziskvaniya.

		Scanner sc = new Scanner(System.in);
		int lengthOFArray = 0;
		
		//read and check if the length is a positive number
		while (lengthOFArray <= 0) {
				
			System.out.println("Please enter length of the array :");
			lengthOFArray = sc.nextInt();
			
			if (lengthOFArray <= 0 ) {
				System.out.print("Must be positive! ");
				continue;
			}
		}
		
		int[] arr = new int[lengthOFArray];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Please enter a number for position [" + i + "] in the array");
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		boolean isZigZagType = true;
		for (int i = 1; i < arr.length - 1; i++) {
			if (i % 2 != 0) {
				if (arr[i] < arr[i - 1] || 
					arr[i] < arr[i + 1] || 
					arr[arr.length -1] < arr[arr.length -2]) {
					isZigZagType = false;
				}
			}
			
		}
		if (isZigZagType) {
			System.out.println("The numbers fulfill the condition for ascending zigzag type sequence");
		} else {
			System.err.println("The numbers DO NOT fulfill the condition for ascending zigzag type sequence");
		}
	}
}
