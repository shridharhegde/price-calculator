package price.calculator.service;

import java.util.List;
import java.util.stream.Collectors;

import price.calculator.model.BasePrice;
import price.calculator.model.Cart;
import price.calculator.util.Calculator;

public class PriceCalculatorService implements IPriceCalculatorService {

	private Calculator calculator = new Calculator();

	// This function displays price for each item in the cart and returns total cart
	// price
	public Double calculateCartPrice(List<Cart> carts, List<BasePrice> basePrices) {
		Double totalPrice = 0.0;
		try {
			totalPrice = carts.stream().map((cart) -> {
				BasePrice basePrice = findBasePrice(cart, basePrices);
				Double price = calculator.calculateItemPrice(Double.valueOf(basePrice.getBasePrice()),
						Double.valueOf(cart.getArtistMarkUp()), cart.getQuantity());
				System.out.println("Product Type - " + cart.getProductType() + "\n" + "Price - " + price.intValue());
				return price;
			}).reduce(Double::sum).get();
			return totalPrice;
		} catch (Exception e) {
			return totalPrice;
		}
	}

	// Returns base price of a particular product type with matched options
	private BasePrice findBasePrice(Cart cart, List<BasePrice> basePrices) {
		List<BasePrice> basePricesForProductType = basePrices.stream()
				.filter(bPrice -> bPrice.getProductType().equalsIgnoreCase(cart.getProductType()))
				.collect(Collectors.toList());
		return basePricesForProductType.stream().map((bPrice) -> {
			BasePrice basePrice = null;
			if (cart.getOptions().entrySet().stream()
					.filter((option) -> (bPrice.getOptions().get(option.getKey()).contains(option.getValue())))
					.findAny().isPresent()) {
				basePrice = bPrice;
			}
			return basePrice;
		}).findAny().get();
	}

}
