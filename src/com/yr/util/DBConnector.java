package com.yr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	public static Connection getConnect() throws Exception {
		String user = "user02";
		String password = "user02";
		String url = "jdbc:oracle:thin:@211.238.142.44:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	public static void disConnect(Connection con, PreparedStatement st) throws Exception {
		con.close();
		st.close();
	}
	
	public static void disConnect(Connection con, PreparedStatement st, ResultSet rs) throws Exception {
		DBConnector.disConnect(con, st);
		rs.close();
	}
}
