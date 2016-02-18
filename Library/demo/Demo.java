package demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.SECONDS;

import engine.Library;

public class Demo {

	public static void main(String[] args) {

		Library lib = new Library();

		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// lib.rentTimer();
		// }
		// }).start();

		// lib.showAll();
		System.out.println("\n---------------------------\n");
		lib.showCategory("Book");
		System.out.println("\n---------------------------\n");
		lib.showCategory("textBook");
		System.out.println("\n---------------------------\n");
		lib.showCategory("Magazine");
		System.out.println("\n-------------RENT--------------\n");

		new Thread(new Runnable() {

			@Override
			public void run() {
				lib.rentItem("Gosho", "Book1");
				// lib.timerItem("Book1");
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				lib.rentItem("Drugiq", "body");

				// lib.timerItem("body");
			}
		}).start();
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// lib.rentItem("Shefa", "Book6");
		//
		//// lib.timerItem("Book6");
		// }
		// }).start();
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// lib.rentItem("Gosho", "Prime numbers in math");
		//
		//// lib.timerItem("Prime numbers in math");
		// }
		// }).start();

		System.out.println("\n---------------------------\n");

		// lib.quantityOfRentItems();
		// lib.showRentItems();

		System.out.println("\n-------------RETURNED--------------\n");

		// lib.returnItem("Shefa","Book1");
		System.out.println("\n---------------------------\n");
		// lib.quantityOfRentItems();
		// lib.showRentItems();
		// try {
		// Thread.sleep(4000);
		// lib.returnItem("Drugiq","body");
		// lib.showCategory("Book");
		// lib.showCategory("textBook");
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		System.out.println("\n---------------------------\n");

		ScheduledExecutorService scheduledExit = Executors.newScheduledThreadPool(3);
		//
		

		ScheduledFuture<?> rent = scheduledExit.schedule(new Runnable() {

			@Override
			public void run() {

				lib.rentItem("Someone", "Book2");
			}
		}, 4, SECONDS);

		ScheduledFuture<?> rent2 = scheduledExit.schedule(new Runnable() {

			@Override
			public void run() {

				lib.returnItem("Gosho", "Book1");
			}
		}, 8, SECONDS);

		ScheduledFuture<?> rent3 = scheduledExit.schedule(new Runnable() {

			@Override
			public void run() {

				lib.rentItem("Gosho", "Book1");
			}
		}, 9, SECONDS);

		//
		ScheduledFuture<?> revision = scheduledExit.scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {
				lib.revision();
			}
		}, 15, 15, SECONDS);

		/*
		 * lib.availableItems();
		 * 
		 * lib.generateRentItemsLog();
		 * 
		 */
	}

}
