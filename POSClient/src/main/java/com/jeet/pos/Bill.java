package com.jeet.pos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "billNumber", "billDate", "totalBill",
		"itemBill"})
@XmlRootElement(name = "bill")
public class Bill {

	@XmlElement(required = true)
	protected int billNumber;

	@XmlElement(required = true)
	protected Date billDate;

	@XmlElement(required = true)
	protected int totalBill;

	@XmlElement(required = true)
	protected Set<ItemBill> itemBill = new HashSet<ItemBill>();

	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	
	public void addItemBill(ItemBill iBill){
		itemBill.add(iBill);
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}

	public Set<ItemBill> getItemBill() {
		return itemBill;
	}
	
	
}
