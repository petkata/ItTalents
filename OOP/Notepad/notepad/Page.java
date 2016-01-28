package notepad;

public class Page {

	private String heading;
	private StringBuilder text;
		
	Page(String heading, String text) {
		this.heading = heading;
		this.text = new StringBuilder(text);
	}
	
	public StringBuilder getText(){
		return this.text;
	}
	
	public void addHeading(String newHeading) {
		this.heading = newHeading;
	}
	
	public void addText(String addedText){
		
		if (this.text == null) {
			this.text = new StringBuilder(addedText);
		}
		else {
			this.text.append( addedText);
		}
		
//		System.out.println("Text added!");
	}
	
	public void searchWord(String word){
		int countOccurances = 0;
		if (this.text.toString().contains(word)) {
			for (int i = 0; i < this.text.length(); i++) {
				if (this.text.subSequence(i, this.text.length()).toString().indexOf(word) >= 0){
					countOccurances++;
					i += this.text.substring(i).indexOf(word) + word.length();
					if (i > this.text.length() - word.length()) {
						break;
					}
				}
			}
			System.out.println("word \"" + word + "\" was found in the text " + countOccurances + " times");
		}
		else {
			System.out.println("word \"" + word + "\" was NOT found in the text");
		}
	}
	
	public boolean containsDigits(){
		if (this.text.toString().matches(".*[0-9]+.*")) {
			return true;
//			System.out.println("the text contains digits");
		}
		else {
			return false;
//			System.out.println("there are no digits in the text");
		}
	}
	
	public void clearPage() {
		this.text = null;
	}
	public void readPage() {
		System.out.println((this.heading == null || this.heading.matches("\\s*")? 
				"(no heading)" : this.heading.toUpperCase() ));
		System.out.println();
		System.out.println((this.text == null || this.text.toString().matches("\\s*")? 
				"(blank page)" : this.text ));
	}
}
