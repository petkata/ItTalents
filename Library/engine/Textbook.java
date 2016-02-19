package engine;


public class Textbook extends Item{

	
	private String author;
	private String publisher;
	private String topic;
	static final int TEXTBOOK_TAX = 3;
	
	
	public Textbook(String name, String author, String publisher, String topic) {
		super(name);
		this.author = author;
		this.publisher = publisher;
		this.topic = topic;
	}
	
	protected String getTopic() {
		return topic;
	}

	@Override
	protected double getTotalTax() {
		return super.getTotalTax() + TEXTBOOK_TAX;
	}

//	@Override
//	public String toString() {
//		return super.toString() +  super.getName();
//	}
	
}
