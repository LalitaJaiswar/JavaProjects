package com.wipro.sales.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Util {
	public static Connection getDBConnection() {
		Connection cn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		}
		catch(Exception e) {
			System.out.println("Unable to establsih a connection!"+e);
		}
		return cn;
	}
}
