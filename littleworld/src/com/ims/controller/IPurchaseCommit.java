/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ims.controller;

import com.ims.model.bean.TransactionModel;


/**
 *
 * @author ahbaba
 */
public interface IPurchaseCommit {

     public abstract void commitPurchase(TransactionModel billedModel);

}
