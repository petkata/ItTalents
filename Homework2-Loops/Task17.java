import java.util.Scanner;

public class Task17 {

	public static void main(String[] args) {
//		Да се състави програма, която извежда квадрат, чийто страни са
//		оформени със знака *, а вътрешността е запълнена със въведен
//		знак.
//		Входни данни b - дължина на страната число от интервала
//		[3..20], c - желан знак.
//		Програмата да използва цикъл for.
		
//		Da se sastavi programa, koyato izvezhda kvadrat, chiyto strani sa
//		oformeni sas znaka *, a vatreshnostta e zapalnena sas vaveden
//		znak.
//		Vhodni danni b - dalzhina na stranata chislo ot intervala
//		[3..20], c - zhelan znak.
//		Programata da izpolzva tsikal for.
		
//		Example: 4 +
//		Output:
//		****
//		*++*
//		*++*
//		****

		int sideLength;
		char symbol;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter length of side [3 - 20] and a char(ex. 4 +) :");
		sideLength = sc.nextInt();
		while(sideLength < 3 || sideLength > 20) {
			System.out.println("Enter a positive number between 3 and 20 and try again!");
			sideLength = sc.nextInt();
		}
		symbol = sc.next().charAt(0);
		sc.close();
		
		for (int i = 0; i < sideLength ; i++) {
			if (i == 0 || i == sideLength-1) {
				for (int j = 0; j < sideLength; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = 0; j < sideLength; j++) {
					if (j == 0 || j == sideLength - 1) {
						System.out.print("*");
					} else {
						System.out.print(symbol);
					}
				}
			}
			
			System.out.println();
		}
	}

}
