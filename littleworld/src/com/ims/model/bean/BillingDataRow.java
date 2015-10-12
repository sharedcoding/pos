package com.ims.model.bean;

public class BillingDataRow implements DataRow {

	private String billNum;
	
	private String date;
	private int totalBill;

	public BillingDataRow(String billNum, String date, int totalBill) {
		this.billNum = billNum;
		this.date = date;
		this.totalBill = totalBill;
	}

	public String getBillNum() {
		return billNum;
	}

	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}

	
	public int getType() {
		return BILLING_ROW_TYPE;
	}

}
