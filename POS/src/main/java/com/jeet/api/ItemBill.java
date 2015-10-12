package com.jeet.api;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "bill", "item"})
@XmlRootElement(name = "itembill")
@Entity
public class ItemBill {

	@Id
	@GeneratedValue
	@XmlElement(required = true)
	protected int id;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BILL_NUMBER")
	@XmlElement(required = true)
	protected Bill bill;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BARCODE")
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
