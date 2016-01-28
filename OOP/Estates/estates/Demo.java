package estates;

public class Demo {
	
	//TODO validations
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Estate apartment = new Apartment("MilkovAp", 56.3, "somewhere", true, 3, true);
		
		Estate garage = new Garage("JohnnyGarages", 9, "underworld", false, 5, 3);
		
		Offer.Sale sale = new Offer.Sale(apartment, 312);
		
		Offer.Rent rent = new Offer.Rent(garage, 10);

		RealEstateAgency address = new RealEstateAgency("Address");
		
		address.addEstate(apartment);
		
		address.addEstate(garage);
		address.addEstate(garage);
		
		address.addEstate(new House("HouesOFPain", 66.6, "Hell", true, 6));
		
		address.addOffer(new Offer.Sale(new Office("EmpireStateOffice", 35, "NY", false, 2, true), 3269.99));
		
		address.addOffer(rent);
		
		address.addOffer(sale);
		
		address.status();
		address.findEstatesByLocation("NY");
		
//		rent.showOffer();
//		
//		sale.showOffer();
	}
}
