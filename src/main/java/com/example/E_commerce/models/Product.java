package com.example.E_commerce.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product extends Root {
	
	@Column
	private String name;
	
	
	@ManyToOne
	private SubCategory subCategory;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name="attribute_id", referencedColumnName="id")
	List<ProductAttributes> productAttributeList;

	@Column
	private int price;
	
	@Column 
	private int discount;
	
	@Column
	private int stockCount;
	
	public List<ProductAttributes> getProductAttributeList() {
		return productAttributeList;
	}

	public void setProductAttributeList(List<ProductAttributes> productAttributeList) {
		this.productAttributeList = productAttributeList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	
}
