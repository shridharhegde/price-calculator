package price.calculator;

import org.junit.Test;

import price.calculator.exception.PriceCalculatorExcetion;

/**
 * Unit test for Car Price Calculator Application.
 */
public class PriceCalculatorTest {

	@Test(expected = PriceCalculatorExcetion.class)
	public void testInvalidNumberOfArguments() {
		PriceCalculator.main(new String[] { "cart.json" });
	}

}
