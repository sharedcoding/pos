package com.jeet.model.db.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jeet.model.db.intf.DBCreater;

public class DBCreaterImpl extends DBCreater {

	public boolean createDBTables() {
		try {
			Connection conn = Connector.getConnection();
			Statement stm = conn.createStatement();
			stm.addBatch(createTableText("ItemTable"));
			stm.addBatch(createTableText("BillingTable"));
			stm.addBatch(createTableText("ItemBillingTable"));
			stm.addBatch(createTableText("BillNumTable"));
			stm.executeBatch();
			stm.close();
		} catch (SQLException e) {
			System.out.println("Exception in DBCreaterImpl.createDBTables()");
		}
		return true;
	}

	private String createTableText(String tableName) {
		String sql = null;
		switch (tableName) {
		case "ItemTable":
			sql = "CREATE TABLE "
					+ tableName
					+ " (itemId varchar(15), itemName varchar(70), price int, discount int, PRIMARY KEY(itemId))";
			break;
		case "BillingTable":
			sql = "CREATE TABLE "
					+ tableName
					+ " (billNum varchar(15), billData date, totalBill int, PRIMARY KEY (billNum))";
			break;
		case "ItemBillingTable":
			sql = "CREATE TABLE "
					+ tableName
					+ " (itemId varchar(15), billNum varchar(15), items int, PRIMARY KEY (itemId,billNum), FOREIGN KEY (itemId) REFERENCES ItemTable(itemId) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY(billNum) REFERENCES billingTable(billNum) ON DELETE CASCADE ON UPDATE CASCADE)";
			break;
		case "BillNumTable":
			sql = "CREATE TABLE " + tableName +"(billNum int DEFAULT 1)";

			break;
		}
		System.out.println("DBCreaterImpl.createTableText()" + sql);

		return sql;
	}

}
