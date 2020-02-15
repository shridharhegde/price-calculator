package price.calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Car Price Calculator Application.
 */
public class PriceCalculatorTest {

	private int errorCode;

	@Test
	public void testNumberOfArguments() {
		PriceCalculator.main(new String[] { "cart.json" });
		assertAbort();
	}

	private void assertAbort() {
		System.out.println(errorCode);
		Assert.assertEquals(0, errorCode);
	}
}
