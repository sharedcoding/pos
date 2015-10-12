/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ims.controller;

import com.ims.model.bean.TransactionModel;
import java.util.Iterator;
import java.util.Vector;


/**
 *
 * @author ahbaba
 */
public class TransactionManager {

    private static TransactionManager instance = new TransactionManager();

    private Vector transactionListener;

    private TransactionManager (){
        transactionListener = new Vector ();
    }

    public static TransactionManager getInstance(){
        return instance;
    }

    public void addTransactionListener(IPurchaseCommit daoObject){
        if(!transactionListener.contains(daoObject)){
            transactionListener.add(daoObject);
        }
        System.out.println("transactionListener.size()   "+transactionListener.size());
    }
    
     public void removeTransactionListener(IPurchaseCommit daoObject){
        if(transactionListener.contains(daoObject)){
            transactionListener.remove(daoObject);
        }
        System.out.println("transactionListener.size()   "+transactionListener.size());
    }


  
     private void notifyAllListeners(TransactionModel model){
    Iterator itr = transactionListener.iterator();
        while(itr.hasNext()){
            ((IPurchaseCommit)itr.next()).commitPurchase(model);
        }
    }


    public void commitPurchase(TransactionModel transactionModel){
        notifyAllListeners(transactionModel);
    }

}
