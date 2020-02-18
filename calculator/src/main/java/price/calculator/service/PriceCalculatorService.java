package price.calculator.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		if (basePricesForProductType.size() == 1) {
			return basePricesForProductType.get(0);
		}
		basePricesForProductType.stream().forEach(bPrice -> {
			Map<String, Boolean> optionsMatched = new HashMap<>();
			for (Map.Entry<String, List<String>> option : bPrice.getOptions().entrySet()) {
				optionsMatched.put(option.getKey(), false);
			}
			bPrice.setOptionsMatched(optionsMatched);
		});
		return basePricesForProductType.stream().map((bPrice) -> {
			BasePrice basePrice = null;
			for (Map.Entry<String, String> option : cart.getOptions().entrySet()) {
				if (bPrice.getOptions().get(option.getKey()) != null && bPrice.getOptions().get(option.getKey()).contains(option.getValue())) {
					bPrice.getOptionsMatched().replace(option.getKey(), new Boolean(true));
				}
			}
			ArrayList<Boolean> optionsMatchedList = new ArrayList<Boolean>(bPrice.getOptionsMatched().values());
			if (!optionsMatchedList.contains(false)) {
				basePrice = bPrice;
			}
			return basePrice;
		}).filter((bPrice) -> bPrice != null).findAny().get();
	}

}
