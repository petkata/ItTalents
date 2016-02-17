package musicshop;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MusicShop implements Serializable{
//				v -type          v-name   v-price   v-quantity
	private Map<String, Map<Map<String, Integer>, Integer>> catalog;
	
	private Map<String, Map<Map<String, Integer>, Integer>> soldItems;
	
	private Map<String, Integer> quantityOfSoldItems;
	
	private double money;
	
	private double totalProfit;
	
	private boolean isFromSell;
	
	private ItemSupplier supp;
	
	private int countMonths;
	
	public MusicShop() {
		
		
		
		this.supp = new ItemSupplier();
		
		this.money = 100_000;
		
		this.quantityOfSoldItems = new HashMap<>();
		
		this.soldItems = new HashMap<>();
		this.soldItems.put("Strings", new HashMap<>());
		this.soldItems.put("Percussion", new HashMap<>());
		this.soldItems.put("Woodwinds", new HashMap<>());
		this.soldItems.put("Keyboards", new HashMap<>());
		this.soldItems.put("Elektric", new HashMap<>());
		
		this.catalog = new HashMap<>();
		
		this.catalog.put("Strings", new HashMap<>());
		this.catalog.put("Percussion", new HashMap<>());
		this.catalog.put("Woodwinds", new HashMap<>());
		this.catalog.put("Keyboards", new HashMap<>());
		this.catalog.put("Elektric", new HashMap<>());

		//Strings		
		Map<String, Integer> violin = new HashMap<>();
		violin.put("Violin", 200);
		this.catalog.get("Strings").put(violin, 10);
		
		Map<String, Integer> viola = new HashMap<>();
		viola.put("Viola", 500);
		this.catalog.get("Strings").put(viola, 10);
		
		Map<String, Integer> contrabass = new HashMap<>();
		contrabass.put("Contrabass", 100);
		this.catalog.get("Strings").put(contrabass, 10);

		Map<String, Integer> harp = new HashMap<>();
		harp.put("Harp", 50);
		this.catalog.get("Strings").put(harp, 10);

		Map<String, Integer> guitar = new HashMap<>();
		guitar.put("Guitar", 80);
		this.catalog.get("Strings").put(guitar, 10);

		//Drums
		Map<String, Integer> drums = new HashMap<>();
		drums.put("Drums", 120);
		this.catalog.get("Percussion").put(drums, 10);

		Map<String, Integer> taram = new HashMap<>();
		taram.put("Tarambuka", 400);
		this.catalog.get("Percussion").put(taram, 10);
		
		Map<String, Integer> contra = new HashMap<>();
		contra.put("Contrabass", 145);
		this.catalog.get("Percussion").put(contra, 10);

		Map<String, Integer> tambo = new HashMap<>();
		tambo.put("Tambourine", 30);
		this.catalog.get("Percussion").put(tambo, 10);
		
		Map<String, Integer> tapan = new HashMap<>();
		tapan.put("Tapan", 1234);
		this.catalog.get("Percussion").put(tapan, 10);
		
		// Wind
		Map<String, Integer> trump = new HashMap<>();
		trump.put("Trumpet", 80);
		this.catalog.get("Woodwinds").put(trump, 10);

		Map<String, Integer> tromb  = new HashMap<>();
		tromb.put("Trombone", 90);
		this.catalog.get("Woodwinds").put(tromb, 10);
		
		Map<String, Integer> tube = new HashMap<>();
		tube.put("Tube", 234);
		this.catalog.get("Woodwinds").put(tube, 10);
		
		Map<String, Integer> flute= new HashMap<>();
		flute.put("Flute", 70);
		this.catalog.get("Woodwinds").put(flute, 10);
		
		Map<String, Integer> clarinet = new HashMap<>();
		clarinet.put("Clarinet", 70);
		this.catalog.get("Woodwinds").put(clarinet, 10);
		
		// Key
		Map<String, Integer> organ = new HashMap<>();
		organ.put("Pipe organ", 10_000);
		this.catalog.get("Keyboards").put(organ, 10);
		
		Map<String, Integer> piano = new HashMap<>();
		piano.put("Piano", 3000);
		this.catalog.get("Keyboards").put(piano, 10);

		Map<String, Integer> accord = new HashMap<>();
		accord.put("Accordion", 5000);
		this.catalog.get("Keyboards").put(accord, 10);
		
		// electr
		Map<String, Integer> synth = new HashMap<>();
		synth.put("Synthesizer", 1990);
		this.catalog.get("Elektric").put(synth, 10);

		Map<String, Integer> bassg = new HashMap<>();
		bassg.put("Bass Guitar", 434);
		this.catalog.get("Elektric").put(bassg, 10);

		Map<String, Integer> eViolin = new HashMap<>();
		eViolin.put("Elektric violin", 450);
		this.catalog.get("Elektric").put(eViolin, 10);
		
		
	}

	void sellInstrument(String name, int quantity){
		this.isFromSell = true;
		if (getInstrumentQuantity(name) > 0) {
			if (getInstrumentQuantity(name) < quantity) {
				System.out.println("Client requires more " + name + "(" + quantity + ")" + " than the shop has" + "(" + getInstrumentQuantity(name) + ")" + ", all items would be sold");
				quantity = getInstrumentQuantity(name);
			}
			setQuantityOfInstrument(name, quantity,this.isFromSell);
			this.money+= quantity*getPriceOfItem(name);
			this.totalProfit+= quantity*getPriceOfItem(name);
			
			if (this.quantityOfSoldItems.containsKey(name)) {
				this.quantityOfSoldItems.put(name, quantityOfSoldItems.get(name) + quantity);
			}
			else {
				this.quantityOfSoldItems.put(name, quantity);
			}
			System.out.println(Thread.currentThread().getName() + " bought: " + quantity + " " + name);
		}
		else {
			if (supp.getTimeByName(name) <= 0) {
				System.out.println(name + " not available at the moment!");
//				System.out.println(name + " were unique items and the supplier can't give us more");
				return;
			}
			System.out.println("There are not enough " + name + " We will call the supplier!");
			System.out.println(name + " will be available in our store after " + supp.getTimeByName(name) + " days!");
			
		}
		this.addToSoldItemsList(name, quantity);
	}
	
	void soldItemsBytType(){
		int soldByType = 0;
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : soldItems.entrySet()) {
			if (!e.getValue().keySet().isEmpty()) {
				System.out.println(e.getKey() + ": ");
				soldByType =0;
			}
			for (Entry<Map<String, Integer>, Integer> items : e.getValue().entrySet()) {
				soldByType += items.getValue();
				
				for (Entry<String, Integer> item : items.getKey().entrySet()) {
					System.out.println("  " + item.getKey() + " Price: " + item.getValue() + " --- " + items.getValue() + " sold" +" \n");
				}
			}
			if (!e.getValue().keySet().isEmpty()) {
				System.out.println("Total sold items: " + soldByType + " \n");
			}
		}
	}

	void mostSoldType(){
		System.out.println("Types with most sold items:");
		int soldItem = 0;
		int mostSoldQuan = 0;
//		Find the most sold quantity
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : soldItems.entrySet()) {
			soldItem=0;
			for (Entry<Map<String, Integer>, Integer> items : e.getValue().entrySet()) {
				soldItem += items.getValue();
			}
			if (mostSoldQuan < soldItem) {
				mostSoldQuan = soldItem;
			}
		}
//		adding all items with most sold quantity
		
		Map<String, Map<Map<String, Integer>, Integer>> mST = new LinkedHashMap<>();
		
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : soldItems.entrySet()) {
			soldItem=0;
			for (Entry<Map<String, Integer>, Integer> items : e.getValue().entrySet()) {
				soldItem += items.getValue();
			}
			if (soldItem == mostSoldQuan) {
				mST.put(e.getKey(), e.getValue());
			}
		}
		
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : mST.entrySet()) {
				System.out.println(" "+e.getKey()  + " - " + mostSoldQuan + " : " + e.getValue());
		}
	}

	void mostProfitableType(){
		System.out.println("Types with most profit from sales:");
		int soldItem = 0;
		int mostSoldProfit = 0;
//		Find the most sold quantity
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : soldItems.entrySet()) {
			soldItem=0;
			for (Entry<Map<String, Integer>, Integer> items : e.getValue().entrySet()) {
				for ( Entry<String, Integer> item : items.getKey().entrySet()) {
					soldItem += item.getValue()*items.getValue();
				}
			}
			if (mostSoldProfit < soldItem) {
				mostSoldProfit = soldItem;
			}
		}
		
//		adding all items with most sold quantity
		Map<String, Map<Map<String, Integer>, Integer>> mST = new LinkedHashMap<>();
		
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : soldItems.entrySet()) {
			soldItem=0;
			for (Entry<Map<String, Integer>, Integer> items : e.getValue().entrySet()) {
				for ( Entry<String, Integer> item : items.getKey().entrySet()) {
					soldItem += item.getValue()*items.getValue();
				}
			}
			if (soldItem == mostSoldProfit) {
				mST.put(e.getKey(), e.getValue());
			}
		}
		
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : mST.entrySet()) {
				System.out.println(" "+e.getKey()  + " - " + mostSoldProfit + " : " + e.getValue());
		}
	}
	
	private int getInstrumentQuantity(String name) {
		for (Map<Map<String, Integer>, Integer> items : this.catalog.values()) {
			for (Entry<Map<String, Integer>, Integer> item : items.entrySet()) {
				for (String itemName : item.getKey().keySet()) {
					if (itemName.equalsIgnoreCase(name) && item.getValue() >0) {
						return  item.getValue();
					}
				}
			}
		}
		return 0;
	}
	
	private void addToSoldItemsList(String name, int quantity) {
		for (Entry<String, Map<Map<String, Integer>, Integer>> items : this.catalog.entrySet()) {
			for (Map<String, Integer> item : items.getValue().keySet()) {
				for (String itemName : item.keySet()) {
					if (itemName.equalsIgnoreCase(name)) {
						this.soldItems.get(items.getKey()).put(item, quantity);
					}
				}
			}
		}
	}
	
	private void setQuantityOfInstrument(String name, int quantity, boolean isFromSell) {
		for (Map<Map<String, Integer>, Integer> items : this.catalog.values()) {
			for (Entry<Map<String, Integer>, Integer> item : items.entrySet()) {
				for (String itemName : item.getKey().keySet()) {
					if (itemName.equalsIgnoreCase(name)) {
						if (isFromSell) {
							items.put(item.getKey(), item.getValue()-quantity);
						}
						else{
							items.put(item.getKey(), item.getValue()+quantity);
						}
					}
				}
			}
		}
	}
	
	private int getPriceOfItem(String name) {
		for (Map<Map<String, Integer>, Integer> items : this.catalog.values()) {
			for (Entry<Map<String, Integer>, Integer> item : items.entrySet()) {
				for (Entry<String, Integer> itemPrice : item.getKey().entrySet()) {
					if (itemPrice.getKey().equals(name)) {
						return itemPrice.getValue();
					}
				}
			}
		}
		return 0;
	}
	
	/**
	 * We assume that we will only receive items that are in our catalog
	 * @param name - string
	 * @param quantity - int
	 */
	void addInstruments(String name, int quantity){
		this.isFromSell = false;
		this.setQuantityOfInstrument(name, quantity, isFromSell);
		this.money -= quantity*getPriceOfItem(name); // it is not specified that the shop pays for these
	}
	
	private boolean hasInstrument(String name) {
		for (Map<Map<String, Integer>, Integer> items : this.catalog.values()) {
			for (Entry<Map<String, Integer>, Integer> item : items.entrySet()) {
				for (String itemName : item.getKey().keySet()) {
					if (itemName.equalsIgnoreCase(name)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	void sortByType(){
		Map<String, Map<Map<String, Integer>, Integer>> sortedByType = new TreeMap<>();
		sortedByType.putAll(this.catalog);
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : sortedByType.entrySet()) {
			System.out.println(e.getKey() + ": \n");
			for (Map<String, Integer> items : e.getValue().keySet()) {
				for (Entry<String, Integer> item : items.entrySet()) {
					System.out.println("  " + item.getKey() + " Price: " + item.getValue() + " \n");
				}
			}
		}
	}
	
	void sortByNameAZ(){
		for (Entry<String, Integer> item : getAllItems().entrySet()) {
			System.out.println("  " + item.getKey() + " Price: " + item.getValue() + " \n");
		}
	}
	
	/**
	 * <p>Prints instruments sorted by price depending on the input sort order.Default is ascending.</p>
	 * <p>Type <strong>Desc</strong> for descending order.</p> 
	 * @param sortOrder - String (Asc or Desc)
	 */
	void sortByPrice(String sortOrder){
		for (Entry<String, Integer> item : this.sortMapByValue(this.getAllItems(), sortOrder).entrySet()) {
			System.out.println("  " + item.getKey() + " Price: " + item.getValue() + " \n");
		}
	}
	
	private Map<String, Integer> getAllItems(){
		Map<String, Integer> sortedItems = new TreeMap<>();
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : this.catalog.entrySet()) {
			for (Map<String, Integer> items : e.getValue().keySet()) {
				sortedItems.putAll(items);
			}
		}
		return sortedItems;
	}
	
	/**
	 * Items with quantity greater than 0
	 */
	void currentInstruments(){
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : this.catalog.entrySet()) {
			System.out.println(e.getKey() + ": \n");
			for (Entry<Map<String, Integer>, Integer> items : e.getValue().entrySet()) {
				for (Entry<String, Integer> item : items.getKey().entrySet()) {
					if (items.getValue() > 0) {
						System.out.println("  " + item.getKey() + " Price: " + item.getValue() + " Qunatity: " + items.getValue() + " \n");
					}
				}
			}
		}
	}
	
	void getSoldItemsByQuantity(){
		System.out.println("Sold items: ");
		for (Entry<String, Integer> e : sortMapByValue(quantityOfSoldItems, "Desc").entrySet()) {
			System.out.println(" "+e.getKey() + " - " + e.getValue());
		}
	}
	
	void showProfit(){
		System.out.println("Total profit: " + this.totalProfit);
	}
	
	void mostSoldItems(){
		System.out.println("Most sold items: ");
		int mostSoldQuan = 0;
//		Find the most sold quantity
		mostSoldQuan = Collections.max(quantityOfSoldItems.values());
		
		
//		adding all items with most sold quantity
		Map<String, Integer> mSI = new LinkedHashMap<>();
		for (Entry<String, Integer> e : sortMapByValue(quantityOfSoldItems, "Desc").entrySet()) {
			if (e.getValue() == mostSoldQuan) {
				mostSoldQuan = e.getValue();
				mSI.put(e.getKey(), e.getValue());
			}
		}
		for (Entry<String, Integer> e : mSI.entrySet()) {
				System.out.println(" "+e.getKey() + " - " + e.getValue());
		}
	}
	
	void leastSoldItems(){
		System.out.println("Least sold items: ");
		int leastSoldQuan = 0;
//		Find the least sold quantity
		leastSoldQuan = Collections.min(quantityOfSoldItems.values());
		
//		adding all items with least sold quantity
		Map<String, Integer> mSI = new LinkedHashMap<>();
		for (Entry<String, Integer> e : sortMapByValue(quantityOfSoldItems, "asc").entrySet()) {
			if (e.getValue() == leastSoldQuan) {
				leastSoldQuan = e.getValue();
				mSI.put(e.getKey(), e.getValue());
			}
		}
		for (Entry<String, Integer> e : mSI.entrySet()) {
				System.out.println(" "+e.getKey() + " - " + e.getValue());
		}
	}
	
	/**
	 * Finds witch item has depleted and supplies 15 of them
	 */
	void supplyDepletedItems(){
		boolean hasSupplied = false;
		countMonths++;
		for (Map<Map<String, Integer>, Integer> items : this.catalog.values()) {
			if (items.containsValue(0)) {
				for (Entry<Map<String, Integer>, Integer> item : items.entrySet()) {
					if (item.getValue() <= 0 ) {
						items.put(item.getKey(), 15); // adds 15 to depleted ones
						System.out.println("Month " + countMonths + " supply : " + item.getKey().keySet() + " added 15" );
						hasSupplied = true;
					}
				}
			}
		}
		if (!hasSupplied) {
			System.out.println("No need to supply this month(" + countMonths + ")");
		}
	}
	
	void getMoney(){
		System.out.println("Funds: " + this.money);
	}
	
	private Map<String, Integer> sortMapByValue(Map<String, Integer> map, String sortOrder){
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		List<Entry<String, Integer>> entries = new LinkedList<>();
		entries.addAll(map.entrySet());
		entries.sort(new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (sortOrder.equalsIgnoreCase("Desc")) {
					return o2.getValue().compareTo(o1.getValue()) ;
				}
				return o1.getValue().compareTo(o2.getValue()) ;
			}
		});
		
		for (Entry<String, Integer> e : entries) {
			sortedMap.put(e.getKey(), e.getValue());
		}
		
		return sortedMap;
	}
	
	void showInstrumetnsAndQuantity(){
		for (Entry<String, Map<Map<String, Integer>, Integer>> e : this.catalog.entrySet()) {
			System.out.println(e.getKey() + ": \n");
			for (Entry<Map<String, Integer>, Integer> items : e.getValue().entrySet()) {
				for (Entry<String, Integer> item : items.getKey().entrySet()) {
//					if (items.getValue() > 0) {
						System.out.println("  " + item.getKey() + " Price: " + item.getValue() + " Qunatity: " + items.getValue() + " \n");
//					}
				}
			}
		}
	}
	
	
	
}
