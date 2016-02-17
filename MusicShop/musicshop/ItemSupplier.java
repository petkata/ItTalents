package musicshop;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ItemSupplier implements Serializable{

	private Map<String, Integer> nameAndTime;

	public ItemSupplier() {
		this.nameAndTime = new HashMap<>();
		
		this.nameAndTime.put("Viola", 7);
		
		this.nameAndTime.put("Contrabass", 13);

		this.nameAndTime.put("Tambourine", 3);
		
		this.nameAndTime.put("Tapan", 10);
		
		this.nameAndTime.put("Accordion", 15);

		this.nameAndTime.put("Clarinet", 7);
		
		this.nameAndTime.put("Trombone", 13);

		this.nameAndTime.put("Drums", 3);
		
		this.nameAndTime.put("Piano", 10);
		
		this.nameAndTime.put("Bass Guitar", 15);
	}
	
	Entry<String, Integer> getItemByName(String name){
		for (Entry<String, Integer> item : nameAndTime.entrySet()) {
			if (item.getKey().equals(name)) {
				return item;
			}
		}
		return null;
	}
	
	Integer getTimeByName(String name){
		for (Entry<String, Integer> item : nameAndTime.entrySet()) {
			if (item.getKey().equals(name)) {
				return item.getValue();
			}
		}
		return -1;
	}

}
