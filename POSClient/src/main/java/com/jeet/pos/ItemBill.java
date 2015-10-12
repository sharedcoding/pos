package com.jeet.pos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "bill", "item"})
@XmlRootElement(name = "itembill")
public class ItemBill {

	@XmlElement(required = true)
	protected int id;
	
	
	@XmlElement(required = true)
	protected Bill bill;
	
	@XmlElement(required = true)
	protected Item item;

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}


}
