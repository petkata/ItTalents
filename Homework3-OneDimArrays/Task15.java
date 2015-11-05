import java.util.Scanner;

public class Task15 {

	public static void main(String[] args) {
//		Да се състави програма, която въвежда в едномерен масив реални
//		числа.
//		Като изход: програма извежда онези 3 различни числа, чиято
//		абсолютна стойност формира максималната обща сума.
//
//		Da se sastavi programa, koyato vavezhda v ednomeren masiv realni
//		chisla.
//		Kato izhod: programa izvezhda onezi 3 razlichni chisla, chiyato
//		absolyutna stoynost formira maksimalnata obshta suma.

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
		
		//initialize the three biggest numbers in the array
		double firstBiggest = 0;
		double secondBiggest = 0;
		double thirdBiggest = 0;
		//find and assign the three numbers with the biggest absolute value
		for (int i = 0; i < arr.length; i++) {
			//make the value of array element, first and second biggest number 
			//an absolute value for the comparison
			if (arr[i] * ((arr[i] > 0 )? 1: -1) > firstBiggest  * ((firstBiggest > 0)? 1 : -1)) {
				firstBiggest = arr[i] ;
			}
			if (firstBiggest * ((firstBiggest > 0)? 1 : -1) > arr[i] * ((arr[i] > 0 )? 1: -1)  && 
				arr[i] * ((arr[i] > 0 )? 1: -1) > secondBiggest * ((secondBiggest > 0)? 1 : -1)) {
				thirdBiggest = secondBiggest;
				secondBiggest = arr[i];
			}
		}
		
		System.out.println(thirdBiggest + "; " + secondBiggest + "; " + firstBiggest);
	}
}
