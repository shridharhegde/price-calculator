package price.calculator.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import price.calculator.exception.PriceCalculatorExcetion;

/**
 * Service class to read file and return java objects
 * 
 * @param <T>
 *
 */
public class FileReaderService<T> implements IFileReaderService {

	ObjectMapper objectMapper = new ObjectMapper();

	// Read File from the path specified and convert to specified model
	@SuppressWarnings("unchecked")
	public List<T> readFileData(String filePath) {
		if (filePath != null && !filePath.isEmpty()) {
			File file = new File(filePath);
			try {
				List<T> list = objectMapper.readValue(file, new TypeReference<List<T>>() {
				});
				if (list != null && list.size() > 0) {
					return list;
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
