import java.util.Scanner;

public class Task14 {

	public static void main(String[] args) {
//		Имате предварително въведен едномерен масив, съдържащ реални
//		числа.
//		Да се състави програма, чрез която се избират само елементи от
//		масива със стойности от интервала [-2.99..2.99] и се отпечатват в нов
//		масив. Новият масив да се извежда на екрана.
//
//		Imate predvaritelno vaveden ednomeren masiv, sadarzhasht realni
//		chisla.
//		Da se sastavi programa, chrez koyato se izbirat samo elementi ot
//		masiva sas stoynosti ot intervala [-2.99..2.99] i se otpechatvat v nov
//		masiv. Noviyat masiv da se izvezhda na ekrana.

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
		
		//create and read the array
		double[] arr = new double[lengthOFArray];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Please enter a number for position [" + i + "] in the array");
			arr[i] = sc.nextDouble();
		}
		sc.close();
		
		//count how many elements are in the range -2.99/2.99
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > -2.99 && arr[i] < 2.99) {
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("there are no elements between -2.99 and 2.99");
		}
		//create and fill the second array 
		int countIndex = 0; // count the index for the second array
		double[] secondArr = new double[count];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > -2.99 && arr[i] < 2.99) {
				secondArr[countIndex] = arr[i];
				countIndex++;
			}
		}
		
		// Printing the new array
		System.out.print("[");
		for (int i = 0; i < secondArr.length; i++) {
			System.out.print(secondArr[i]);
			if (i < secondArr.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
