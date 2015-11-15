public class WordRepetition {

	public static void main(String[] args) {
//		Напишете програма, която брои колко пъти се среща всяка
//		английска буква в даден символен низ. Запазете резултатите в
//		масив.
		
		String str = "lorem ipsum dolor sit amet consectetur adipiscing elit";
		
		StringBuilder diffLetters = new StringBuilder();
		int diffLettersCounter = 1;
		//check how many diff letters there are int the string
		for (int i = 0; i < str.length(); i++) {
			if (!diffLetters.toString().contains(str.substring(i, i+1)) && str.charAt(i) != ' ') {
				diffLetters.append(str.charAt(i));
				diffLettersCounter++;
			}
		}
				
		int[] occurrencesArray= new int[diffLettersCounter -1];
		int countIndexArray = 0;
		
		diffLetters.delete(0, diffLetters.length());
		
		for (int i = 0; i < str.length(); i++) {
			int countOccurrences = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					countOccurrences++;
				}
			}
			
			if (!diffLetters.toString().contains(str.substring(i, i+1)) && str.charAt(i) != ' ') {
				occurrencesArray[countIndexArray] = countOccurrences;
				countIndexArray++;
				diffLetters.append(str.charAt(i));
			}
		}
		String[] diffLettersArray = diffLetters.toString().split(""); 
		System.out.println("Number of different letters: " + diffLettersCounter);
		for (int i = 0; i < diffLettersArray.length; i++) {
			System.out.println(diffLettersArray[i] + " - " + occurrencesArray[i] + " times");
		}
	}
}
