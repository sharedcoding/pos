package com.jeet.api;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "billNumber", "billDate", "totalBill",
		"itemBill"})
@XmlRootElement(name = "bill")
@Entity
public class Bill {

	@Id
	@Column(name = "BILL_NUMBER")
	@XmlElement(required = true)
	protected int billNumber;

	@XmlElement(required = true)
	@Column(name = "BILLING_DATE")
	@Temporal(TemporalType.DATE)
	protected Date billDate;

	@XmlElement(required = true)
	protected int totalBill;

	@XmlElement(required = true)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bill")
	protected Set<ItemBill> itemBill = new HashSet<ItemBill>();

	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
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
