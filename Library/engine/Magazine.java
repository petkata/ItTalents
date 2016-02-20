package engine;

public class Magazine extends Item{

	private int number;
	private int dateOfPublish;
	
	public Magazine(String title, String publisher, String type, int number, int dateOfPublish) {
		super(title, publisher, type);
		this.number = number;
		this.dateOfPublish = dateOfPublish;
	}

	@Override
	public int compareTo(Item o) {
		if (super.getTitle().equals(o.getTitle())) {
			if (this.number > ((Magazine)o).number ) {
				return 1;
			}
			if (this.number < ((Magazine)o).number ) {
				return -1;
			}
			return 0;
		}
		return super.getTitle().compareTo(o.getTitle());
	}
	@Override
	public String toString() {
		return super.toString() + " - num." + this.number; 
	}
}
