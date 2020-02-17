package price.calculator;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

		IFileReaderService fileReaderService = new FileReaderService<Object>();
		IPriceCalculatorService priceCalculatorService = new PriceCalculatorService();
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Read Cart file and map to Cart Model
		List<Cart> carts = objectMapper.convertValue(fileReaderService.readFileData(args[0]),
				new TypeReference<List<Cart>>() {
		});

		//Read Base Price file and map to BasePrice Model
		List<BasePrice> basePrices = objectMapper.convertValue(fileReaderService.readFileData(args[1]),
				new TypeReference<List<BasePrice>>() {
		});

		if (carts != null && carts.size() > 0 && basePrices != null && basePrices.size() > 0) {
			Double totalCartPrice = priceCalculatorService.calculateCartPrice(carts, basePrices);
			System.out.println("\nTotal Cart Price - " + totalCartPrice.intValue());
		} else {
			throw new PriceCalculatorExcetion("Cart of Base price json can not be empty", new RuntimeException());
		}

	}
}
