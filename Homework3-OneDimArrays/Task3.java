import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
//		Да се въведе число, след което да се създаде масив с 10 елемента по следния начин:
//		Първите 2 елемента на масива са въведеното число.
//		Всеки следващ елемент на масива е равен на сбора от
//		предишните 2 елемента в масива. След това изведете масива .
//		
//		Da se vavede chislo, sled koeto da se sazdade masiv s 10 elementa po sledniya nachin:
//		Parvite 2 elementa na masiva sa vavedenoto chislo.
//		Vseki sledvasht element na masiva e raven na sbora ot
//		predishnite 2 elementa v masiva. Sled tova izvedete masiva .
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter a number");
		int num = sc.nextInt();
		sc.close();
		
		int[] arr = new int[10];
		
//		// one possible solution
//		arr[0] = num;
//		arr[1] = num;
//		
//		for (int i = 2; i < arr.length; i++) {
//			arr[i] = arr[i-1] + arr[i-2];
//		}
		
		// second possible solution 
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || i == 1) {
				arr[i] = num;
				continue;
			}
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		// Printing the new array
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
