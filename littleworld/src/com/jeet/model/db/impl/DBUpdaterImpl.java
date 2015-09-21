package com.jeet.model.db.impl;

import java.sql.SQLException;
import java.util.Vector;

import com.jeet.model.bean.DataRow;
import com.jeet.model.bean.ItemDataRow;
import com.jeet.model.db.intf.DBUpdater;
import com.mysql.jdbc.CallableStatement;

public class DBUpdaterImpl extends DBUpdater {

	public int executeUpdate(Vector<DataRow> dataRow) {
		for (int i = 0; i < dataRow.size(); i++) {
			switch (dataRow.elementAt(i).getType()) {
			case DataRow.ITEM_ROW_TYPE:
				System.out.println("DBUpdaterImpl.executeUpdate()");
				updateItemtable((ItemDataRow) dataRow.elementAt(i));
				break;
			case DataRow.BILL_NUMBER_ROW_TYPE:
				updateBillNumTable();
				break;
			}
		}

		return 0;
	}

	private void updateItemtable(ItemDataRow dRow) {
		try {
			CallableStatement stm = (CallableStatement) Connector
					.getConnection().prepareCall(
							"{call addItemsProcedure(?,?,?,?)}");
			stm.setString(1, dRow.getItemCode());
			stm.setString(2, dRow.getItemName());
			stm.setInt(3, dRow.getPrice());
			stm.setInt(4, dRow.getDiscount());
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DBUpdaterImpl.updateItemtable()");
		}
	}

	private void updateBillNumTable() {
		try {
			CallableStatement stm = (CallableStatement) Connector
					.getConnection().prepareCall(
							"{call updateBillNumProdcedure()}");
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DBUpdaterImpl.updateItemtable()");
		}

	}
}
