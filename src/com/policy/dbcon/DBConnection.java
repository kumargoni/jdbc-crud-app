package com.policy.dbcon;

import java.sql.*;

public class DBConnection {
	public static Connection con = null;

	public Connection getConnection() {
		if (con != null) {
			System.out.println("Connection successful..!!");
			return con;
		} else {
			try {
				String url = "jdbc:mysql://localhost:3306/db_licpolicy";
				String user = "root";
				String password = "";
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException cnfe) {
				System.out.println(cnfe);
			} catch (SQLException sqe) {
				System.out.println(sqe);
			}
			return con;
		}
	}
}
