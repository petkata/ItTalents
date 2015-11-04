import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
	
	public static void main(String[] args) {
		
//		Да се прочете масив и да се намери най-малкото число кратно на
//		3 от масива.
//		
//		Da se prochete masiv i da se nameri nay-malkoto chislo kratno na
//		3 ot masiva.
		
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
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Please enter a number for position arr[" + i + "]");
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		System.out.println(Arrays.toString(arr));
		
		int minNum = arr[0];
		boolean isAliquot = false;
		
		for (int i = 0; i < arr.length; i++) {
			// exclude 0 because 0 divided by any number is 0
			if (arr[i] % 3 == 0 && arr[i] != 0) {
				
				if (minNum % 3 != 0 || minNum == 0 || minNum > arr[i]) {
					minNum = arr[i];
				}	
				isAliquot = true;
			}
		}
		if (isAliquot) {
			System.out.println("The minimal number aliquot to 3 is : " + minNum);
		} else {
			System.out.println("There is no aliguot to 3 number");
		}
		
	}
}
