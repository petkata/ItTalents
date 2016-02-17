package musicshop;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import utils.DbCreator;
import utils.RandomGenerator;

/**
 * This demo tests threads for buying and saving items
 * @author Petkata
 *
 */

public class ThreadDemo {

	public static void main(String[] args) {

		MusicShop dynacord = new MusicShop();
		
		Object dbShop = DbCreator.createDb(dynacord);
		
		if (dbShop instanceof MusicShop) {
			dynacord = (MusicShop) dbShop;
		}
		else {
			System.out.println("Wrong db. Creating default Shop");
		}
		dbShop = null;
		
		dynacord.showInstrumetnsAndQuantity();
		
		new Client("Amebata", dynacord).start();
		new Client("Funky", dynacord).start();
		new Client("Spot", dynacord).start();
		
		

		ScheduledExecutorService supplyOnceAMonthAndSaveDb =
		        Executors.newScheduledThreadPool(2);
		
		ScheduledFuture<?> supplyOnceAMonthFututre = supplyOnceAMonthAndSaveDb.scheduleWithFixedDelay(new SupplyOnMonth(dynacord), 30, 30, SECONDS); // // Scheduled shipment it is 30 days as seconds
		
		ScheduledFuture<?> saveDbOnceAMonth = supplyOnceAMonthAndSaveDb.scheduleWithFixedDelay(new SaveDb(dynacord), 30, 30, SECONDS); // Updates db
		
//		Runtime.getRuntime().addShutdownHook(new SaveDb(dynacord)); // saves when the program finishes, but doues NOT work when the program is terminated
	}
	
	private static class Client extends Thread{
		
		private MusicShop shop;

		public Client(String name, MusicShop shop) {
			super();
			super.setName(name);
			this.shop = shop;
		}
		
		@Override
		public void run() {
			while(true){
				try {
					sleep(5000);
					shop.sellInstrument(RandomGenerator.generateProduct(), RandomGenerator.numberGenerator());
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}
	
	private static class SupplyOnMonth extends Thread {
		private MusicShop shop;

		public SupplyOnMonth(MusicShop shop) {
			super();
			this.shop = shop;
		}
		
		@Override
		public void run() {
			shop.supplyDepletedItems();
		}
	}
	
	private static class SaveDb extends Thread {
		private MusicShop shop;

		public SaveDb(MusicShop shop) {
			super();
			this.shop = shop;
		}
		
		@Override
		public void run() {
			DbCreator.saveToDb(shop);
		}
		
	}

}
