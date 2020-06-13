package com.wipro.sales.bean;

import java.util.Date;

public class SalesReport {
	String salesId;
	Date salesDate;
	String productId,productName;
	int quantitySold;
	double productUnitPrice,salesPricePerUnit,profitAmount;
	public void setProductId(String productId) {
		this.productId=productId;
	}
	public void setProductName(String productName) {
		this.productName=productName;
	}
	public void setSalesId(String salesId) {
		this.salesId=salesId;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate=salesDate;
	}
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit=salesPricePerUnit;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice=productUnitPrice;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold=quantitySold;
	}
	public void setProfitAmount(double profitAmount) {
		this.profitAmount=profitAmount;
	}
	public String getProductId() {
		return this.productId;
	}
	public String getProductName() {
		return this.productName;
	}
	public String getSalesId() {
		return this.salesId;
	}
	public Date getSalesDate() {
		return this.salesDate;
	}
	public double getSalesPricePerUnit() {
		return this.salesPricePerUnit;
	}
	public double getProductUnitPrice() {
		return this.productUnitPrice;
	}
	public double getProfitAmount() {
		return this.profitAmount;
	}
	public int getQuantitySold() {
		return this.quantitySold;
	}
}
