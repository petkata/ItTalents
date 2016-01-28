package notepad;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice{

	//TODO to correct scanner!
	private boolean isStarted;
	
	ElectronicSecuredNotepad(String password, int quantityOfPages) {
		super(password, quantityOfPages);
	}

	@Override
	public void addTextToPageNumber(String text, int pageNumber) {
		if (this.isStarted) {
			super.addTextToPageNumber(text, pageNumber);
		}
		else {
			this.isStarted();
		}
	}
	
	@Override
	public void replaceTextToPageNumber(String text, int pageNumber) {
		if (this.isStarted) {
			super.replaceTextToPageNumber(text, pageNumber);
		}
		else {
			this.isStarted();
		}
	}
	
	@Override
	public void deleteTextToPageNumber(int pageNumber) {
		if (this.isStarted) {
			super.deleteTextToPageNumber(pageNumber);
		}
		else {
			this.isStarted();
		}
	}
	
	@Override
	public void readAllPages() {
		if (isStarted) {
			super.readAllPages();
		}
		else {
			this.isStarted();
		}
	}
	
	@Override
	public void searchWord(String word) {
		if (this.isStarted) {
			super.searchWord(word);
		}
		else {
			this.isStarted();
		}
	}
	
	@Override
	public void printAllPagesWithDigits() {
		if (this.isStarted) {
			super.printAllPagesWithDigits();
		}
		else {
			this.isStarted();
		}
	}
	
	@Override
	public void start() {
		if (!this.isStarted) {
			this.isStarted = true;
			System.out.println("The device has started");
		}
	}

	@Override
	public void stop() {
		if (this.isStarted) {
			this.isStarted = false;
			System.out.println("The device has stopped");
		}
	}

	@Override
	public void isStarted() {
		if (this.isStarted) {
			System.out.println("The device is working");
		}
		System.out.println("The device is NOT working");
	}

}
