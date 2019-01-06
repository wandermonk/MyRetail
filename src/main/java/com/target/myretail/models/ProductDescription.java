package com.target.myretail.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productDescription")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "product_desc" })
public class ProductDescription {

	@Id
	@JsonProperty("id")
	private ObjectId id;

	@Indexed(unique = true)
	@JsonProperty("id")
	private Integer productId;
	@JsonProperty("product_desc")
	private String productDesc;
	
	public ProductDescription(Integer productId, String productDesc) {
		super();
		this.productId = productId;
		this.productDesc = productDesc;
	}

	@JsonProperty("productId")
	public ObjectId getId() {
		return id;
	}

	@JsonProperty("productId")
	public void setId(ObjectId id) {
		this.id = id;
	}

	@JsonProperty("product_desc")
	public String getProductDesc() {
		return productDesc;
	}

	@JsonProperty("product_desc")
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("productDesc", productDesc)
				.append("productId", productId).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(productDesc).append(productId).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ProductDescription) == false) {
			return false;
		}
		ProductDescription rhs = ((ProductDescription) other);
		return new EqualsBuilder().append(id, rhs.id).append(productDesc, rhs.productDesc)
				.append(productId, rhs.productId).isEquals();
	}

	@JsonProperty("id")
	public Integer getProductId() {
		return productId;
	}

	@JsonProperty("id")
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}