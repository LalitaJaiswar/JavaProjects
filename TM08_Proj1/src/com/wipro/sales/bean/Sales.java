package com.wipro.sales.bean;

import java.util.Date;

public class Sales {
	String salesId;
	Date salesDate;
	String productId;
	int quantitySold;
	double salesPricePerUnit;
	public void setSalesId(String salesId) {
		this.salesId=salesId;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate=salesDate;
	}
	public void setProductId(String productId) {
		this.productId=productId;
	}
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit=salesPricePerUnit;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold=quantitySold;
	}
	public String getSalesId() {
		return this.salesId;
	}
	public Date getSalesDate() {
		return this.salesDate;
	}
	public String getProductId() {
		return this.productId;
	}
	public double getSalesPricePerUnit() {
		return this.salesPricePerUnit;
	}
	public int getQuantitySold(){
		return this.quantitySold;
	}
}
