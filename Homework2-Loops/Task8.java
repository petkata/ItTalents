import java.util.Scanner;

public class Task8 {
	
	public static void main(String[] args) {
		/*
		 * По зададено число n, да се изведе на екрана таблица по следния начин:
		 * Enter n:
			1
			0
		 	Enter n:
			2
			11
			33
			Enter n:
			3
			222
			444
			666
		 */
		
		int rows = -1;
		int startingNum;
		Scanner sc = new Scanner(System.in);
		
		while (rows <= 0) {
			System.out.println("Please enter a positive number");
			rows = sc.nextInt();
		}
		sc.close();
		
		startingNum = rows -1;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				System.out.print(startingNum);
			}
			startingNum += 2;
			System.out.println();
		}
	}
}
