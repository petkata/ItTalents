import java.util.Scanner;

public class Task13 {

	public static void main(String[] args) {
//		Да се създаде метод, който приема два масива от числа и връща
//		масив, съдържащ всички елементи на подадените масиви, като в
//		първата част на масива са елементите на първия подаден масив,
//		а във втората част – тези на втория подаден масив.

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter length of first array");
		int[] firstArr = fillArray(sc);
		System.out.println("Enter length of second array");
		int[] secondArr = fillArray(sc);
		sc.close();
		
		int[] concantinatedArr = concantinateArrays(firstArr,secondArr);
		printArray(concantinatedArr);
	}
	
	private static int[] fillArray(Scanner sc) {
		int[] arr = new int[validateLength(sc,sc.nextInt())];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter element at position " + i);
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	private static int validateLength(Scanner sc, int length) {
		if (length <= 0) {
			System.out.println("Length must be positive number!");
			length = sc.nextInt();
			validateLength(sc, length);
		}
		return length;
	}

	static int[] concantinateArrays(int[] arrOne, int[] arrTwo){
		int[] arrThree = new int[arrOne.length + arrTwo.length];
		for (int i = 0; i < arrThree.length; i++) {
			if (i < arrOne.length) {
				arrThree[i] = arrOne[i];
			} else {
				arrThree[i] = arrTwo[i - arrOne.length];
			}
		}
		return arrThree;
	}
	private static void printArray(int[] array) {
			
			System.out.print("[");
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i]);
				if (i < array.length -1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
	}
}
