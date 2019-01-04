package com.target.myretail.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "currency_code" })
@Embeddable
public class CurrentPrice {

	@JsonProperty("value")
	private Float value;
	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("value")
	public Float getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(Float value) {
		this.value = value;
	}

	@JsonProperty("currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	@JsonProperty("currency_code")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("value", value).append("currencyCode", currencyCode).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(currencyCode).append(value).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof CurrentPrice) == false) {
			return false;
		}
		CurrentPrice rhs = ((CurrentPrice) other);
		return new EqualsBuilder().append(currencyCode, rhs.currencyCode).append(value, rhs.value).isEquals();
	}

}
