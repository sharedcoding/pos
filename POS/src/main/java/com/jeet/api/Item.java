//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.22 at 10:54:31 AM IST 
//

package com.jeet.api;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="itemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sprice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element ref="{http://www.jeet.com/api}type"/>
 *         &lt;element ref="{http://www.jeet.com/api}offer" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "barCode", "itemName", "description",
		"sellingPrice","purchasePrice", "type", "supplierSet", "offerSet","billSet"})
@XmlRootElement(name = "item")
@Entity
public class Item {

	@Id
	@XmlElement(required = true)
	@Column(name = "BARCODE")
	protected int barCode;

	@XmlElement(required = true)
	protected String itemName;

	@XmlElement(required = true)
	protected String description;

	@XmlElement(required = true)
	protected int sellingPrice;

	@XmlElement(required = true)
	protected int purchasePrice;

	@XmlElement(required = true)
	@OneToOne
	protected Type type;

	@XmlElement(required = true)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "item")
	protected Set<ItemSupplier> supplierSet = new HashSet<ItemSupplier>();

	@XmlElement(required = true)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "item")
	protected Set<ItemOffer> offerSet = new HashSet<ItemOffer>();
	
	
	@XmlElement(required = true)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "item")
	protected Set<ItemBill> billSet = new HashSet<ItemBill>();
	
	public String toString(){
		return "barCode: "+barCode+" itemName: "+itemName+" type:"+type.getName()+" supplierSet size: "+supplierSet.size()+" billSet size:"+billSet.size(); 
	}

	public Set<ItemSupplier> getSupplierSet() {
		return supplierSet;
	}

	public Set<ItemOffer> getOfferSet() {
		return offerSet;
	}

	public Set<ItemBill> getBillSet() {
		return billSet;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getBarCode() {
		return barCode;
	}

	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}

	/**
	 * Gets the value of the itemName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the value of the itemName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setItemName(String value) {
		this.itemName = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link Type }
	 * 
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link Type }
	 * 
	 */
	public void setType(Type value) {
		this.type = value;
	}

}
