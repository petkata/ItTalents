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
	protected double getTotalTax() {
		// TODO Auto-generated method stub
		return super.getTotalTax() + BOOK_TAX;
	}



	@Override
	public String toString() {
		return super.toString() + " Date of publish: " + this.dateOFPublish; 
	}
	
	
}
