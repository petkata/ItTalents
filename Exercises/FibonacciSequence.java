
public class FibonacciSequence {

	public static void main(String[] args) {
//		Print all Fibonacci numbers less than N (first and second Fibonacci
//		numbers are 0 and 1) 
		int num = 10;
		
		showFibSeq(num);
	}

	private static void showFibSeq(int num) {
		int fib = 0 ;
		int res = 0;
		while(calcFib(fib, num, res) < num){
			System.out.print(calcFib(fib, num, res) + " ");
			fib++;
		}
	}

	private static int calcFib(int fib, int num, int res) {
		if (fib == 0 ) {
			return 0;	
		}if (fib == 1) {
			return 1;
		} else{
			res = calcFib(fib - 1, num,res) + calcFib(fib - 2, num,res);
			if (res >= num) {
				return res;
			}
			return res;
		}
	}
}
