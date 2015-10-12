package com.jeet.api;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "item", "supplier", "quantity",
		"supplyDate" })
@XmlRootElement(name = "itemsupplier")
@Entity
public class ItemSupplier {

	@Id
	@GeneratedValue
	@Column(name = "ITEM_SUPPLIER_ID")
	@XmlElement(required = true)
	protected int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "BARCODE")
	@XmlElement(required = true)
	private Item item;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "SUPPLIER_ID")
	@XmlElement(required = true)
	private Supplier supplier;
	
	@XmlElement(required = true)
	private int quantity;

	@XmlElement(required = true)
	@Column(name = "SUPPLY_DATE")
	@Temporal(TemporalType.DATE)
	private Date supplyDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getSupplyDate() {
		return supplyDate;
	}

	public void setSupplyDate(Date supplyDate) {
		this.supplyDate = supplyDate;
	}

}
