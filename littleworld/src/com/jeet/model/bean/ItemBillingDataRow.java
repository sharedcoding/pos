package com.jeet.model.bean;

public class ItemBillingDataRow implements DataRow {
	private String itemId;
	private String billnum;
	private int items;

	public ItemBillingDataRow(String itemId, String billnum, int items) {
		this.itemId = itemId;
		this.billnum = billnum;
		this.items = items;
	}

	public int getType() {
		return ITEM_BILLING_ROW_TYPE;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getBillnum() {
		return billnum;
	}

	public void setBillnum(String billnum) {
		this.billnum = billnum;
	}
	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

}
