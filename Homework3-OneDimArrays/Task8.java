import java.util.Scanner;

public class Task8 {
	
	public static void main(String[] args) {
//		Напишете програма, която намира и извежда най-дългата редица от
//		еднакви поредни елементи в даден масив.
//		
//		Napishete programa, koyato namira i izvezhda nay-dalgata reditsa ot
//		ednakvi poredni elementi v daden masiv.
		
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
		
		
	}
}
