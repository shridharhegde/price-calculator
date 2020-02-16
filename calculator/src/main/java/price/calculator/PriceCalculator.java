package price.calculator;

import price.calculator.exception.PriceCalculatorExcetion;

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

	}
}
