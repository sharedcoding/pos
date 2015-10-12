package com.jeet.api;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@XmlType(name = "", propOrder = { "id", "offer", "item", "quantity" })
@XmlRootElement(name = "itemoffer")
@Entity
public class ItemOffer {
	

	@Id
    @GeneratedValue
    @Column(name = "ITEM_OFFER_ID")
	@XmlElement(required = true)
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="OFFER_ID")
	@XmlElement(required = true)
	protected Offer offer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BARCODE")
	@XmlElement(required = true)
	protected Item item;
	
	@XmlElement(required = true)
	protected int quantity;

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

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
