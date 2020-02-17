package price.calculator;

import java.util.List;

import price.calculator.exception.PriceCalculatorExcetion;
import price.calculator.model.BasePrice;
import price.calculator.model.Cart;
import price.calculator.service.FileReaderService;
import price.calculator.service.IFileReaderService;
import price.calculator.service.IPriceCalculatorService;
import price.calculator.service.PriceCalculatorService;

/**
 * Cart Price Calculator!
 *
 */
public class PriceCalculator {
	public static void main(String[] args) {

		// Fail the application if both cart.json and base-prices.json are not passed in
		// command line arguments
		if (args.length < 2) {
			throw new PriceCalculatorExcetion("Invalid number of arguments", new RuntimeException());
		}
		IFileReaderService fileReaderService = new FileReaderService();
		IPriceCalculatorService priceCalculatorService = new PriceCalculatorService();
		List<Cart> carts = fileReaderService.getCartData(args[0]);
		List<BasePrice> basePrices = fileReaderService.getBasePriceData(args[1]);
		priceCalculatorService.calculateCartPrice(carts, basePrices);

	}
}
