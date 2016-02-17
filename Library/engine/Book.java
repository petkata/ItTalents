package engine;


public class Book extends Item{

	
	private String author;
	private int dateOFPublish;
	private String genre;
	static final int BOOK_TAX = 2;
	
	public Book(String name, String author, int dateOFPublish, String genre) {
		super(name);
		this.author = author;
		this.dateOFPublish = dateOFPublish;
		this.genre = genre;
	}
	
	protected int getDateOFPublish() {
		return dateOFPublish;
	}



	protected String getGenre() {
		return genre;
	}



	@Override
	public String toString() {
		return super.toString() + this.author + " " + super.getName() + "(" + this.genre + ") Date of publish: " + this.dateOFPublish; 
	}
	
	
}
