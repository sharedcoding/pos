/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ims.view.billingx;

import com.ims.controller.IPurchaseCommit;
import com.ims.controller.TransactionManager;
import com.ims.model.bean.ItemDAO;
import com.ims.model.bean.TransactionModel;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahbaba
 */
public class PurchasedCart implements IPurchaseCommit{

    public PurchasedCart() {
    }

    public void addTransactionListener(){
        TransactionManager.getInstance().addTransactionListener(this);
    }

    public void removeTransactionListner(){
        TransactionManager.getInstance().removeTransactionListener(this);
    }

    public void commitPurchase(TransactionModel billedModel) {
      updateItemTable(billedModel.getProdDetails());
    }


    public void updateItemTable(Hashtable<String, Integer> table){
        Enumeration<String> enumeration = table.keys();
        while(enumeration.hasMoreElements()){
            String prodid = enumeration.nextElement();
            Integer quantity_bil = table.get(prodid);
            try {
                ItemDAO itemDao = ItemDAO.getDetails(prodid);
                int quantity_inventory = itemDao.getPQuantity();
                int newQuantity = quantity_inventory - quantity_bil;
                newQuantity = newQuantity >= 0? newQuantity:0;
//                itemDao.updateQuantity(newQuantity,itemDao);
//            } catch (NoItemFoundException ex) {
//                Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
