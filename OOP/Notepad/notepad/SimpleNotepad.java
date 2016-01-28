package notepad;

public class SimpleNotepad implements INotepad {

	private Page[] pages;
	private int quantityOfPages ;
	
	SimpleNotepad(int quantityOfPages) {
		this.setQuantityOfPages(quantityOfPages);
		this.pages = new Page[this.quantityOfPages];
		for (int i = 0; i < pages.length; i++) {
			this.pages[i] = new Page("Page " + (i+1), "");
		}
	}

	protected void setQuantityOfPages(int quantityOfPages) {
		if (quantityOfPages <= 0) {
			System.out.println("Cannot be negative or zero");
			return;
		}
		this.quantityOfPages = quantityOfPages;
	}

	@Override
	public void addTextToPageNumber(String text, int pageNumber) {
		this.pages[pageNumber].addText(text);

	}

	@Override
	public void replaceTextToPageNumber(String text, int pageNumber) {
		this.deleteTextToPageNumber(pageNumber);
		this.pages[pageNumber].addText(text);
	}

	@Override
	public void deleteTextToPageNumber(int pageNumber) {
		this.pages[pageNumber].clearPage();

	}
	
	@Override
	public void searchWord(String word) {
		for (int i = 0; i < this.pages.length; i++) {
			if (this.pages[i].getText().length() == 0 || this.pages[i].getText() == null) {
				continue;
			}
			System.out.print(" on page " + (i+1) + " ");
			this.pages[i].searchWord(word);
			
		}
	}

	@Override
	public void readAllPages() {
		for (int i = 0; i < this.pages.length; i++) {
			pageSeparator();
			this.pages[i].readPage();
		}
	}
	
	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < pages.length; i++) {
			if (this.pages[i].containsDigits()) {
				this.pages[i].readPage();
				pageSeparator();
			}
		}
	}
}
