import java.util.Scanner;

public class Task4 {
	
	public static void main(String[] args) {
//		Да се прочете масив и да се отпечата дали е огледален.
//		Следните масиви са огледални:
//		[3 7 7 3]
//		[4]
//				
//		Da se prochete masiv i da se otpechata dali e ogledalen.
//		Slednite masivi sa ogledalni:
//		[3 7 7 3]
//		[4]
		
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
		
		// read array elements
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Please enter a number for position arr[" + i + "]");
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		boolean isMirrorArray = true;
		
		// check if opposite array elements are equal
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr[arr.length -i -1]) {
				isMirrorArray = false;
			}
		}
		
		if (isMirrorArray) {
			System.out.println("It's a mirror array");
		} else {
			System.err.println("It's NOT a mirror array!");
		}
	}
}
