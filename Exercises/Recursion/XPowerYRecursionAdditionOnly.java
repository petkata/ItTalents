
public class XPowerYRecursionAdditionOnly {

	public static void main(String[] args) {
		int num = 2;
		int pow = 10;
		int result= 1;
		System.out.println(power(num, pow, result));
	}
	
	private static int power(int num, int pow, int res) {
		int result = 0;
		if (pow > 0) { 
			res = multy( res, num,  result);
			return power(num, --pow,res);
		}else{
			return res;
		}
	}


	private static int multy(int num, int num2, int result) {
		if (num2 > 0) {
			result += num;
			return multy( num,  --num2,  result);
		}else{
			return result;
		}
	}
}
