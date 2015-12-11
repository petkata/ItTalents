package computerStore;

public class Computer {
	
	private String model;
	// manufacture year
	private short year;
	// price in dollars
	private double price;
	private boolean isNotebook;
	// hard disk capacity in MB
	private double hardDiskMemory;
	// available RAM in MB
	private double freeMemory;
	private String operationSystem;
	
	Computer(){
		this.isNotebook = false;
		this.operationSystem = "Win XP";
	}
	Computer(int year, double price, double hardDiskMemory, double freeMemory){
		this();
		this.year = (short) year;
		this.price = price;
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
	}
	Computer(int year, double price,boolean isNotebook, double hardDiskMemory, double freeMemory,String operationSystem){
		this.year = (short) year;
		this.price = price;
		this.isNotebook = isNotebook;
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
		this.operationSystem = operationSystem;
	}
	
	int comparePrice(Computer computerToCompare){
		if (this.price > computerToCompare.price) {
			return -1;
		} 
		else if(this.price < computerToCompare.price){
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
	String changeOperationSystem(String newOperationSystem){
		switch (newOperationSystem) {
		case "Win XP":
		case "Windows":
		case "Linux":
		case "OS X":
		case "Free OS":
			operationSystem = newOperationSystem;
			return operationSystem;
		default:
			return operationSystem="No such OS!";
		}
	}
	
	void useMemory(double memory){
		if (memory > freeMemory) {
			System.out.println("Not enough free memory!");
			return;
		}
		if (memory < 0) {
			System.out.println("Invalid value for memory allocation");
			return;
		}
		freeMemory -= memory;
	}
	
}
