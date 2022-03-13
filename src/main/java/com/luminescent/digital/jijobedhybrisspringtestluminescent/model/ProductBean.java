package com.luminescent.digital.jijobedhybrisspringtestluminescent.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductBean {
	
	private long id;
	
	 @NotNull
	 @NotEmpty
	 @Size(min=5, max=15, message="Field should be  5")
	private String productname;
	
	 @DecimalMin(value = "0.0", inclusive = false, message = "Digits plz")
	 @Digits(integer=1, fraction=1, message = "Digits plz")
	 @NotNull(message = "Digits plz")
	 @NotBlank(message = "Digits plz")
	 @NotEmpty(message = "Digits plz")
	private BigDecimal price;
	 @NotNull
	private String currency;
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
