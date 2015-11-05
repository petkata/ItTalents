import java.util.Scanner;

public class Task7 {
	
	public static void main(String[] args) {
//		Напишете програма, която първо чете масив и после създава нов
//		масив със същия размер по следния начин: стойността на всеки
//		елемент от втория масив да е равна на сбора от предходния и
//		следващият елемент на съответния елемент от първия масив. Първият
//		и последният елемент на втория масив трябва да си останат равни на
//		първият и последният от елемент от първия масив.
//		Да се изведе получения масив.
//		
//		Napishete programa, koyato parvo chete masiv i posle sazdava nov
//		masiv sas sashtiya razmer po sledniya nachin: stoynostta na vseki
//		element ot vtoriya masiv da e ravna na sbora ot predhodniya i
//		sledvashtiyat element na saotvetniya element ot parviya masiv. Parviyat
//		i posledniyat element na vtoriya masiv tryabva da si ostanat ravni na
//		parviyat i posledniyat ot element ot parviya masiv.
//		Da se izvede polucheniya masiv.
		
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
		
		int[] secondArr = new int[arr.length];
		
		secondArr[0] = arr[0];
		secondArr[secondArr.length - 1] = arr[arr.length - 1];
		
		for (int i = 1; i < secondArr.length -1; i++) {
			secondArr[i] = arr[i-1] + arr[i+1];
		}
		
		// Printing the new array
		System.out.print("[");
		for (int i = 0; i < secondArr.length; i++) {
			System.out.print(secondArr[i]);
			if (i < secondArr.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
