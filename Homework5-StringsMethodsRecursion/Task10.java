
public class Task10 {

	public static void main(String[] args) {
//		Да се състави програма, която по даден низ връща друг,
//		символите, на който са получени като към всеки код на символ
//		от ASCII таблицата е добавеното числото 5 и е записан
//		новополучения символ.

		String originalStr = "Hello";
		
		String modifiedStr = new String(originalStr);
		
		for (int i = 0; i < originalStr.length(); i++) {
			char modifiedChar = originalStr.charAt(i);
			modifiedChar +=5;
			modifiedStr = modifiedStr.replace(modifiedStr.charAt(i), modifiedChar);
		}
		
		System.out.println(modifiedStr);
	}
}
