package crudbasic.test.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private Integer count;
	@Column
	private BigDecimal price;

	public Product() {
		super();
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

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

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

	public BigDecimal getPrice() {
		return price;
	}

}
