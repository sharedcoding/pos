package com.ims.model.db.procedure;

import java.sql.Connection;
import java.sql.Statement;

import com.ims.model.db.impl.Connector;

public class MyStoredProcedures {
	static String addOrUpdateItemProcedure = "create procedure addItemsProcedure(in p_itemId varchar(15), in p_itemName varchar(70), in p_price int, in p_discount int) "
			+ "BEGIN "
			+ "DECLARE tmpItemId varchar(15);"
			+ "select itemId into tmpItemId from Itemtable where (itemId = p_itemId);"
			+ "IF tmpItemId is NULL THEN "
			+ "INSERT INTO ItemTable VALUES(p_itemId, p_itemName, p_price, p_discount);"
			+ "ELSE "
			+ "UPDATE Itemtable SET itemName=p_itemName, price=p_price, discount=p_discount WHERE itemId = p_itemId;"
			+ "END IF;"
			+ "END";
	static String addOrUpdateBillProcedure = "create procedure addBillProcedure(in billNum varchar(15), in billData date, in totalBill int) "
			+ "BEGIN "
			+ " DECLARE tempBillNum varchar(15);"
			+ " SELECT billNum into tempBillNum from billingTable where (billNum = billNum); "
			+ "IF tempBillNum is NULL THEN "
			+ "INSERT INTO billingTable values(billNum, billDate, totalBill);"
			+ "ELSE "
			+ "UPDATE billingTable set billDate=billdate, totalBill=totalBill WHERE billNum = billNum;"
			+ "END IF;"
			+ "END";
	static String addOrUpdateItemBillProcedure = "create procedure addItemBillProcedure(in itemId varchar(15), in billNum varchar(15), in items int) "
			+ "BEGIN "
			+ "DECLARE tmpItemId varchar(15); "
			+ "SELECT itemId into tmpItemId from ItemBillingTable where (itemId=itemId AND billNum=billNum);"
			+ "IF tmpItemId is NULL THEN "
			+ "INSERT INTO ItemBillingTable VALUES(itemId, billNum, items); "
			+ "ELSE "
			+ "UPDATE ItemBillingTable set itemId=itemId, billNum=billNum, items=items WHERE itemId=itemId AND billNum=billNum;"
			+ "END IF; "
			+ "END";
	
	static String updateBillNumberProcedure = "create procedure updateBillNumProdcedure()"
			+ "BEGIN " 
			+ "DECLARE tempBillNum int;"
			+ "DECLARE tempIncrementedBillNum int;"
			+ "SELECT billNum into tempBillNum from BillNumTable;"
			+ "SET tempIncrementedBillNum = tempBillNum + 1;"
			+ "UPDATE BillNumTable set billNum=tempIncrementedBillNum WHERE billNum = tempBillNum;"
			+ "END";
	
	static String dropItemProcedure = "DROP procedure addItemsProcedure;";
	static String dropBillProcedure= "DROP procedure addBillProcedure;";
	static String dropItemBillProcedure= "DROP procedure addItemBillProcedure;";
	static String dropUpdateBillNumOrocedure = "DROP procedure updateBillNumProdcedure;";
	
	public static boolean createAllProcedures() {
		try {
			Connection conn = Connector.getConnection();
			Statement stm = conn.createStatement();
			stm.addBatch(addOrUpdateItemProcedure);
			stm.addBatch(addOrUpdateBillProcedure);
			stm.addBatch(addOrUpdateItemBillProcedure);
			stm.addBatch(updateBillNumberProcedure);
			stm.executeBatch();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MyStoredProcedures.createAllProcedures()");
			return false;
		}
		return true;
	}
	
	public static boolean dropAllProcedures(){
		try {
			Connection conn = Connector.getConnection();
			Statement stm = conn.createStatement();
			stm.addBatch(dropItemProcedure);
			stm.addBatch(dropBillProcedure);
			stm.addBatch(dropItemBillProcedure);
			stm.addBatch(dropUpdateBillNumOrocedure);
			stm.executeBatch();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MyStoredProcedures.dropAllProcedures()");
			return false;
		}
		return true;
	}

}
