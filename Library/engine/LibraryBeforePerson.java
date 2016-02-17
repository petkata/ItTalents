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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LibraryBeforePerson {

	private Map<String, List<Item>> catalogue;

	private Map<Item, Map<LocalTime, LocalTime>> rentItems;

//	TODO Make a person
	
	public LibraryBeforePerson() {

		this.rentItems = new LinkedHashMap<>();
		this.catalogue = new HashMap<>();

		Book book1 = new Book("Book1", "Author of book1", 1239, "Triller");
		Book book7 = new Book("Book7", "Author of book7", 2039, "Triller");
		Book book2 = new Book("Book2", "Author of book2", 1839, "Roman");
		Book book6 = new Book("Book6", "Author of book6", 1869, "Roman");
		Book book3 = new Book("Book3", "Author of book3", 1939, "Fantasy");
		Book book4 = new Book("Book4", "Author of book4", 1539, "Fantasy");
		Book book5 = new Book("Book5", "Author of book5", 1839, "Fantasy");

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

		this.catalogue.put("Book", new ArrayList<>());
		this.catalogue.put("Magazine", new ArrayList<>());
		this.catalogue.put("Textbook", new ArrayList<>());

		this.catalogue.get("Book").add(book1);
		this.catalogue.get("Book").add(book2);
		this.catalogue.get("Book").add(book3);
		this.catalogue.get("Book").add(book4);
		this.catalogue.get("Book").add(book5);
		this.catalogue.get("Book").add(book6);
		this.catalogue.get("Book").add(book7);

		this.catalogue.get("Magazine").add(mag4);
		this.catalogue.get("Magazine").add(mag2);
		this.catalogue.get("Magazine").add(mag1);
		this.catalogue.get("Magazine").add(mag3);
		this.catalogue.get("Magazine").add(mag5);

		this.catalogue.get("Textbook").add(tb1);
		this.catalogue.get("Textbook").add(tb2);
		this.catalogue.get("Textbook").add(tb3);
		this.catalogue.get("Textbook").add(tb4);
		this.catalogue.get("Textbook").add(tb5);
		this.catalogue.get("Textbook").add(tb6);

	}

	public void showAll() {
		for (Entry<String, List<Item>> e : catalogue.entrySet()) {
			System.out.println(e.getKey());
			for (Item item : e.getValue()) {
				System.out.println("\t" + item);
			}
		}
	}

	/*
	 * TODO REMOVE // private List<Item> makeCategory(String cat) { //
	 * List<Item> category = new ArrayList<>(); // for (Entry<String,
	 * List<Item>> e : this.catalogue.entrySet()) { // if
	 * (e.getKey().equalsIgnoreCase(cat)) { // category.addAll(e.getValue()); //
	 * } // } // return category; // }
	 */

	private Map<String, List<Item>> mappedCategory(String cat) {
		Map<String, List<Item>> mappedCat = new TreeMap<>();
		for (Entry<String, List<Item>> e : this.catalogue.entrySet()) {
			if (e.getKey().equalsIgnoreCase(cat)) {
				for (Item item : e.getValue()) {
					if (item instanceof Book) {
						if (!mappedCat.containsKey(((Book) item).getGenre())) {
							mappedCat.put(((Book) item).getGenre(), new ArrayList<Item>());
						}
						mappedCat.get(((Book) item).getGenre()).add(item);
					}
					if (item instanceof Textbook) {
						if (!mappedCat.containsKey(((Textbook) item).getTopic())) {
							mappedCat.put(((Textbook) item).getTopic(), new ArrayList<Item>());
						}
						mappedCat.get(((Textbook) item).getTopic()).add(item);
					}
					if (item instanceof Magazine) {
						if (!mappedCat.containsKey(((Magazine) item).getCategory())) {
							mappedCat.put(((Magazine) item).getCategory(), new ArrayList<Item>());
						}
						mappedCat.get(((Magazine) item).getCategory()).add(item);
					}
				}
			}
		}
		return mappedCat;
	}

	public void showCategory(String cat) {

		for (Entry<String, List<Item>> e : this.mappedCategory(cat).entrySet()) {

			System.out.println(e.getKey());
			if (e.getValue().get(0) instanceof Book) {
				e.getValue().sort(new Comparator<Item>() {

					@Override
					public int compare(Item o1, Item o2) {

						if (((Book) o1).getDateOFPublish() > ((Book) o2).getDateOFPublish()) {
							return -1;
						}
						if (((Book) o1).getDateOFPublish() < ((Book) o2).getDateOFPublish()) {
							return 1;
						}
						return 0;
					}
				});
			}

			if (e.getValue().get(0) instanceof Magazine) {
				e.getValue().sort(new Comparator<Item>() {

					@Override
					public int compare(Item o1, Item o2) {
						if (o1.getName().compareTo(o2.getName()) == 0) {
							if (((Magazine) o1).getNumber() > ((Magazine) o2).getNumber()) {
								return 1;
							}
							if (((Magazine) o1).getNumber() < ((Magazine) o2).getNumber()) {
								return -1;
							}
							return 0;
						}
						return o1.getName().compareTo(o2.getName());
					}
				});
			}
			if (e.getValue().get(0) instanceof Textbook) {
				e.getValue().sort(new Comparator<Item>() {

					@Override
					public int compare(Item o1, Item o2) {
						return o1.getName().compareToIgnoreCase(o2.getName());
					}
				});
			}

			for (Item item : e.getValue()) {
				if (!item.isRent()) {
					System.out.println("  " + item);
				}
			}
		}
	}

	public void rentItem(String itemName) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Item itemToRent = findItemByName(itemName);
		if (itemToRent != null) {
			if (itemToRent instanceof Magazine) {
				System.out.println("You cant rent magazines!");
				return;
			}
			rentItems.put(itemToRent, new TreeMap<>());
			if (itemToRent instanceof Book) {
				rentItems.get(itemToRent).put(LocalTime.now(), LocalTime.now().plusSeconds(300));
			}
			if (itemToRent instanceof Textbook) {
				rentItems.get(itemToRent).put(LocalTime.now(), LocalTime.now().plusSeconds(150));
			}
			findItemByName(itemName).setTimeOfTake(LocalTime.now());
			
			findItemByName(itemName).setRent(true);
			
			System.out.println("You took: " + itemToRent + " at " + itemToRent.getTimeOfTake());
		}
	}

	public void returnItem(String itemName){
		
		Item returnedItem = findItemByName(itemName);
		if (returnedItem != null) {
			rentItems.remove(returnedItem);
		}
		
		findItemByName(itemName).setRent(false);
		findItemByName(itemName).setTimeOfreturn(LocalTime.now());
		System.out.println("You returned: " + findItemByName(itemName) + " at " + findItemByName(itemName).getTimeOfreturn());
	}
	
	private Item findItemByName(String name) {
		for (List<Item> listItems : this.catalogue.values()) {
			for (Item item : listItems) {
				if (item.getName().equals(name)) {
					return item;
				}
			}
		}
		System.out.println("No item found");
		return null;
	}

	public int quantityOfRentItems(){
		System.out.println("Qunaity of rent items: " + this.rentItems.size());
		return this.rentItems.size();
	}
	
	public Map<Item, Map<LocalTime, LocalTime>> showRentItems() {
		for (Entry<Item, Map<LocalTime, LocalTime>> e : rentItems.entrySet()) {
			if (e.getKey() instanceof Book) {
				System.out.print("Book: ");
			}
			if (e.getKey() instanceof Textbook) {
				System.out.print("Textbook: ");
			}
			for (Entry<LocalTime, LocalTime> time : e.getValue().entrySet()) {
				System.out.println(e.getKey() + " --- Rent at:" + e.getKey().getTimeOfTake() + " Due time: " + time.getValue());
			}
		}
		return rentItems;
	}

	public void availableItems(){
		
		System.out.println("\n---------------------------\n");
		this.showCategory("Book");
		System.out.println("\n---------------------------\n");
		this.showCategory("textBook");
		System.out.println("\n---------------------------\n");
		this.showCategory("Magazine");
		System.out.println("\n---------------------------\n");
		
	}
	
	public void generateRentItemsLog(){
		File rentLog = new File("." + File.separator + "src" + File.separator + "rentItemsLog.log");
		if (!rentLog.exists()) {
			try {
				rentLog.createNewFile();
			} catch (IOException e) {
				System.err.println("Log could NOT be created");
				e.printStackTrace();
			}
		}
		try(OutputStream logStream = new FileOutputStream(rentLog);Writer writeLog = new BufferedWriter(new OutputStreamWriter(logStream))) {
			String newLine = System.getProperty("line.separator");
			
			writeLog.write("Total items rent: " + rentItems.size() + newLine);
			
			for (Entry<Item, Map<LocalTime, LocalTime>> e : rentItems.entrySet()) {
				writeLog.append("At " + e.getKey().getTimeOfTake() + " : ");
				if (e.getKey() instanceof Book) {
					writeLog.append("Book: ");
				}
				if (e.getKey() instanceof Textbook) {
					writeLog.append("Textbook: ");
				}
				for (Entry<LocalTime, LocalTime> time : e.getValue().entrySet()) {
					writeLog.append( e.getKey() + newLine);
				}
			}
			
			System.out.println("Write successful!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
