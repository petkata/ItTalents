package computerStore;

public class ComputerStore {

	public static void main(String[] args) {
		Computer asusK555LF = new Computer(2014,666.98,true,953767,6359,"Free OS");
		/*asusK555LF.model = "ASUS K555L";
		asusK555LF.year = 2014;
		asusK555LF.price = 666.98;
		asusK555LF.isNotebook = true;
		asusK555LF.hardDiskMemory = 953767;
		asusK555LF.freeMemory = 6359;
		asusK555LF.operationSystem = "Free OS";*/
		
		Computer acerAspire = new Computer(2013,2301.49,476883,1236);
		/*acerAspire.model = "Aspire XC-603";
		acerAspire.year = 2013;
		acerAspire.price = 231.49;
		acerAspire.isNotebook = false;
		acerAspire.hardDiskMemory = 476883;
		acerAspire.freeMemory = 1236;
		acerAspire.operationSystem = "Linux";*/
		
		byte comparisonBetweenComps = (byte) asusK555LF.comparePrice(acerAspire);
		switch (comparisonBetweenComps) {
		case -1:
			System.out.println("The computer that we are comparing with is cheaper(the computer that is a parameter)");
			break;
		case 1:
			System.out.println("The computer that we are comparing with is cheaper(the computer which usese the method)");
			break;
		default:
			System.out.println("Both computers have the same price");
			break;
		}
	}
}
