package com.bpm.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBO {

	private static String URI = "jdbc:mysql://localhost:3306/bpm";
	private static String ACCOUNT = "root";
	private static String PASSWORD = "123456";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URI, ACCOUNT, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
