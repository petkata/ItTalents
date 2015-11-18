
public class Task8Frame {

	public static void main(String[] args) {
		String[] strArr = {"Hello","World","in", "a", "frame"};
		
		int maxWordLength = findMaxWordLength(strArr);
		
		showTextInFrame(strArr,maxWordLength);
	}

	private static int findMaxWordLength(String[] arr) {
		int max = arr[0].length();
		
		for (int i = 0; i < arr.length; i++) {
			if (max<arr[i].length()) {
				max = arr[i].length();
			}
		}
		return max;
	}
	
	static void showTextInFrame(String[] str, int max){
		int constMax = max;
		
		printStarsInLine(max);
		
		System.out.println();
		
		for (int i = 0; i < str.length; i++) {
			max = constMax;
			System.out.print("*"+str[i]);
			if (str[i].length() < constMax) {
				while(max - str[i].length() >0){
					System.out.print(" ");
					max--;
				}
			}
			System.out.println("*");
		}
		printStarsInLine(max);
	}

	private static void printStarsInLine(int max) {
		while(max+2>0){
			System.out.print("*");
			max--;
		}
		
	}
}
