package com.policy.dbcon;

import java.sql.*;
import java.util.Properties;

public class DBConnection {
	// JDBC Driver Name & Database URL
	static final String JDBC_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/db_licpolicy";
	// JDBC Database Credentials
	static final String JDBC_USER = "root";
	static final String JDBC_PASS = "";

	public static Connection getConnection() throws SQLException {
		Connection connObj = null;
		try {
			Properties props = new Properties();
			props.setProperty("user", JDBC_USER);
			props.setProperty("password", JDBC_PASS);
			connObj = DriverManager.getConnection(JDBC_DB_URL, props);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("couldn't connect!");
		}
		return connObj;
	}
}
