package crudbasic.test.rest.api;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductApi {

	@JsonProperty
	private Integer id;
	@NotNull
	@JsonProperty
	private String name;
	@NotNull
	@JsonProperty
	private String description;
	@NotNull
	@JsonProperty
	private Integer count;
	@NotNull
	@JsonProperty
	private BigDecimal price;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getCount() {
		return count;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
