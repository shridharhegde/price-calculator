package price.calculator.util;

public class Calculator {

	// Function calculates the price for particular cart item
	public Double calculateItemPrice(Double basePrice, Double artistMarkUp, Integer quantity) {
		Double itemPrice = 0.0;
		itemPrice = (basePrice + Math.round((basePrice * (artistMarkUp / 100)))) * quantity;
		return itemPrice;
	}

}
