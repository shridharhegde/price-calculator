package price.calculator.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model holds data for base price of a paroduct type
 *
 */
public class BasePrice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "product-type")
	private String productType;

	@JsonProperty(value = "options")
	private Map<String, List<String>> options;

	@JsonProperty(value = "base-price")
	private Long basePrice;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Map<String, List<String>> getOptions() {
		return options;
	}

	public void setOptions(Map<String, List<String>> options) {
		this.options = options;
	}

	public Long getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Long basePrice) {
		this.basePrice = basePrice;
	}

}
