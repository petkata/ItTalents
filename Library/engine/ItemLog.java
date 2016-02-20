package engine;

import java.time.LocalTime;

public class ItemLog implements Comparable<ItemLog>{

	private String client;
	private LocalTime timeOFRent;
	private LocalTime dueTime;
	
	protected ItemLog(String client,int period, LocalTime timeOFRent) {
		this.client = client;
		this.timeOFRent = timeOFRent;
		this.dueTime = this.timeOFRent.plusSeconds(period);
	}

	@Override
	public int compareTo(ItemLog o) {
		return this.timeOFRent.compareTo(o.timeOFRent);
	}

	protected String getClient() {
		return client;
	}

	protected LocalTime getTimeOFRent() {
		return timeOFRent;
	}
	
	
}
