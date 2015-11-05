import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
//		Напишете програма, която първо чете 2 масива и после извежда
//		съобщение дали са еднакви, и дали са с еднакъв размер.
//
//		Napishete programa, koyato parvo chete 2 masiva i posle izvezhda
//		saobshtenie dali sa ednakvi, i dali sa s ednakav razmer.

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
			System.out.println("Please enter a number for position [" + i + "] of first array");
			firstArr[i] = sc.nextInt();
		}
		
		// The Second array
		lengthOFArray = 0;
		while (lengthOFArray <= 0) {
			
			System.out.println("Please enter length of the array :");
			lengthOFArray = sc.nextInt();
			
			if (lengthOFArray <= 0 ) {
				System.out.print("Must be positive! ");
				continue;
			}
		}
		
		int[] secondArr = new int[lengthOFArray];
		
		for (int i = 0; i < secondArr.length; i++) {
			System.out.println("Please enter a number for position [" + i + "] of second array");
			secondArr[i] = sc.nextInt();
		}
		sc.close();
		
		// comparing the arrays
		boolean areEqual = false;
		if (firstArr.length == secondArr.length) {
			for (int i = 0; i < secondArr.length; i++) {
				if (firstArr[i] == secondArr[i]) {
					areEqual = true;
				}
				else{
					areEqual = false;
					break;
				}
			}
			if (areEqual) {
				System.out.println("The arrays are with equal length and their elements are "
						+ "equal in the same order");
			} else {
				System.err.println("The elements of the arrays are not equal!");
			}
		} else {
			System.err.println("The arrays have different length!");
		}		
	}
}
