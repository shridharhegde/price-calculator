package price.calculator.service;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import price.calculator.exception.PriceCalculatorExcetion;

public class FileReaderServiceTest {

	private IFileReaderService fileReaderService = new FileReaderService<Object>();
	private static String cartFilePath = "src/main/resources/cart.json";

	@Test
	public void testFileReadWithNullPath() {
		Assert.assertNull(fileReaderService.readFileData(null));
	}

	@Test
	public void testFileReadWithPath() {
		Assert.assertEquals(2, fileReaderService.readFileData(cartFilePath).size());
	}

	@Test(expected = PriceCalculatorExcetion.class)
	public void testFileWithWrongFilePath() {
		fileReaderService.readFileData("cart.json").size();
	}
}
