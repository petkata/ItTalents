import java.util.Scanner;

public class Task9 {

	public static void main(String[] args) {
//		Напишете програма, в която потребителя въвежда масив, след което
//		елементите на масива се обръщат в обратен ред (Целта не е масива да
//		се отпечата в обратен ред, ами първо да се обърне, след което да се
//		отпечата в нормален ред). Пробвайте да решите задачата първо с един
//		допълнителен масив и после без да използвате друг масив.
//		
//		Napishete programa, v koyato potrebitelya vavezhda masiv, sled koeto
//		elementite na masiva se obrashtat v obraten red (Tselta ne e masiva da
//		se otpechata v obraten red, ami parvo da se obarne, sled koeto da se
//		otpechata v normalen red). Probvayte da reshite zadachata parvo s edin
//		dopalnitelen masiv i posle bez da izpolzvate drug masiv.
		
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
		
//		solution without additional array
//		
//		// check if the array length is even or odd
//		int rem = arr.length % 2;
//		for (int i = 0; i < arr.length / 2 + rem; i++) {
//			int mid = arr[i];
//			arr[i] = arr[arr.length -i -1];
//			arr[arr.length -i -1] = mid;
//		}
//		// Printing the new array
//		System.out.print("[");
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]);
//			if (i < arr.length -1) {
//				System.out.print(", ");
//			}
//		}
//		System.out.println("]");
		
//		solution with an additional array
		int[] mirroredArray = new int[arr.length];
		for (int i = 0; i < mirroredArray.length; i++) {
			mirroredArray[i] = arr[arr.length -i -1];
		}
		// Printing the new array
		System.out.print("[");
		for (int i = 0; i < mirroredArray.length; i++) {
			System.out.print(mirroredArray[i]);
			if (i < mirroredArray.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
