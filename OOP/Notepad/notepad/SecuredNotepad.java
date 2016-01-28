package notepad;

import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad{
	//TODO to correct scanner!
	private final String password;
	
	SecuredNotepad(String password, int quantityOfPages) {
		super(quantityOfPages);
		this.password = password;
	}
	
	@Override
	public void addTextToPageNumber(String text, int pageNumber) {
		Scanner inputPassword = new Scanner(System.in);
		System.out.println("Please enter your password to add text");
		if (checkPassword(inputPassword)) {
			super.addTextToPageNumber(text, pageNumber);
//			inputPassword.close();
			return;
		}
		System.out.println("Wrong password");
//		inputPassword.close();
	}
	
	@Override
	public void replaceTextToPageNumber(String text, int pageNumber) {
		Scanner inputPassword = new Scanner(System.in);
		System.out.println("Please enter your password to replace text");
		if (checkPassword(inputPassword)) {
			super.replaceTextToPageNumber(text, pageNumber);
//			inputPassword.close();
			return;
		}
		System.out.println("Wrong password");
//		inputPassword.close();
	}
	
	@Override
	public void deleteTextToPageNumber(int pageNumber) {
		Scanner inputPassword = new Scanner(System.in);
		System.out.println("Please enter your password to delete text");
		if (checkPassword(inputPassword)) {
			super.deleteTextToPageNumber(pageNumber);
//			inputPassword.close();
			return;
		}
		System.out.println("Wrong password");
//		inputPassword.close();
	}
	
	@Override
	public void readAllPages() {
		System.out.println("Please enter your password to read all pages");
		Scanner inputPassword = new Scanner(System.in);
		if (checkPassword(inputPassword)) {
			super.readAllPages();
//			inputPassword.close();
			return;
		}
		System.out.println("Wrong password");
//		inputPassword.close();
	}
	
	@Override
	public void searchWord(String word) {
		System.out.println("Please enter your password to search for word");
		Scanner inputPassword = new Scanner(System.in);
		if (checkPassword(inputPassword)) {
			super.searchWord(word);
//			inputPassword.close();
			return;
		}
		System.out.println("Wrong password");
//		inputPassword.close();
	}
	
	@Override
	public void printAllPagesWithDigits() {
		 System.out.println("Please enter your password to read pages containing digits");
		Scanner inputPassword = new Scanner(System.in);
		if (checkPassword(inputPassword)) {
			super.printAllPagesWithDigits();
//			inputPassword.close();
			return;
		}
		System.out.println("Wrong password");
//		inputPassword.close();
	}
	
	@Override
	public boolean checkPassword(Scanner sc) {
		Scanner inputPassword = sc;
		if (this.password.equals(inputPassword.next())) {
			return true;
		}
		return false;
	}

}
