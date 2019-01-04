package com.target.myretail.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "current_price" })
@Entity
public class Product {

	@Id
	@JsonProperty("id")
	private Integer productID;
	@JsonProperty("current_price")
	private CurrentPrice currentPrice;

	@JsonProperty("id")
	public Integer getproductID() {
		return productID;
	}

	@JsonProperty("id")
	public void setproductID(Integer productID) {
		this.productID = productID;
	}

	@JsonProperty("current_price")
	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}

	@JsonProperty("current_price")
	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("productID", productID).append("currentPrice", currentPrice).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(productID).append(currentPrice).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Product) == false) {
			return false;
		}
		Product rhs = ((Product) other);
		return new EqualsBuilder().append(productID, rhs.productID).append(currentPrice, rhs.currentPrice).isEquals();
	}

}