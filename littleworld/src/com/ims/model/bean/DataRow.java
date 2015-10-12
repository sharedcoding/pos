package com.ims.model.bean;

public interface DataRow {
	
	public static final int ITEM_ROW_TYPE = 1;
	public static final int BILLING_ROW_TYPE = 2;
	public static final int ITEM_BILLING_ROW_TYPE = 3;
	public static final int CUSTOMER_ROW_TYPE = 4;
	public static final int ORDER_ROW_TYPE = 5;
	public static final int POINTS_ROW_TYPE = 6;
	public static final int BILL_NUMBER_ROW_TYPE = 7;
	
	public int getType();

}
