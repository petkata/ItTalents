import java.util.Scanner;

public class Task19 {

	public static void main(String[] args) {
//		 Да се състави програма, чрез която по въведено
//		 естествено число от интервала [10..99] се извежда поредица
//		 числа, при спазване на следните изисквания:
//		 1) ако предходното число е четно се извежда 0.5*числото;
//		 2) ако предходното число е нечетно се извежда 3*числото +1.
//		 Извеждането продължава докато не се получи стойност 1.
//
//		 Da se sastavi programa, chrez koyato po vavedeno
//		 estestveno chislo ot intervala [10..99] se izvezhda poreditsa
//		 chisla, pri spazvane na slednite iziskvaniya:
//		 1) ako predhodnoto chislo e chetno se izvezhda 0.5*chisloto;
//		 2) ako predhodnoto chislo e nechetno se izvezhda 3*chisloto +1.
//		 Izvezhdaneto prodalzhava dokato ne se poluchi stoynost 1.

		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter number:");
		num = sc.nextInt();
		
		while(num < 10 || num > 99) {
			System.out.println("Enter a positive number between 10 and 99 including and try again!");
			num = sc.nextInt();
		}
		sc.close();
		
		while (num > 1) {
			if (num % 2 == 0) {
				num /= 2;
			} else {
				num = num *3 +1;
			}
			System.out.print(num + " ");
		}
	}

}
