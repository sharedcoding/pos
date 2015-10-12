/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.model.bean;

import com.ims.util.Util;
import java.sql.SQLException;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author ahbaba
 */
@Entity
@ Table(name="items")
public class ItemDAO {
    @Id
    private String PID;
    @Temporal(TemporalType.DATE)
    private Date PExpityDate;
    private String PName;
    private int PQuantity;
    private float PSalePrice;
    private String PType;
    private float PPurchasePrice;
    private String PDescription;

    public String getPDescription() {
        return PDescription;
    }

    public void setPDescription(String PDescription) {
        this.PDescription = PDescription;
    }

    public Date getPExpityDate() {
        return PExpityDate;
    }

    public void setPExpityDate(Date PExpityDate) {
        this.PExpityDate = PExpityDate;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public float getPPurchasePrice() {
        return PPurchasePrice;
    }

    public void setPPurchasePrice(float PPurchasePrice) {
        this.PPurchasePrice = PPurchasePrice;
    }

    public int getPQuantity() {
        return PQuantity;
    }

    public void setPQuantity(int PQuantity) {
        this.PQuantity = PQuantity;
    }

    public float getPSalePrice() {
        return PSalePrice;
    }

    public void setPSalePrice(float PSalePrice) {
        this.PSalePrice = PSalePrice;
    }

    public String getPType() {
        return PType;
    }

    public void setPType(String PType) {
        this.PType = PType;
    }
   

//
//    public void saveProduct(ItemDAO item) {
////       SessionFactory sesFactory = Maincontroller.getInstance().getSessFactory();
//        Session session = sesFactory.openSession();
//        session.beginTransaction();
//        ItemDAO itemDao = (ItemDAO)session.get(ItemDAO.class, item.getPID());
//        if(itemDao == null){
//        session.save(item);
//        session.getTransaction().commit();
//        }else{
//            throw new ItemAlreadyPresentException();
//        }
//        session.close();
//   }
//
//
//    public void updateQuantity(int newQuantity, ItemDAO item){
//       SessionFactory sesFactory = Maincontroller.getInstance().getSessFactory();
////        Maincontroller.getInstance().getSessFactory();
//        Session session = sesFactory.openSession();
//        session.beginTransaction();
//        item.setPQuantity(newQuantity);
//        session.merge(item);
//        session.getTransaction().commit();
//        session.close();
//
//   }
//
//
//    public void updateProductDetails(ItemDAO item){
//       SessionFactory sesFactory = Maincontroller.getInstance().getSessFactory();
//        Session session = sesFactory.openSession();
//        session.beginTransaction();
//        session.merge(item);
//        session.getTransaction().commit();
//        session.close();
//   }
//
//
//
    public static ItemDAO getDetails(String barcode) throws SQLException {
           SessionFactory sesFactory = Util.getSessFactory();
            Session session = sesFactory.openSession();
            session.beginTransaction();
            ItemDAO itemDao = (ItemDAO)session.get(ItemDAO.class, barcode);
            if (itemDao == null) {
                session.close();
//                throw new NoItemFoundException();
            }
            session.close();
             return itemDao;

    }
//
//
////    private void commitItemTable(Hashtable<String,Integer> billedObject) {
////      updateItemTable(billedObject);
////    }
//
//
//
////    public String toString() {
////        return "prodID:" + prodID + " prodName:" + prodName + "prodQuantity:" + prodQuantity + " prodSalePrice:" + prodSalePrice + " prodPurchasePrice" + prodPurchasePrice + " prodType:" + prodType;
////
////    }
}
