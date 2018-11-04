package com.not4win.electro.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ProductResponse {
	@SerializedName("product")
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
