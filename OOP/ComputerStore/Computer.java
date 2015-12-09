
public class Computer {
	
	String model;
	// manufacture year
	short year;
	// price in dollars
	double price;
	boolean isNotebook;
	// hard disk capacity in MB
	int hardDiskMemory;
	// available RAM in MB
	int freeMemory;
	String operationSystem;
	
	String changeOperationSystem(String newOperationSystem){
		switch (newOperationSystem) {
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
