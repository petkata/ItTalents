public class Task9 {

	public static void main(String[] args) {
//		Да се състави програма, чрез която по въведен низ съдържащ букви,
//		цифри, знак минус '-' се извежда сборът на въведените числа като се
//		отчита знакът '-' пред съответното число.

		String str = "asd-12sdf45-56asdf100";
			
		StringBuilder filteredStr = new StringBuilder();
		
		filteredStr = filter(str,filteredStr);
		
		String[] strArr = filteredStr.toString().trim().split("\\s+");
		
		calculateSumOFNumbersInString(strArr);
		
	}

	private static void calculateSumOFNumbersInString(String[] strArr) {
		int sumStr = 0;
		for (int i = 0; i < strArr.length; i++) {
			sumStr += Integer.parseInt(strArr[i]);
		}
		System.out.println("The sum is: " + sumStr);
	}

	private static StringBuilder filter(String str , StringBuilder filteredStr) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-') {
				filteredStr.append(" ");
			}
			if (!str.substring(i,i+1).matches("[a-z]") ) {
				filteredStr.append(str.charAt(i));
			} else {
				filteredStr.append(" ");
			}
			
		}
		return filteredStr;
	}
}
