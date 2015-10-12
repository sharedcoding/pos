package com.ims.model.bean;

public class BillNumRowData implements DataRow {

	private int billNum;

	public BillNumRowData(int billNum) {
		this.billNum = billNum;
	}

	public int getBillNum() {
		return billNum;
	}

	public void setBillNum(int billNum) {
		this.billNum = billNum;
	}

	public int getType() {
		return BILL_NUMBER_ROW_TYPE;
	}

}
