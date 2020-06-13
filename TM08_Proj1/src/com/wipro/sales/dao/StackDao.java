package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wipro.sales.util.DB_Util;
import com.wipro.sales.bean.Product;

public class StackDao {
	public void insertStock(Product sales) throws SQLException {
		Connection cn=DB_Util.getDBConnection();
		try {
			Statement st=cn.createStatement();
			String sql1="insert into TBL_STOCK values('"+sales.getProductId()+"','"+sales.getProductName()+"','"+sales.getQuantityOnHand()+"','"+sales.getProductUnitPrice()+"','"+sales.getReorderLevel()+"')";
			int row1=st.executeUpdate(sql1);
			if(row1>0)
				System.out.println("Insertion successful!");
		}
		catch(SQLException e) {
			System.out.println("Exception in stock insertion "+e.getMessage());
		}
	}
	public String generateProductId(String productName) throws SQLException {
		Connection cn=DB_Util.getDBConnection();
		String id=productName.substring(0,2);
		try {
			String sql2="Select SEQ_PRODUCT_ID.nextval from dual";
			Statement st=cn.prepareStatement(sql2);
			ResultSet rs=st.executeQuery(sql2);
			rs.next();
			int seq=Integer.parseInt(rs.getString(1));
			id=id+seq;		}
		catch(SQLException e) {
			System.out.println("Exception in  pid generation "+e);
		}
		return id;
		}
	public void updateStock(String productId,int soldQty) throws SQLException {
		Connection cn=DB_Util.getDBConnection();
		try {
			String sql3="Update tbl_stock set quantity_on_hand=quantity_on_hand-? where product_id=?";
			PreparedStatement st=cn.prepareStatement(sql3);
			st.setInt(1, soldQty);
			st.setString(2, productId);
			int row3=st.executeUpdate();
			if(row3>0)
				System.out.println("Updation successful!");
		}
		catch(SQLException e) {
			System.out.println("Exception in stock updation"+e.getMessage());
		}
	}
	public Product getStock(String productId) throws SQLException {
		Connection cn=DB_Util.getDBConnection();
		Statement st=cn.createStatement();
		Product p=new Product();
		try {
			String sql4="select * from tbl_stock where product_id=productId";
			ResultSet rs=st.executeQuery(sql4);
			p.setProductId(rs.getString(1));
			p.setProductName(rs.getString(2));
			p.seQuantityOnHand(rs.getInt(3));
			p.setProductUnitPrice(rs.getDouble(4));
			p.setReorderLevel(rs.getInt(5));
		}
		catch(Exception e) {
			System.out.println("Exception in fetching stock!");
			e.printStackTrace();
		}
		return p;
	}
	public String deleteStock(String productId) throws SQLException {
		Connection cn=DB_Util.getDBConnection();
		try {
			String sql5="delete from tbl_stock where product_id= ?";
			PreparedStatement st=cn.prepareStatement(sql5);
			st.setString(1, productId);
			int n=st.executeUpdate();
			if(n>0) 
			{
				return("Deleted");
			}
		}
		catch(Exception e) {
			System.out.println("Exception in deleting stock!");
			e.printStackTrace();
		}
		return "Unable to delete";
	}
}
