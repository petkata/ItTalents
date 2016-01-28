package notepad;

public abstract class Notepad {

	protected Page[] pages;
	protected int quantityOfPages ;
	
	Notepad(int quantityOfPages) {
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
}
