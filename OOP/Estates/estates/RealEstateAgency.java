package estates;

public class RealEstateAgency {

	private Estate[] estates;
	private Offer[] offers;
	private int estatesSpaces;
	private int offersSpaces;
	private String name;

	protected RealEstateAgency(String name) {
		this.name = name;
		this.estatesSpaces = 5;
		this.offersSpaces = 4;
		this.estates = new Estate[this.estatesSpaces];
		this.offers = new Offer[this.offersSpaces];
	}

	public void addEstate(Estate estate) {
		if (this.estatesSpaces <= 0) {
			System.out.println("There is no available space for more estates");
			return;
		}
		if (this.isExistingInEstates(estate)) {
			System.out.println("The estate has already been added! ");
			return;
		}
		
		for (int i = 0; i < estates.length; i++) {
			if (this.estates[i] == null ) {
				this.estates[i] = estate;
				this.estatesSpaces--;
				System.out.println("Estate added");
				return;
			}
		}
	}
	
	public void addOffer(Offer offer) {
		if (this.offersSpaces <= 0) {
			System.out.println("There is no available space for more offers");
			return;
		}
		if (!isExistingInEstates(offer.getEstate()) && this.estatesSpaces > 0) {
			this.addEstate(offer.getEstate());
		}
		else if(this.estatesSpaces <= 0){
			System.out.println("Could not add the offer: Not available space for new estate!");
			return;
		}
		for (int i = 0; i < offers.length; i++) {
			if (this.offers[i] == null ) {
				this.offers[i] = offer;
				this.offersSpaces--;
				System.out.println("Offer added");
				return;
			}
		}
	}
	
	private boolean isExistingInEstates(Estate estate) {
		for (int i = 0; i < this.estates.length; i++) {
			if (this.estates[i] == null) {
				continue;
			}
			if (this.estates[i].isTheSameAs(estate)) {
				return true;
			}
		}
		return false;
	}

	public void findEstatesByLocation(String searchedLocation) {
		System.out.println("---Result for estates in " + searchedLocation + "---");
		for (int i = 0; i < this.estates.length; i++) {
			if (this.estates[i] == null) {
				continue;
			}
			if (this.estates[i].getLocation().equals(searchedLocation)) {
				this.estates[i].showEstateInfo();
			}
		}
	}
	
	public void status(){
		this.showAllEstates();
		this.showAllOffers();
	}
	
	private void showAllEstates(){
		System.out.println("--------Estates---------");
		for (int i = 0; i < estates.length; i++) {
			if (this.estates[i] == null) {
				continue;
			}
			this.estates[i].showEstateInfo();
			System.out.println("------------------------");
		}
	}
	
	private void showAllOffers(){
		System.out.println("--------Offers---------");
		for (int i = 0; i < this.offers.length; i++) {
			if (this.offers[i] == null) {
				continue;
			}
			this.offers[i].showOffer();
		}
	}
}