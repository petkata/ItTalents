package musicshop;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import utils.DbCreator;
/**
 * This demo tests all functions
 * @author Petkata
 *
 */
public class Demo {

	public static void main(String[] args) {

		MusicShop dynacord = new MusicShop();
		
		Object dbShop = DbCreator.createDb(dynacord);
		
		if (dbShop instanceof MusicShop) {
			dynacord = (MusicShop) dbShop;
		}
		else {
			System.out.println("Wrong db. Creating default Shop");
		}
		dbShop = null; // clears the reference
		
//		dynacord.showInstrumetnsAndQuantity();

//		dynacord.sortByType();
		
//		dynacord.sortByNameAZ();
		
//		dynacord.sortByPrice("desc");
		
//		dynacord.getMoney();
		
//		dynacord.showInstrumetnsAndQuantity();
		
		System.out.println("\n AFTER SALE \n");
		
		dynacord.sellInstrument("Guitar", 2);

		dynacord.sellInstrument("Drums", 10);
		
		dynacord.sellInstrument("Viola", 20);
//
		dynacord.sellInstrument("Elektric violin", 8);
//		
		dynacord.sellInstrument("Piano", 2);
//		
//		dynacord.currentInstruments();
//		
//		dynacord.getMoney();
		
//		dynacord.getSoldItemsByQuantity();
		
//		dynacord.mostSoldItems();
		
		dynacord.leastSoldItems();

//		dynacord.soldItemsBytType();
		
//		dynacord.mostProfitableType();
		
//		dynacord.mostSoldType();
		
//		dynacord.sellInstrument("Viola", 15);
		
//		dynacord.sellInstrument("Drums", 4);
//
//		dynacord.sellInstrument("Piano", 4);
		
//		dynacord.getMoney();
		
//		System.out.println("\n AFTER ADD \n");
//		
//		dynacord.addInstruments("Drums", 50);
		
//		dynacord.sortByType();
		
//		dynacord.getMoney();
		
//		dynacord.showInstrumetnsAndQuantity();
		
//		Saves the changes in the shop
//		DbCreator.saveToDb(dynacord);
		
//		Reset the database and create new db with initial values
//		DbCreator.deleteDb(dynacord);
//		
//		ScheduledExecutorService sypplyOnceAMonth =
//		        Executors.newScheduledThreadPool(1);
//		
//		ScheduledFuture<?> sypplyOnceAMonthFututre = sypplyOnceAMonth.scheduleWithFixedDelay(new SupplyOnMonth(dynacord), 10, 10, SECONDS); // Scheduled shipment 
//		
//		Runtime.getRuntime().addShutdownHook(new SaveOnExit(dynacord)); // saves when the program finishes, but doues NOT work when the program is terminated
//		
//		This is scheduled exit from the program to test if saving the database before exit works
//		ScheduledExecutorService scheduledExit =
//		        Executors.newScheduledThreadPool(1);
//		
//		ScheduledFuture<?> exitFututre = scheduledExit.schedule(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.exit(0);
//			}
//		}, 30, SECONDS);
		
		
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
	
	private static class SaveOnExit extends Thread {
		private MusicShop shop;

		public SaveOnExit(MusicShop shop) {
			super();
			this.shop = shop;
		}
		
		@Override
		public void run() {
			DbCreator.saveToDb(shop);
		}
		
	}
}
