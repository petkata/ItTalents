package demo;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import engine.Library;

public class Demo {

	public static void main(String[] args) {

		Library lib = new Library();

//		lib.showAll();
//		lib.showCategory("Magazines");
		
		lib.rentItem("Pesho", "Book1");

		lib.rentItem("G", "Book2");

		lib.rentItem("Pesho", "Mag 1");

		try {
			Thread.sleep(5000);
			lib.returnItem("Pesho", "Book1");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(5000);
//			lib.returnItem("G", "Book2");
			 lib.revision();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
//		
//		ScheduledFuture<?> rent = scheduler.schedule(new Runnable() {
//
//			@Override
//			public void run() {
//
//				lib.rentItem("Someone", "Algorithms");
//			}
//		}, 4, SECONDS);
//
//		ScheduledFuture<?> rent2 = scheduler.schedule(new Runnable() {
//
//			@Override
//			public void run() {
//
//				lib.returnItem("g", "Book2");
//				lib.returnItem("Pesho", "Book1");
//			}
//		}, 8, SECONDS);
//
//		ScheduledFuture<?> revision = scheduler.scheduleAtFixedRate(new Runnable() {
//
//			@Override
//			public void run() {
//				lib.revision();
//				
//			}
//		}, 31, 31, SECONDS);

//		try {
//			scheduler.awaitTermination(21, TimeUnit.SECONDS);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		scheduler.shutdown();
	}

}
