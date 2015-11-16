import java.util.Scanner;
public class TriangleOfDigits {

	public static void main(String[] args) {
//		Да се състави програма, чрез която по въведени начална и крайна
//		цифра се извеждат на всеки нов ред следната последователност
//		(триъгълник от знаци):

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter starting number: ");
		int startNumber = sc.nextInt();
		System.out.println("Please enter end number: ");
		int endNumber = validateNumber(sc, startNumber);
		
		showTriangle(startNumber, endNumber);
	}

	private static int validateNumber(Scanner sc, int first) {
		int second = sc.nextInt();
		if (first > second) {
			System.out.println("End number must be bigger than the starting " + first);
			return validateNumber(sc, first);
		}
		return second;
	}
	
	private static void showTriangle(int startNumber, int endNumber) {
		recurseCol(startNumber, endNumber, startNumber);
		
	}
	
	private static void recurseCol(int start, int end, int initialStartValue){
		if (start == end+1) {
			return;
		}
		recurseRow(initialStartValue, start);
		System.out.println();
		recurseCol(++start, end, initialStartValue);
	}
	
	private static void recurseRow(int initialStartValue, int startNumber) {
			
		if (initialStartValue <= startNumber ) {
			System.out.print(initialStartValue + " ");
			recurseRow(++initialStartValue, startNumber);
			
		} else {
			return;
		}
		
	}
}
