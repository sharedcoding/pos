package com.jeet.model.db.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL = "jdbc:mysql://localhost/littleworld";
	public static final String USERNAME = "jatin";
	public static final String PASSWORD = "6432";

	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(MYSQL_URL, USERNAME,
						PASSWORD);
			} catch (Exception e) {
				System.out.println("Connector.getConnection()");
			}
		}
		return connection;
	}

	public static boolean closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
				return true;
			} catch (SQLException e) {
			}
		}
		return false;
	}
}
