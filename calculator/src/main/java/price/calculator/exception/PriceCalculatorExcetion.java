package price.calculator.exception;

/**
 * Generic exception class
 *
 */
public class PriceCalculatorExcetion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PriceCalculatorExcetion(String message, Exception exception) {
		super(message);
		System.out.println(message);
		exception.printStackTrace();
	}
}
