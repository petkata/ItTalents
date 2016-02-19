package demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.SECONDS;

import engine.Library;

public class Demo {

	public static void main(String[] args) {

		Library lib = new Library();

//		 lib.showAll();
//		System.out.println("\n---------------------------\n");
//		lib.showCategory("Book");
//		System.out.println("\n---------------------------\n");
//		lib.showCategory("textBook");
//		System.out.println("\n---------------------------\n");
//		lib.showCategory("Magazine");
//		System.out.println("\n-------------RENT--------------\n");
//
//
//		 lib.rentItem("Shefa","Book1");
//
//		 lib.rentItem("Gosho","body");
//
//		 lib.rentItem("Gosho","Book2");
//
//		 lib.rentItem("Maks","Mag 1");
//		System.out.println("\n---------------------------\n");
//
//		 lib.quantityOfRentItems();
//		 lib.showRentItems();
//
//		System.out.println("\n-------------RETURNED--------------\n");
//
//			lib.returnItem("Shefa","Book1");
//		
//		System.out.println("\n---------------------------\n");
//		 lib.quantityOfRentItems();
//		 lib.showRentItems();
//		 lib.showCategory("Book");
//		 lib.showCategory("textBook");
//		 

//		System.out.println("\n------------THREADS---------------\n");

		new Thread(new Runnable() {

			@Override
			public void run() {
				lib.rentItem("Gosho", "Book1");

				lib.rentItem("Gosho", "Book5");
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				lib.rentItem("Drugiq", "body");

			}
		}).start();
		 new Thread(new Runnable() {
		
		 @Override
		 public void run() {
		 lib.rentItem("Shefa", "Book6");
		
		 }
		 }).start();
		 new Thread(new Runnable() {
		
		 @Override
		 public void run() {
		 lib.rentItem("Gosho", "Prime numbers in math");
		
		 }
		 }).start();

//		 System.out.println("\n------------SCHEDLUED THREADS---------------\n");
		
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

		//
		ScheduledFuture<?> revision = scheduledExit.scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {
				lib.revision();
			}
		}, 15, 15, SECONDS); // revision is made every 15 seconds 
	}

}
