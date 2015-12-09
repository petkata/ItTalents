
public class ComputerStore {

	public static void main(String[] args) {
		Computer asusK555LF = new Computer();
		asusK555LF.model = "ASUS K555L";
		asusK555LF.year = 2014;
		asusK555LF.price = 666.98;
		asusK555LF.isNotebook = true;
		asusK555LF.hardDiskMemory = 953767;
		asusK555LF.freeMemory = 6359;
		asusK555LF.operationSystem = "Free OS";
		
		Computer acerAspire = new Computer();
		acerAspire.model = "Aspire XC-603";
		acerAspire.year = 2013;
		acerAspire.price = 231.49;
		acerAspire.isNotebook = false;
		acerAspire.hardDiskMemory = 476883;
		acerAspire.freeMemory = 1236;
		acerAspire.operationSystem = "Linux";

		acerAspire.useMemory(100);
		
		asusK555LF.changeOperationSystem("Windows");
		
		printSpecs(acerAspire);
		printSpecs(asusK555LF);
	}
	
	static void printSpecs(Computer computer){
		System.out.println("Model: " + computer.model + "\n"
				+ "Manufacture year: " + computer.year + "\n"
				+ "Price: " + computer.price + "$\n"
				+ "Configuration type: " + ((computer.isNotebook)? "Laptop": "PC" ) + "\n"
				+ "Hard disk memory(GB): " + sellersTrickCustomersWithMemory(computer.hardDiskMemory) +"\n"
				+ "Free memory(GB): " + (computer.freeMemory/1024f) + "\n"
				+ "Operating system: " + computer.operationSystem +"\n"
				);
	}

	private static long sellersTrickCustomersWithMemory(int hardDiskMemory) {
		long bytes = hardDiskMemory * 1048576L;
		long lieNumber = 1_000_000_000L;
		return bytes / lieNumber;
	}
}
