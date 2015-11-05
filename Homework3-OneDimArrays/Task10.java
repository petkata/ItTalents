import java.util.Scanner;

public class Task10 {
	
	public static void main(String[] args) {
//		Да се състави програма, чрез която се въвеждат 7 цели числа в
//		едномерен масив.
//		Програмата да изведе числото, което е най-близко до средната
//		стойност на въведените числа.
//
//		Da se sastavi programa, chrez koyato se vavezhdat 7 tseli chisla v
//		ednomeren masiv.
//		Programata da izvede chisloto, koeto e nay-blizko do srednata
//		stoynost na vavedenite chisla.

		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[7];
		double sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Please enter value for position [" + i + "]");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		sc.close();
		
		double avg = sum / arr.length;
		// * ((avg > arr[i])? 1 : -1 is to correct the difference to a positive number
		double subst = (avg - arr[0]) * ((avg > arr[0])? 1 : -1);
		int minNum = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			  
			if ((avg - arr[i]) * ((avg > arr[i])? 1 : -1) <= subst) {
				subst = (avg - arr[i]) * ((avg > arr[i])? 1 : -1);
				minNum = arr[i];
			}
		}
		
		System.out.println("The average is " + avg);
		System.out.println("Closest is " + minNum);
				
	}
}
