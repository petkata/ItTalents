import java.util.Scanner;

public class PowerUnion {

	public static void main(String[] args) {
//		Да се състави програма, която изчислява произведение на две
//		естествени числа =>2, като се използва само събиране.
		
		Scanner sc = new Scanner(System.in);
		int firstNum = enterNumbers(sc);
		int secondNum = enterNumbers(sc);
		int result= 0;
		sc.close();
		
		printMultupliedNums(firstNum, secondNum, result);

	}

	private static int enterNumbers(Scanner sc) {
		System.out.println("Please enter first number,greater than or equal to 2, to be overwhelmed with power");
		return validateNumber(sc); 
	}

	private static int validateNumber(Scanner sc) {
		int num = sc.nextInt();
		if (num < 2 ) {
			System.out.println("must be bigger");
			return validateNumber(sc);
		} else {
			return num;
		}
	}
	
	private static void printMultupliedNums(int first, int second, int result) {
		System.out.println(calcPowerNumber(first, second, result));
	}

	private static int calcPowerNumber(int first, int second, int result) {
		if (first > 0) {
			 result += second;;
		} else {
			return result;
		}
		return calcPowerNumber(--first, second, result);
	}
}
