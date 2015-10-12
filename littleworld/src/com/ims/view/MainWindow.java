/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on Oct 7, 2015, 4:59:48 PM
 */

package com.ims.view;

import com.ims.infra.Activity;
import com.ims.infra.ActivityManager;
import com.ims.infra.Intent;
import com.ims.view.login.UserLoginActivity;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author ahbaba
 */
public class MainWindow extends javax.swing.JFrame {

    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1035, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
                MainWindow  window = new MainWindow();
                window.setLayout(new FlowLayout());
//                window.setPreferredSize(new Dimension(300, 400));
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
                window.init();
                window.setVisible(true);
                
       
    }

    private void init() {
		startUserLogingActivity();
	}

    private void startUserLogingActivity() {
		if (ActivityManager.getInstance().getCurrentActivity() == null) {
			UserLoginActivity userloginActivity = (UserLoginActivity) ActivityFactory
					.getActivity(ActivityId.LOGIN_ACTIVITY);
			Intent intent = new Intent();
			intent.putExtra("com.ims.view.CONTENTPANE", this.getContentPane());
			userloginActivity.startActivity(intent);
		}else {
			Intent intent = new Intent(ActivityId.BILLING_TABLE_ACTIVITY);
			intent.putExtra("com.ims.view.CONTENTPANE", getContentPane());
			Activity currentActivity = ActivityManager.getInstance().getCurrentActivity();
			currentActivity.startActivity(intent);
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}