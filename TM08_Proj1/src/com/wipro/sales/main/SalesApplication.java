package com.wipro.sales.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.service.Administrator;

public class SalesApplication {

	public static void main(String[] args) throws SQLException, ParseException {
		Scanner sc=new Scanner(System.in);
		Administrator ad=new Administrator();
		while(true) {
			System.out.println("Main Menu\n--------------\n1. Insert Stock\n2. Delete Stock\n3. Insert Sales\n4. View Sales Report\n5.Exit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				sc.nextLine();
				Product sobj=new Product();
				String productName;
				int quantityOnHand,reorderLevel;;
				double productUnitPrice;
				System.out.println("Enter product name,quantityOnHand,productUnitPrice and reorderLevel:");
				productName=sc.nextLine();
				quantityOnHand=sc.nextInt();
				productUnitPrice=sc.nextDouble();
				reorderLevel=sc.nextInt();
				sobj.setProductName(productName);
				sobj.seQuantityOnHand(quantityOnHand);
				sobj.setProductUnitPrice(productUnitPrice);
				sobj.setReorderLevel(reorderLevel);
				ad.insertStock(sobj);
				break;
			case 2:
				sc.nextLine();
				System.out.println("Enter product id:");
				String pid=sc.nextLine();
				System.out.println(ad.deleteStock(pid));
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter Sales date(dd/mm/yyyy), product id,quantity sold and sales price per unit:");
				String productId;
				int quantitySold;
				double salesPricePerUnit;
				String sDate = sc.nextLine();  
			    Date salesDate = new SimpleDateFormat("dd/mm/yyyy").parse(sDate); 
				productId=sc.nextLine();
				quantitySold=sc.nextInt();
				salesPricePerUnit=sc.nextDouble();
				Sales saleobj=new Sales();
				saleobj.setSalesDate(salesDate);
				saleobj.setProductId(productId);
				saleobj.setQuantitySold(quantitySold);
				saleobj.setSalesPricePerUnit(salesPricePerUnit);
				System.out.println(ad.insertSales(saleobj));
				break;
			case 4:
				ArrayList<SalesReport> asr=ad.getSalesReport();
				Iterator<SalesReport> i=asr.iterator();
				System.out.println("Generating Sales Report:");
				System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s","SalesId","SalesDate","SalesPrice","QuantitySold","ProductId","ProductName","ProductUnitPrice","ProfitAmount");
				SalesReport obj=null;
				while(i.hasNext()) {
					obj=i.next();
					System.out.format("\n%-15s %-15s %-15f %-15d %-15s %-15s %-15f %-15f \n",obj.getSalesId(),obj.getSalesDate(),obj.getSalesPricePerUnit(),obj.getQuantitySold(),obj.getProductId(),obj.getProductName(),obj.getProductUnitPrice(),obj.getProfitAmount());
				}
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
		
			}
			
		}
	}

}
