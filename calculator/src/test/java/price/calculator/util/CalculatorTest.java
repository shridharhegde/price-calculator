package price.calculator.util;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	private static Double basePrice = 3800.0;
	private static Double artistMarkUp = 20.0;
	private static Integer quantity = 1;
	private static Calculator calculator = new Calculator();

	@Test
	public void testCalculateItemPrice() {
		Assert.assertEquals(new Double(4560.0), calculator.calculateItemPrice(basePrice, artistMarkUp, quantity));
	}

}
