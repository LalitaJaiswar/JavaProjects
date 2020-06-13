package com.wipro.sales.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.dao.StackDao;
import com.wipro.sales.util.DB_Util;

public class Administrator {
	public String insertStock(Product stockobj) throws SQLException {
		if(stockobj!=null) {
			if(stockobj.getProductName().length()>=2) {
				StackDao sd=new StackDao();
				String pid=sd.generateProductId(stockobj.getProductName());
				stockobj.setProductId(pid);
				sd.insertStock(stockobj);
				return pid;
			}
		}
		return "Data not valid for insertion!";
	}
	public String deleteStock(String productId) throws SQLException {
		StackDao sd=new StackDao();
		return(sd.deleteStock(productId));
	}
	public String insertSales(Sales salesobj) {
		if(salesobj!=null) {
			Connection cn=DB_Util.getDBConnection();
			try {
			String pid=salesobj.getProductId();
			String sql="Select product_id,quantity_on_hand from tbl_stock where product_id=?";
			PreparedStatement st=cn.prepareStatement(sql);
			st.setString(1, pid);
			ResultSet rs=st.executeQuery();
			if(!rs.next())
				return "Unknown product for insertion!";
			else {
				
				if(rs.getInt(2)<salesobj.getQuantitySold())
					return "Not enoungh stock for sale";
				else {
					if(salesobj.getSalesDate().before(new Date()))
						return "Invalid Date";
					else {
						SalesDao sd2=new SalesDao();
						String sid=sd2.generateSalesId(salesobj.getSalesDate());
						salesobj.setSalesId(sid);
						int row=sd2.insertSales(salesobj);
						StackDao sdo=new StackDao();
						sdo.updateStock(salesobj.getProductId(), salesobj.getQuantitySold());
						if(row<0)
							return("Error");
					}
				}
			}
			}
			catch(Exception e) {
				System.out.println("Exception occured in admin sale");
				e.printStackTrace();
			}
			return("Sale completed!");
		}
		else
			return "Invalid Product";
	}
	public ArrayList<SalesReport> getSalesReport() throws SQLException{
		SalesDao sd4=new SalesDao();
		return sd4.getSalesReport();
	}
}
