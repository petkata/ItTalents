package engine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Library {

	Thread rentThread;

	private Map<String, Map<String, TreeSet<Item>>> catalogue;
	private Map<Item, Set<ItemLog>> historyLog;

	public Library() {

		this.catalogue = new HashMap<>();
		this.historyLog = new HashMap<>();

		Book book1 = new Book("Book1", "Author of book1", 1239, "Publisher 1", "Triller");
		Book book7 = new Book("Book7", "Author of book7", 2039, "Publisher 4", "Triller");
		Book book2 = new Book("Book2", "Author of book2", 1839, "Publisher 1", "Roman");
		Book book6 = new Book("Book6", "Author of book6", 1869, "Publisher 3", "Roman");
		Book book3 = new Book("Book3", "Author of book3", 1939, "Publisher 1", "Fantasy");
		Book book4 = new Book("Book4", "Author of book4", 1539, "Publisher 2", "Fantasy");
		Book book5 = new Book("Book5", "Author of book5", 1839, "Publisher 2", "Fantasy");

		Textbook tb1 = new Textbook("Some History TB", "Author of TB1", "Publisher of TB1", "History");
		Textbook tb2 = new Textbook("Algorithms", "Author of TB2", "Publisher of TB2", "Math");
		Textbook tb3 = new Textbook("Prime numbers in math", "Author of TB3", "Publisher of TB3", "Math");
		Textbook tb5 = new Textbook("Analitic math", "Author of TB3", "Publisher of TB5", "Math");
		Textbook tb4 = new Textbook("Human body", "Author of TB4", "Publisher of TB4", "Biology");
		Textbook tb6 = new Textbook("body", "Author of TB6", "Publisher of TB6", "Biology");

		Magazine mag1 = new Magazine("Mag 1", "Publisher of Mag 1", "fashion", 1, 2011);
		Magazine mag2 = new Magazine("Mag 2", "Publisher of Mag 2", "Science", 1, 2010);
		Magazine mag3 = new Magazine("Mag 1", "Publisher of Mag 1", "fashion", 2, 2011);
		Magazine mag4 = new Magazine("Mag 1", "Publisher of Mag 1", "fashion", 4, 2012);
		Magazine mag5 = new Magazine("Mag 5", "Publisher of Mag 5", "History", 1, 2011);

		this.catalogue.put("Books", new TreeMap<>());
		this.catalogue.put("Magazines", new TreeMap<>());
		this.catalogue.put("Textbooks", new TreeMap<>());

		this.catalogue.get("Books").put("Triller", new TreeSet<>());
		this.catalogue.get("Books").put("Roman", new TreeSet<>());
		this.catalogue.get("Books").put("Fantasy", new TreeSet<>());

		// ----------------------BOOKS
		this.catalogue.get("Books").get("Fantasy").add(book3);
		this.catalogue.get("Books").get("Fantasy").add(book4);
		this.catalogue.get("Books").get("Fantasy").add(book5);

		this.catalogue.get("Books").get("Triller").add(book7);
		this.catalogue.get("Books").get("Triller").add(book1);

		this.catalogue.get("Books").get("Roman").add(book2);
		this.catalogue.get("Books").get("Roman").add(book6);

		// ----------------------TEXTBOOKS

		this.catalogue.get("Textbooks").put("History", new TreeSet<>());
		this.catalogue.get("Textbooks").put("Math", new TreeSet<>());
		this.catalogue.get("Textbooks").put("Biology", new TreeSet<>());

		this.catalogue.get("Textbooks").get("History").add(tb1);

		this.catalogue.get("Textbooks").get("Math").add(tb2);
		this.catalogue.get("Textbooks").get("Math").add(tb3);
		this.catalogue.get("Textbooks").get("Math").add(tb5);

		this.catalogue.get("Textbooks").get("Biology").add(tb4);
		this.catalogue.get("Textbooks").get("Biology").add(tb6);

		// ----------------------MAGAZINES

		this.catalogue.get("Magazines").put("Science", new TreeSet<>());
		this.catalogue.get("Magazines").put("History", new TreeSet<>());
		this.catalogue.get("Magazines").put("fashion", new TreeSet<>());

		this.catalogue.get("Magazines").get("Science").add(mag2);

		this.catalogue.get("Magazines").get("History").add(mag5);

		this.catalogue.get("Magazines").get("fashion").add(mag1);
		this.catalogue.get("Magazines").get("fashion").add(mag3);
		this.catalogue.get("Magazines").get("fashion").add(mag4);

	}

	public void showAll() {
		for (Entry<String, Map<String, TreeSet<Item>>> e : this.catalogue.entrySet()) {
			System.out.println(e.getKey() + ":");
			for (Entry<String, TreeSet<Item>> genres : e.getValue().entrySet()) {
				System.out.println("\t" + genres.getKey() + ": ");
				for (Item item : genres.getValue()) {
					System.out.println("\t\t" + item);
				}
			}
		}
	}

	public void showCategory(String category) {
		for (Entry<String, Map<String, TreeSet<Item>>> e : this.catalogue.entrySet()) {
			if (e.getKey().equals(category)) {
				for (Entry<String, TreeSet<Item>> genres : e.getValue().entrySet()) {
					System.out.println(genres.getKey() + ": ");
					for (Item item : genres.getValue()) {
						System.out.println("  " + item);
					}
				}
			}
		}
	}

	private Item findItemByTitle(String title) {

		// private Map<String, Map<String, TreeSet<Item>>> catalogue;
		for (Map<String, TreeSet<Item>> cat : this.catalogue.values()) {
			for (TreeSet<Item> items : cat.values()) {
				for (Item item : items) {
					if (item.getTitle().equalsIgnoreCase(title)) {
						return item;
					}
				}
			}
		}
		System.out.println("No item found");
		return null;
	}

	public void rentItem(String client, String itemTitle) {
		Item itemToRent = findItemByTitle(itemTitle);
		if (itemToRent.getPeriod() == 0) {
			System.out.println("Can't rent Magazines");
			return;
		}
		itemToRent.setRent(true);
		itemToRent.setTimeOFRent(LocalTime.now());
		this.historyLog.put(itemToRent, new TreeSet<>());
		this.historyLog.get(itemToRent).add(new ItemLog(client, itemToRent.getPeriod(), LocalTime.now()));
		System.out.println(client + " took " + itemTitle);
		
		rentThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(itemToRent.getPeriod() * 10); // multiply by 1000 to set time to 5 minutes . current is 3 seconds 
				} catch (InterruptedException e) {
					return;
				}
				while (itemToRent.isRent()) {
					itemToRent.setTotaltax();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		rentThread.start();

	}

	public void returnItem(String client, String itemTitle) {
		rentThread.interrupt();
		Item returnedItem = findItemByTitle(itemTitle);

		returnedItem.setRent(false);
		returnedItem.setTimeOFReturn(LocalTime.now());
		System.out.println(client + " returned " + itemTitle + " and have to pay " + returnedItem.getTotaltax());
	}

	private int numberOfAvailableItems() {
		int countitems = 0;
		for (Entry<String, Map<String, TreeSet<Item>>> e : this.catalogue.entrySet()) {
			for (Entry<String, TreeSet<Item>> genres : e.getValue().entrySet()) {
				for (Item item : genres.getValue()) {
					if (!item.isRent()) {
						countitems++;
					}
				}
			}
		}
		System.out.println("Available items: " + countitems);
		return countitems;
	}

	private int numberOfRentItemsNow() {
		int countitems = 0;
		for (Entry<String, Map<String, TreeSet<Item>>> e : this.catalogue.entrySet()) {
			for (Entry<String, TreeSet<Item>> genres : e.getValue().entrySet()) {
				for (Item item : genres.getValue()) {
					if (item.isRent()) {
						countitems++;
					}
				}
			}
		}
		return countitems;
	}

	private void generateLogOfRentItmes() {
		File rentLog = new File("." + File.separator + "src" + File.separator + "Rent items.log");
		if (!rentLog.exists()) {
			try {
				rentLog.createNewFile();
			} catch (IOException e) {
				System.err.println("Log could NOT be created");
				e.printStackTrace();
			}
		}
		try (OutputStream logStream = new FileOutputStream(rentLog);
				Writer writeLog = new BufferedWriter(new OutputStreamWriter(logStream))) {
			String newLine = System.getProperty("line.separator");

			writeLog.write("Total items rent: " + numberOfRentItemsNow() + newLine);

			for (Entry<Item, Set<ItemLog>> e : historyLog.entrySet()) {
				if (e.getKey().isRent()) {
					for (ItemLog logs : e.getValue()) {
						writeLog.append(logs.getTimeOFRent().toString() + " " + e.getKey() + newLine);
					}
				}
			}
			writeLog.write(newLine + "Time of log: " + LocalTime.now());
			System.out.println("Rent items log updated at successfully at " + LocalTime.now());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void generateExpiredItems() {
		double totalExpiredTax = 0;
		Map<Double, Map<Item, String>> taxes = new TreeMap<>(Collections.reverseOrder());

		for (Entry<Item, Set<ItemLog>> e : historyLog.entrySet()) {
			if (e.getKey().isRent()) {
				for (ItemLog logs : e.getValue()) {
					if (!taxes.keySet().contains(e.getKey().getTotaltax())) {
						taxes.put(e.getKey().getTotaltax(), new HashMap<>());
					}
					taxes.get(e.getKey().getTotaltax()).put(e.getKey(), logs.getClient());
					totalExpiredTax += e.getKey().getTotaltax();
				}
			}
		}
		File expiredBooks = new File("." + File.separator + "src" + File.separator + "Expired Books.log");
		if (!expiredBooks.exists()) {
			try {
				expiredBooks.createNewFile();
			} catch (IOException e) {
				System.err.println("Log could NOT be created");
				e.printStackTrace();
			}
		}
		try (OutputStream logStream = new FileOutputStream(expiredBooks);
				Writer writeLog = new BufferedWriter(new OutputStreamWriter(logStream))) {
			String newLine = System.getProperty("line.separator");

			for (Entry<Double, Map<Item, String>> e : taxes.entrySet()) {
				for (Entry<Item, String> subEn : e.getValue().entrySet()) {
					writeLog.append("Title: " + subEn.getKey().getTitle() + " --- User: " + subEn.getValue()
							+ " --- Tax to pay: " + e.getKey() + newLine);
				}
			}
			writeLog.write(newLine + "Total tax form expired items: " + totalExpiredTax);
			writeLog.write(newLine + "Time of log: " + LocalTime.now());
			System.out.println("Expired Books log updated successfully at " + LocalTime.now());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void revision() {
		this.numberOfAvailableItems();
		this.generateLogOfRentItmes();
		this.generateExpiredItems();
	}
}
