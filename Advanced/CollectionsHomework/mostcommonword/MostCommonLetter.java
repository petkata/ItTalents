package mostcommonword;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MostCommonLetter {

	public static void main(String[] args) {
		
		String str = " His name is Slim Shady!";
		str = str.toUpperCase().replaceAll("\\W", "");
		char[] charArr = str.toCharArray();
		
		List<Character> charList = new LinkedList<>();
		for (int i = 0; i < charArr.length; i++) {
			charList.add(charArr[i]);
		}
		
		Collections.sort(charList);
		
		int count=1;
		List<Integer> letterCount = new LinkedList<>();
		for (int i = 0; i < charList.size(); i++) {
			while(charList.lastIndexOf(charList.get(i)) > charList.indexOf(charList.get(i))){
				count ++;
				charList.remove(charList.lastIndexOf(charList.get(i)));
			}
			letterCount.add(count);
			count =1;
		}
		
		sortLists(letterCount, charList);
		printGraphic(letterCount, charList, str);
	}
	
	static void sortLists(List<Integer> counts, List<Character> charList){
	
		for (int j = 0; j < counts.size(); j++) {
			boolean hasASwap = false;
			for (int i = 1; i < counts.size()-j; i++) {
				if (counts.get(i) > counts.get(i-1)) {
					int temp = counts.get(i);
					char tempChar = charList.get(i);
					counts.set(i, counts.get(i-1));
					counts.set(i-1, temp);
					charList.set(i, charList.get(i-1));
					charList.set(i-1, tempChar);
					hasASwap = true;
				}
			}
			if (!hasASwap) {
				break;
			}
		}
	}

	static void printGraphic(List<Integer> counts, List<Character> charList, String str){
		for (int j = 0; j < counts.size(); j++) {
			System.out.print(charList.get(j) + ": " + counts.get(j) + " ");
			makeGraphic(str, counts.get(j));
			System.out.println();
		}
	}
	
	static void makeGraphic(String word, double counter){
		double ratio = (counter/ word.length())*100;
		while (ratio > 1) {
			System.out.print("#");
			ratio--;
		}
		
	}
}
