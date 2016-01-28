package estates;

public abstract class Estate {

	private String name;
	private double area;
	private String location;
	private boolean hasFurniture;
	
	protected Estate(String name, double area, String location, boolean hasFurniture) {
		this.name = name;
		this.area = area;
		this.location = location;
		this.hasFurniture = hasFurniture;
	}
	
	protected String getLocation(){
		return this.location;
	}
	
	protected abstract String getType();
	
	public void showEstateInfo(){
		System.out.println("Type: " + this.getType());
		System.out.println("Name: " + this.name);
		System.out.println("Area: " + this.area);
		//TODO location, hasFurniture
	}

	protected boolean isTheSameAs(Estate estate) {
		if (this.getType().equals(estate.getType()) && this.location.equals(estate.getLocation())) {
			return true;
		}
		return false;
	}
}
