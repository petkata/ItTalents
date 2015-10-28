public class Task12 {

	public static void main(String[] args) {
//		Да се състави програма, която извежда всички
//		естествени трицифрени числа, които нямат еднакви цифри т.е.
//		100,101, 606 и т.н. не се извеждат. 
//		
//		Da se sastavi programa, koyato izvezhda vsichki
//		estestveni tritsifreni chisla, koito nyamat ednakvi tsifri t.e.
//		100,101, 606 i t.n. ne se izvezhdat. 
		

		for (int i = 100; i <= 999; i++) {
			int firstDigit = i / 100;
			int secondDigit = (i % 100 ) / 10;
			int thirdDigit = ((i % 100 ) % 10 );
			if (firstDigit == secondDigit || firstDigit == thirdDigit || secondDigit == thirdDigit) {
				continue;
			}
			System.out.print(i + " ");
		}
	}

}
