package com.ims.model.db.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Vector;

import com.ims.model.bean.BillNumRowData;
import com.ims.model.bean.BillingDataRow;
import com.ims.model.bean.DataRow;
import com.ims.model.bean.ItemDataRow;
import com.ims.model.db.intf.DBFinder;

public class DBFinderImpl extends DBFinder {

	public Vector<DataRow> executeSelect(int dataRowType, String whereCondition) {
		System.out.println("DBFinderImpl.executeSelect()" + dataRowType);
		Vector<DataRow> rows = null;
		String sql = null;
		switch (dataRowType) {
		case DataRow.ITEM_ROW_TYPE:
			sql = "select * from ItemTable " + whereCondition;
			System.out.println("DBFinderImpl.executeSelect()" + sql);
			rows = constructItemRowData(executeQuery(sql));
			break;
		case DataRow.BILLING_ROW_TYPE:
			sql = "select * from BillingTable " + whereCondition;
			rows = constractBillingRowData(executeQuery(sql));
			break;
		case DataRow.ITEM_BILLING_ROW_TYPE:
			sql = "select * from ItemBillingTable " + whereCondition;
			break;
		case DataRow.BILL_NUMBER_ROW_TYPE:
			sql = "select * from BillNumTable " + whereCondition;
			rows = constractBillNumRowData(executeQuery(sql));
			break;
			
		}
		return rows;
	}

	private ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			Connection conn = Connector.getConnection();
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(sql);

		} catch (SQLException e) {
		}
		return rs;
	}

	private Vector<DataRow> constructItemRowData(ResultSet rs) {
		Vector<DataRow> dataVec = null;
		try {
			if (rs != null) {
				dataVec = new Vector<DataRow>();
				while (rs.next()) {
					DataRow drow = new ItemDataRow(rs.getString(1),
							rs.getString(2), rs.getInt(3), rs.getInt(4));
					dataVec.add(drow);
				}
				rs.close();
				
			}
		} catch (SQLException e) {
		}
		return dataVec;
	}

	private Vector<DataRow> constractBillingRowData(ResultSet rs) {
		Vector<DataRow> dataVec = null;
		try {
			if (rs != null ) {
				dataVec = new Vector<DataRow>();
				while (rs.next()) {
					DataRow drow = new BillingDataRow(rs.getString(1), rs
							.getDate(2).toString(), rs.getInt(3));
					dataVec.add(drow);
				}
			}
		} catch (SQLException e) {
		}
		return dataVec;
	}
	
	private Vector<DataRow> constractBillNumRowData(ResultSet rs) {
		Vector<DataRow> dataVec = null;
		try {
			if (rs != null ) {
				dataVec = new Vector<DataRow>();
				while (rs.next()) {
					DataRow drow = new BillNumRowData(rs.getInt(1));
					dataVec.add(drow);
				}
			}
		} catch (SQLException e) {
		}
		return dataVec;
	}
}
