package com.wipro.sales.bean;

public class Product {
	String productId,productName;
	int quantityOnHand;
	double productUnitPrice;
	int reorderLevel;
	public void setProductId(String productId) {
		this.productId=productId;
	}
	public void setProductName(String productName) {
		this.productName=productName;
	}
	public void seQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand=quantityOnHand;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice=productUnitPrice;
	}
	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel=reorderLevel;
	}
	public String getProductId() {
		return this.productId;
	}
	public String getProductName() {
		return this.productName;
	}
	public int getQuantityOnHand() {
		return this.quantityOnHand;
	}
	public double getProductUnitPrice() {
		return this.productUnitPrice;
	}
	public int getReorderLevel() {
		return this.reorderLevel;
	}
}
