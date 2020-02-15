package price.calculator.model;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model holds data for single cart
 *
 */
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "product-type")
	private String productType;

	@JsonProperty(value = "options")
	private Map<String, String> options;

	@JsonProperty(value = "artist-markup")
	private Integer artistMarkUp;

	@JsonProperty(value = "quantity")
	private Integer quantity;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	public void setOptions(Map<String, String> options) {
		this.options = options;
	}

	public Integer getArtistMarkUp() {
		return artistMarkUp;
	}

	public void setArtistMarkUp(Integer artistMarkUp) {
		this.artistMarkUp = artistMarkUp;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
