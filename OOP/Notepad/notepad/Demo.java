package notepad;

public class Demo {

	public static void main(String[] args) {

		ElectronicSecuredNotepad notepadPlusPlus = new ElectronicSecuredNotepad("pass", 3);
		
		notepadPlusPlus.start();
		
		notepadPlusPlus.addTextToPageNumber("text1", 0);
		
		notepadPlusPlus.addTextToPageNumber("text1", 0);
		
//		notepadPlusPlus.stop();
		
//		notepadPlusPlus.readAllPages();
		
		
		notepadPlusPlus.searchWord("te");
		
	}

}
