package notepad;

public class NotepadDemo {

	public static void main(String[] args) {
		
		
//		Page page1 = new Page("глава първа", "много текст трябватекст да има тук текст и после ще го форматирам");
//		page1.addText("SOme text in engl");
//		page1.readPage();
//		page1.searchWord("текст");
//		page1.containsDigits();
		
//		Page[] notes = new Page[2];
//		notes[0] = new Page("Notepad Heading", "text on the first page");
//		notes[1] = new Page("Heading 2","second page");
//		for (int i = 0; i < notes.length; i++) {
//			
//			pageSeparator();
//			notes[i].readPage();
//		}
//		pageSeparator();
		
			// SIMPLE NOTEPAD
		
//		SimpleNotepad notepad = new SimpleNotepad(4);
//		
//		notepad.addTextToPageNumber("text on the first page", 0);
//		
//		notepad.addTextToPageNumber(" some ad2ded text", 0);
//		
//		notepad.addTextToPageNumber("second page", 1);
//		
//		notepad.addTextToPageNumber("third page", 2);
//		
//		notepad.deleteTextToPageNumber(2);
//
//		notepad.addTextToPageNumber("thirdfourth", 2);
//		
//		notepad.replaceTextToPageNumber("text repltextac3ed text", 2);
//		
//		notepad.printAllPagesWithDigits();
//		
//		notepad.searchWord("text");
//		
//		notepad.readAllPages();
//		
//		pageSeparator();
//		
//		SecuredNotepad secNotepad = new SecuredNotepad("pass", 3);
		
		
		// SECURED NOTEPAD
		SecuredNotepad secNotepad = new SecuredNotepad("pass", 4);
		
		secNotepad.addTextToPageNumber("text on the first page", 0);
		
		secNotepad.readAllPages();
		
		
		
		
		
		
	}
	
	static void pageSeparator(){
		System.out.println("----------------------");
	}
	
}
