import java.util.Scanner;

public class Problem10 {

	public static void main(String[] args) {
		// Трябва да се напълни цистерна с вода. Имате 2 кофи с вместимост 2 и
		// 3 литра и ги ползвате едновременно.
		// Да се състави програма, която по даден обем извежда как ще прелеете
		// течността с тези кофи, т.е. по-колко пъти ще се пълни всяка от
		// кофите. Кофите не могат да се ползват с частично количество вода.
		// Входни данни: естествено число от интервала [10..9999].
		
		int volume = 0;
		int numberOfBuckets;
		int remainig;
		int numberOf2LiterBuckets = 0;
		int numberOf3LiterBuckets = 0;
		
		System.out.println("Please enter volume between 10 and 9999");
		volume = CheckInteger(volume);
		remainig = volume % 5;
		
		if (remainig == 4 || remainig == 9) {
			numberOf2LiterBuckets = 2;
		} else if (remainig == 3 || remainig == 8) {
			numberOf3LiterBuckets = 1;
		} else if (remainig == 2 || remainig == 7) {
			numberOf2LiterBuckets = 1;
		} else if (remainig == 1 || remainig == 6) {
			numberOf3LiterBuckets = 2;
			volume = volume - 6;
		}
		
		numberOfBuckets = volume / 5 ;
		
		System.out.println(numberOfBuckets + " times filling the 2 and 3 liter buckets");
		System.out.println(numberOf2LiterBuckets + " remaining 2 liter buckets");
		System.out.println(numberOf3LiterBuckets + " remaining 3 liter buckets");
	}
	private static int CheckInteger (int number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextInt();
            	if (number >= 10 && number <= 9999) {
            		inputOk = true;
				} else {
					System.err.println("Must be between 10 and 9999! Try again!");
				}
                
            } catch (Exception e) {
                System.err.println("That's not an integer! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return number;
	}

}
