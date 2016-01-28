package notepad;

import java.util.Scanner;

public interface ISecuredNotepad {
	
//	public void addTextToPageNumber(String password, String text, int pageNumber);
//	
//	public void replaceTextToPageNumber(String password, String text, int pageNumber);
//	
//	public void deleteTextToPageNumber(String password, int pageNumber);
//	
//	public void searchWord(String password, String word);
//	
//	public void readAllPages(String password);
//	
//	public void printAllPagesWithDigits(String password);
	
	public boolean checkPassword(Scanner password);
	
}
