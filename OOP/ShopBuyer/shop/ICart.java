package shop;

public interface ICart {
	
	
	default void addToCartWeightedProduct(Shop shop, Product product, double weightToBuy) {
		for (int i = 0; i < shop.getListOfProducts().length; i++) {
			if (shop.getListOfProducts()[i] == null) {
				continue;
			}
			if (shop.getListOfProducts()[i].equals(product)) {
				if (shop.getListOfProducts()[i] instanceof WeightProduct) {
					((WeightProduct)shop.getListOfProducts()[i])
							.setWeight(((WeightProduct)shop.getListOfProducts()[i]).getWeight() - weightToBuy);
				}
			}
		}
	}
	
	default void addToCartQuantityProduct(Shop shop, Product product, double quantity) {
		int pieces = (int) Math.round(quantity);
		for (int i = 0; i < shop.getListOfProducts().length; i++) {
			if (shop.getListOfProducts()[i] == null) {
				continue;
			}
			if (shop.getListOfProducts()[i].equals(product)) {
				if (shop.getListOfProducts()[i] instanceof QuantityProduct) {
					((QuantityProduct)shop.getListOfProducts()[i])
							.setQuantity(((QuantityProduct)shop.getListOfProducts()[i]).getQuantity() - pieces);
				}
			}
		}
	}

	default void removeFromCartQuantityProduct(Shop shop, Product product, int quantity) {
		for (int i = 0; i < shop.getListOfProducts().length; i++) {
			if (shop.getListOfProducts()[i] == null) {
				continue;
			}
			if (shop.getListOfProducts()[i].equals(product)) {
				if (shop.getListOfProducts()[i] instanceof QuantityProduct) {
					((QuantityProduct)shop.getListOfProducts()[i])
							.setQuantity(((QuantityProduct)shop.getListOfProducts()[i]).getQuantity() + (int) Math.round(quantity)); //((QuantityProduct)product).getQuantity()
				}
			}
		}
	}
	
	default void removeFromCartWeightProduct(Shop shop, Product product, double weight) {
		for (int i = 0; i < shop.getListOfProducts().length; i++) {
			if (shop.getListOfProducts()[i] == null) {
				continue;
			}
			if (shop.getListOfProducts()[i].equals(product)) {
				if (shop.getListOfProducts()[i] instanceof WeightProduct) {
					((WeightProduct)shop.getListOfProducts()[i])
							.setWeight(((WeightProduct)shop.getListOfProducts()[i]).getWeight() + weight); // ((WeightProduct)product).getWeight()
				}
			}
		}
	}
}
