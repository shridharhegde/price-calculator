package price.calculator.service;

import java.util.List;

import price.calculator.model.BasePrice;
import price.calculator.model.Cart;

public interface IPriceCalculatorService {

	public Double calculateCartPrice(List<Cart> carts, List<BasePrice> basePrices);

}
