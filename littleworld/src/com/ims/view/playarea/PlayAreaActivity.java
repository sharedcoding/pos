/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PlayAreaActivity.java
 *
 * Created on Oct 10, 2015, 4:24:19 PM
 */

package com.ims.view.playarea;

import com.ims.infra.Activity;
import com.ims.infra.Intent;
import com.ims.view.ActivityId;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author ahbaba
 */
public class PlayAreaActivity extends Activity {



    /** Creates new form PlayAreaActivity */
    public PlayAreaActivity() {
        initComponents();
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        Container pane = (Container) getIntent().getExtra("com.ims.view.CONTENTPANE");
        timer.start();
        pane.add(this);
        this.setVisible(true);
        this.revalidate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.stop();
        timer = null;
        Container pane = (Container) getIntent().getExtra("com.ims.view.CONTENTPANE");
        pane.remove(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


   
    Timer timer = new Timer(1000, new ActionListener() {
     public void actionPerformed(ActionEvent e) {
           curTimeTxt.setText("fddfd");
           updateDate();
        }
    });


    private void updateDate(){
        StringBuffer timer = new StringBuffer();
        timer.append(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        timer.append(":"+Calendar.getInstance().get(Calendar.MINUTE));
        timer.append(":"+Calendar.getInstance().get(Calendar.SECOND));
        curTimeTxt.setText(timer.toString());
    }
   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memIDTxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addButton3 = new javax.swing.JButton();
        EmialTxt = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        depositTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mobTxl = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        curTimeTxt = new javax.swing.JTextField();
        dobDate = new org.jdesktop.swingx.JXDatePicker();
        addButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        memIDTxt.setFont(new java.awt.Font("Arial", 1, 18));
        memIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memIDTxtActionPerformed(evt);
            }
        });
        memIDTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                memIDTxtKeyTyped(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 24));
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel4.setText("Member Name");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel9.setText("Email ID");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        addButton3.setFont(new java.awt.Font("Arial", 1, 24));
        addButton3.setText("Calculate Bill");
        addButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton3ActionPerformed(evt);
            }
        });

        EmialTxt.setFont(new java.awt.Font("Arial", 1, 18));
        EmialTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmialTxtActionPerformed(evt);
            }
        });
        EmialTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmialTxtFocusLost(evt);
            }
        });
        EmialTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EmialTxtKeyTyped(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 1, 24));
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel3.setText("Member ID");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel8.setText("Deposite");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel5.setText("DOB");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        depositTxt.setFont(new java.awt.Font("Arial", 1, 18));
        depositTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                depositTxtFocusLost(evt);
            }
        });
        depositTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                depositTxtKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel7.setText("Mobile No.");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        mobTxl.setFont(new java.awt.Font("Arial", 1, 18));
        mobTxl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobTxlActionPerformed(evt);
            }
        });
        mobTxl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobTxlFocusLost(evt);
            }
        });
        mobTxl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobTxlKeyTyped(evt);
            }
        });

        nameTxt.setFont(new java.awt.Font("Arial", 1, 18));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel10.setText("Current Time");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        curTimeTxt.setFont(new java.awt.Font("Arial", 1, 18));
        curTimeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curTimeTxtActionPerformed(evt);
            }
        });
        curTimeTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                curTimeTxtFocusLost(evt);
            }
        });
        curTimeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                curTimeTxtKeyTyped(evt);
            }
        });

        dobDate.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        addButton4.setFont(new java.awt.Font("Arial", 1, 24));
        addButton4.setText("Start/Stop");
        addButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(memIDTxt))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(nameTxt))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(dobDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(mobTxl))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(EmialTxt))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(depositTxt))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(curTimeTxt))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(222, 222, 222)
                            .addComponent(addButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(addButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(396, 396, 396))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton3, jButton2, jButton5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dobDate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobTxl, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(depositTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(curTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void memIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memIDTxtActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_memIDTxtActionPerformed

    private void memIDTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memIDTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_memIDTxtKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //        clearItem();
}//GEN-LAST:event_jButton2ActionPerformed

    private void addButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton3ActionPerformed
        // TODO add your handling code here:
//        gatherDataFromUI(); Store data in DB and write starttime in card
        

}//GEN-LAST:event_addButton3ActionPerformed

    private void EmialTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmialTxtActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_EmialTxtActionPerformed

    private void EmialTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmialTxtFocusLost
        // TODO add your handling code here:
        //        validateNumber(evt);
}//GEN-LAST:event_EmialTxtFocusLost

    private void EmialTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmialTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_EmialTxtKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Intent intent = getIntent().getIntent(ActivityId.WELCOME_ACTIVITY);
        startActivity(intent);
}//GEN-LAST:event_jButton5ActionPerformed

    private void depositTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_depositTxtFocusLost
        // TODO add your handling code here:
        //        validateNumber(evt);
}//GEN-LAST:event_depositTxtFocusLost

    private void depositTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_depositTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_depositTxtKeyTyped

    private void mobTxlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobTxlActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_mobTxlActionPerformed

    private void mobTxlFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobTxlFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_mobTxlFocusLost

    private void mobTxlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobTxlKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_mobTxlKeyTyped

    private void curTimeTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_curTimeTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_curTimeTxtFocusLost

    private void curTimeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_curTimeTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_curTimeTxtKeyTyped

    private void curTimeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curTimeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_curTimeTxtActionPerformed

    private void addButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmialTxt;
    private javax.swing.JButton addButton3;
    private javax.swing.JButton addButton4;
    private javax.swing.JTextField curTimeTxt;
    private javax.swing.JTextField depositTxt;
    private org.jdesktop.swingx.JXDatePicker dobDate;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField memIDTxt;
    private javax.swing.JTextField mobTxl;
    private javax.swing.JTextField nameTxt;
    // End of variables declaration//GEN-END:variables

}
