package notepad;

public interface INotepad {

	public void addTextToPageNumber( String text, int pageNumber);
	
	public void replaceTextToPageNumber(String text, int pageNumber);
	
	public void deleteTextToPageNumber(int pageNumber);
	
	public void searchWord(String word);
	
	public void readAllPages();
	
	public void printAllPagesWithDigits();
	
	default void pageSeparator(){
		System.out.println("----------------------");
	}
}
