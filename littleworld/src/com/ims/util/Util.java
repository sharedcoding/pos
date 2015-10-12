/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ims.util;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ahbaba
 */
public class Util {

      public static boolean isNumberKeys(char keyChar) {
       return (Character.isDigit(keyChar)|| keyChar == KeyEvent.VK_BACK_SPACE || keyChar == KeyEvent.VK_DELETE);
    }

      public static boolean isFloatingPointNumber(char keyChar){
           return (Character.isDigit(keyChar)|| keyChar == KeyEvent.VK_BACK_SPACE || keyChar == KeyEvent.VK_DELETE || keyChar == '.');
      }

      public static boolean validateNumberPresent(JTextField textbox){
          System.out.println(" Field Name ="+ textbox.getName() +" value ="+textbox.getText());
          if(textbox.getText()== null || textbox.getText().trim().equals(""))
              return false;
          else
              return true;
      }

       static SessionFactory sesFactory = new Configuration().configure().buildSessionFactory();

    public static SessionFactory getSessFactory() {
        return sesFactory;
    }



}
