/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ims.model.bean;

import com.ims.controller.TransactionManager;
import java.util.Hashtable;


/**
 *
 * @author ahbaba
 */
public class TransactionModel{
    //items information
    private Hashtable<String,Integer> prodDetails = new Hashtable();
    //coustomer information
    private String customerID;
    //Bll information
    private String BillID;
    private Double billAmount;
    //user id
    private String userID;

    private float discount;
    private boolean paymentStatus;



    public String getBillID() {
        return BillID;
    }

    public void setBillID(String BillID) {
        this.BillID = BillID;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Hashtable<String, Integer> getProdDetails() {
        return prodDetails;
    }

    public void setProdDetails(Hashtable<String, Integer> prodDetails) {
        this.prodDetails = prodDetails;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean status) {
        this.paymentStatus = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void commitPurchase(){
        TransactionManager.getInstance().commitPurchase(this);
    }

 }
