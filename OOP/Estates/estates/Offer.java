package estates;

public abstract class Offer {
	
	private Estate estate;
	private double price;
	
	protected Offer(Estate estate, double price) {
		this.estate = estate;
		this.price = price;
	}
	
	protected Estate getEstate(){
		return this.estate;
	}
	
	static class Sale extends Offer{
		static final String OFFER_TYPE = "For Sale";
		protected Sale(Estate estate, double price) {
			super(estate, price);
		}
		@Override
		String getTypeOfOffer() {
			return Sale.OFFER_TYPE;
		}
	}
	
	static class Rent extends Offer{
		static final String OFFER_TYPE = "For Rent";
		protected Rent(Estate estate, double price) {
			super(estate, price);
		}
		@Override
		String getTypeOfOffer() {
			return Rent.OFFER_TYPE;
		}
		
	}
	
	abstract String getTypeOfOffer();
	
	void showOffer(){
		System.out.println(" ------ " + this.getTypeOfOffer() + " ------ ");
		this.estate.showEstateInfo();
		System.out.println("Price: " + this.price);
		System.out.println("------------------------");
	}
}
