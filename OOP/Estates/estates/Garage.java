package estates;

public class Garage extends Estate {

	private double width;
	private double height;
	
	protected Garage(String name, double area, String location, boolean hasFurniture, double width, double height) {
		super(name, area, location, hasFurniture);
		this.width = width;
		this.height = height;
	}

	@Override
	protected String getType() {
		return "Garage";
	}
	
	@Override
	public void showEstateInfo() {
		super.showEstateInfo();
		System.out.println("Width: " + this.width );
		System.out.println("Height: " + this.height);
	}
	
}
