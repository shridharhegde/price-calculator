package price.calculator;

/**
 * Cart Price Calculator!
 *
 */
public class PriceCalculator {
	public static void main(String[] args) {
		PriceCalculator priceCalculator = new PriceCalculator();

		// Fail the application if both cart.json and base-prices.json are not passed in
		// command line arguments

		if (args.length < 2) {
			System.err.println("Please provide valid number of arguments");
			priceCalculator.exit(0);
		}
	}

	public void exit(int errorCode) {
		System.exit(errorCode);
	}
}
