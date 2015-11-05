
import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
//		Нека по въведен масив да се конструира нов, като половината му
//		елементи са точно като на оригиналния, а другите да са тези
//		елементи, но в обратен ред. Последно, да се изведе новия масив
//		на екрана.
//
//		Neka po vaveden masiv da se konstruira nov, kato polovinata mu
//		elementi sa tochno kato na originalniya, a drugite da sa tezi
//		elementi, no v obraten red. Posledno, da se izvede noviya masiv
//		na ekrana.

		Scanner sc = new Scanner(System.in);
		int lengthOFArray = 0;
		
		//read and check if the length is a positive number
		while (lengthOFArray <= 0) {
				
			System.out.println("Please enter positive length of the array :");
			lengthOFArray = sc.nextInt();
			
			if (lengthOFArray <= 0 ) {
				System.out.print("Must be positive! ");
				continue;
			}
		}
		
		int[] arr = new int[lengthOFArray];
		
		// read array elements
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Please enter a number for position arr[" + i + "]");
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] mirroredArr = new int[arr.length];
		
		// assigning 1 or 0 depending on array length. 1 if odd, 0 if even 
		int remaining = arr.length % 2;		
		
		for (int i = 0; i < arr.length / 2 + remaining; i++) {
			mirroredArr[i] = arr[i];
			mirroredArr[mirroredArr.length - i - 1] = arr[i];
		}
		
		// Printing the new array
		System.out.print("[");
		for (int i = 0; i < mirroredArr.length; i++) {
			System.out.print(mirroredArr[i]);
			if (i < mirroredArr.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
