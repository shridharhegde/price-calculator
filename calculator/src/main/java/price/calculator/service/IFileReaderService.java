package price.calculator.service;

import java.util.List;

import price.calculator.model.BasePrice;
import price.calculator.model.Cart;

public interface IFileReaderService {
	public List<Cart> getCartData(String cartFilePath);

	public List<BasePrice> getBasePriceData(String basePriceFilePath);
}
