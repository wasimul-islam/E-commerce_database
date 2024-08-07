package com.example.E_commerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product_attributes")
public class ProductAttributes extends Root {
	
	@Column
	private String attributeName;
	
	@Column
	private int attributeValue;
	
	@ManyToOne
	private Product product;

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public int getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(int attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
