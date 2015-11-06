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
		
		// Just for tests
		//int[] arr = {0,1,1,1,1,4,2,5,5,5,33,33}; 
		
		int count = 1; 
		int secondCounter = 1; // used for comparing sequence lengths
		int index = 0; // position of the last member of the longest sequence in the array
		
		for (int i = 1; i < arr.length; i++) {
			
			if (arr[i] == arr[i-1]) {
				count++;
			}else if (arr[i] != arr[i-1] ) {
				if (secondCounter <= count) {
					secondCounter = count;
				}
				count = 1;
			}
			if (secondCounter <= count) {
				index = i;
			}
		}

		int maxSeq = (count > secondCounter)? count : secondCounter;
		
		System.out.print("The length of the longest sequence is " + maxSeq);
		System.out.println(" and starts at index " + (index - maxSeq + 1));
		for (int i = index - maxSeq + 1; i <= index; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
