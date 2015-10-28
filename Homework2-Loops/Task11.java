import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		/*
		 * Въведете число N чрез конзолата и изкарайте като
			резултат следния триъгълник с височина N:
			Vavedete chislo N chrez konzolata i izkarayte kato
			rezultat sledniya triagalnik s visochina N:
				*
			   ***
			  *****
		 */

		int height = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter triangle height:");
		height = sc.nextInt();
		if (height <= 0) {
			System.out.println("Height must be a positive number! Try Again!");
			height = sc.nextInt();
		}
		sc.close();
		
		for (int i = 1; i <= height; i++) {
			
			for (int k = height - i; k > 0 ; k--) {
				System.out.print(" ");
			}
			
			for (int j = 1; j <= (2 * i - 1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
