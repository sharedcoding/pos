package com.jeet.model.bean;

public class ItemDataRow implements DataRow{
	
	private String itemCode;
	private String ItemName;
	private int price;
	private int discount;
	
	public ItemDataRow(String itemCode, String ItemName, int price, int discount){
		this.itemCode = itemCode;
		this.ItemName = ItemName;
		this.price = price;
		this.discount = discount;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getType() {
		return ITEM_ROW_TYPE;
	}

}
