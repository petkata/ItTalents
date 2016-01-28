package utilities;


import shop.Product;
import shop.QuantityProduct;
import shop.WeightProduct;

public interface IProductAddable {

	default void addQuantityToExistingProduct(Product[] list, Product product, double quantity){
		
		for (int i = 0; i < list.length; i++) {
			if (list[i] == null) {
				continue;
			}
			if (list[i].getName().equals(product.getName())) {
				list[i].setProductQuantity(quantity);
				if (product instanceof WeightProduct) {
					System.out.print(" " + quantity +" kilo"+((quantity<2)? " ": "s ")+ "of " + product.getName() + " added");
				}
				if (product instanceof QuantityProduct) {
					System.out.print(" " + quantity + " " + product.getName()+ ((quantity<2)? " ": "s ") + "added");
				}
				return;
			}
		}
	}
}
