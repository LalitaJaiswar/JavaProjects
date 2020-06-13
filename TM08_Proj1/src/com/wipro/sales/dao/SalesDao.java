package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.wipro.sales.bean.Sales;
import com.wipro.sales.util.DB_Util;
import com.wipro.sales.bean.SalesReport;

public class SalesDao {
	public int insertSales(Sales sales) {
		sales.getSalesId();
		int row=0;
		Connection cn=DB_Util.getDBConnection();
		Date date=sales.getSalesDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query="insert into tbl_sales values('"+sales.getSalesId()+"',to_date('" + sdf.format(date) + "','yyyy-mm-dd hh24:mi:ss'),'"+sales.getProductId()+"','"+sales.getQuantitySold()+"','"+sales.getSalesPricePerUnit()+"')";
		
		try {	
		Statement st=cn.createStatement();
		row=st.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println("Exception occured in insertSale in SaleDao! "+e.getMessage());
		}
		return row;
	}
	public String generateSalesId(Date salesDate) throws SQLException {
		Connection cn=DB_Util.getDBConnection();
		Statement st=cn.createStatement();
		int len=salesDate.toString().length();
		String id=salesDate.toString().substring(len-2,len);
		try {
			String sql="Select SEQ_SALES_ID.nextval from dual";
			ResultSet rs=st.executeQuery(sql);
			rs.next();
			int seq=rs.getInt(1);
			id=id+seq;
		}
		catch(SQLException e) {
			System.out.println("Exception in sales id generation"+e.getMessage());
		}
		return id;
		}
	public ArrayList<SalesReport> getSalesReport() throws SQLException{
		Connection cn=DB_Util.getDBConnection();
		Statement st=cn.createStatement();
		ArrayList<SalesReport> asr=new ArrayList<SalesReport>();
		try {
			String q2="Select * from V_SALES_REPORT";
			ResultSet rs=st.executeQuery(q2);
			while(rs.next()) {
				SalesReport sr=new SalesReport();
				sr.setSalesId(rs.getString(1));
				sr.setSalesDate(rs.getDate(2));
				sr.setSalesPricePerUnit(rs.getDouble(3));
				sr.setProductId(rs.getString(4));
				sr.setProductName(rs.getString(5));
				sr.setQuantitySold(rs.getInt(6));
				sr.setProductUnitPrice(rs.getDouble(7));
				sr.setProfitAmount(rs.getDouble(8));
				asr.add(sr);
			}
		}
		catch(SQLException e) {
			System.out.println("Exception in sales generation");
			e.printStackTrace();
		}
		return asr;
	}
}
