import java.util.Scanner;

public class Task18 {

	public static void main(String[] args) {
//		Дадени са два едномерни масива с естествени числа.
//		Да се състави програма, която сравнява всички числа с еднакви
//		индекси от двата масива и записва в трети масив, по-голямото от
//		двете числа.
//		Да се изведе съдържанието и на трите масива
//		
//		Dadeni sa dva ednomerni masiva s estestveni chisla.
//		Da se sastavi programa, koyato sravnyava vsichki chisla s ednakvi
//		indeksi ot dvata masiva i zapisva v treti masiv, po-golyamoto ot
//		dvete chisla.
//		Da se izvede sadarzhanieto i na trite masiva
		
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
		
		int[] firstArr = new int[lengthOFArray];
		
		for (int i = 0; i < firstArr.length; i++) {
			System.out.println("Please enter a number for position [" + i + "] in the array");
			firstArr[i] = sc.nextInt();
		}
		
		
		lengthOFArray = 0;
		
		//read and check if the length is a positive and same as the length of the first array
		while (lengthOFArray <= 0 || lengthOFArray != firstArr.length) {
				
			System.out.println("Please enter length of the array :");
			lengthOFArray = sc.nextInt();
			
			if (lengthOFArray <= 0 || lengthOFArray != firstArr.length) {
				System.out.print("Must be positive and the same length as the first array! ");
				continue;
			}
		}
		
		int[] secondArr = new int[lengthOFArray];
		
		for (int i = 0; i < secondArr.length; i++) {
			System.out.println("Please enter a number for position [" + i + "] in the array");
			secondArr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] thirdArr = new int[firstArr.length];
		for (int i = 0; i < thirdArr.length; i++) {
			thirdArr[i] = (firstArr[i] > secondArr[i])? firstArr[i] : secondArr[i];
		}
		
		// Printing the new array
		System.out.print("[");
		for (int i = 0; i < thirdArr.length; i++) {
			System.out.print(thirdArr[i]);
			if (i < thirdArr.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
