package price.calculator.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import price.calculator.exception.PriceCalculatorExcetion;
import price.calculator.model.BasePrice;
import price.calculator.model.Cart;

/**
 * Service class to read file and return java objects
 *
 */
public class FileReaderService implements IFileReaderService {

	ObjectMapper objectMapper = new ObjectMapper();

	public List<Cart> getCartData(String cartFilePath) {
		if (cartFilePath != null && !cartFilePath.isEmpty()) {
			File file = new File(cartFilePath);
			try {
				List<Cart> carts = objectMapper.readValue(file, new TypeReference<List<Cart>>() {
				});
				if (carts != null && carts.size() > 0) {
					return carts;
				}
			} catch (JsonParseException e) {
				throw new PriceCalculatorExcetion("Unable to parse json", e);
			} catch (JsonMappingException e) {
				throw new PriceCalculatorExcetion("Unable to map json to Cart", e);
			} catch (IOException e) {
				throw new PriceCalculatorExcetion("Something went wrong, please try with correct json file", e);
			}
		}
		return null;
	}

	public List<BasePrice> getBasePriceData(String basePriceFilePath) {
		if (basePriceFilePath != null && !basePriceFilePath.isEmpty()) {
			File file = new File(basePriceFilePath);
			try {
				List<BasePrice> basePrices = objectMapper.readValue(file, new TypeReference<List<BasePrice>>() {
				});
				if (basePrices != null && basePrices.size() > 0) {
					return basePrices;
				}
			} catch (JsonParseException e) {
				throw new PriceCalculatorExcetion("Unable to parse json", e);
			} catch (JsonMappingException e) {
				throw new PriceCalculatorExcetion("Unable to map json to Base Price", e);
			} catch (IOException e) {
				throw new PriceCalculatorExcetion("Something went wrong, please try with correct json file", e);
			}
		}
		return null;
	}

}
