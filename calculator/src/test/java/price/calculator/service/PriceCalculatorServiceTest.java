package price.calculator.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import price.calculator.model.BasePrice;
import price.calculator.model.Cart;

public class PriceCalculatorServiceTest {

	private IPriceCalculatorService priceCalculatorService = new PriceCalculatorService();
	private List<Cart> carts = new ArrayList<>();
	private List<BasePrice> basePrices = new ArrayList<>();
	private ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		carts = objectMapper.readValue(new File("src/main/resources/cart.json"), new TypeReference<List<Cart>>() {
		});
		basePrices = objectMapper.readValue(new File("src/main/resources/basePrice.json"),
				new TypeReference<List<BasePrice>>() {
		});
	}

	@Test
	public void testTotalPrice() {
		Assert.assertEquals(new Double(9363), priceCalculatorService.calculateCartPrice(carts, basePrices));
	}

	@Test
	public void testTotalPriceNotMatchedData() throws JsonParseException, JsonMappingException, IOException {
		basePrices = objectMapper.readValue(new File("src/main/resources/basePriceWithoutProductType.json"),
				new TypeReference<List<BasePrice>>() {
		});
		Assert.assertEquals(new Double(0), priceCalculatorService.calculateCartPrice(carts, basePrices));
	}

	@After
	public void tearDown() {
		carts = new ArrayList<>();
		basePrices = new ArrayList<>();
	}

}
