/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddSupplierActivity.java
 *
 * Created on Oct 9, 2015, 2:51:28 PM
 */

package com.ims.view.addSupplier;

import com.ims.infra.Activity;
import com.ims.infra.Intent;
import com.ims.view.ActivityId;
import java.awt.Container;

/**
 *
 * @author ahbaba
 */
public class AddSupplierActivity extends Activity {

    /** Creates new form AddSupplierActivity */
    public AddSupplierActivity() {
        initComponents();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Container pane = (Container) getIntent().getExtra("com.ims.view.CONTENTPANE");
        pane.remove(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Container pane = (Container) getIntent().getExtra("com.ims.view.CONTENTPANE");
        pane.add(this);
        pane.revalidate();
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        suppTINTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        suppTANTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        suppNameTxt = new javax.swing.JTextField();
        suppAddTxt = new javax.swing.JTextField();
        SuppCSTTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        suppPANTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        addButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        suppliercodeTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel3.setText("Supplier code");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        suppTINTxt.setFont(new java.awt.Font("Arial", 1, 18));
        suppTINTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppTINTxtActionPerformed(evt);
            }
        });
        suppTINTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                suppTINTxtFocusLost(evt);
            }
        });
        suppTINTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                suppTINTxtKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel7.setText("TIN");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        suppTANTxt.setFont(new java.awt.Font("Arial", 1, 18));
        suppTANTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                suppTANTxtFocusLost(evt);
            }
        });
        suppTANTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                suppTANTxtKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel5.setText("Address");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        suppNameTxt.setFont(new java.awt.Font("Arial", 1, 18));

        suppAddTxt.setFont(new java.awt.Font("Arial", 1, 18));

        SuppCSTTxt.setFont(new java.awt.Font("Arial", 1, 18));
        SuppCSTTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppCSTTxtActionPerformed(evt);
            }
        });
        SuppCSTTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SuppCSTTxtFocusLost(evt);
            }
        });
        SuppCSTTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SuppCSTTxtKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel11.setText("CST");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton5.setFont(new java.awt.Font("Arial", 1, 24));
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Arial", 1, 24));
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        suppPANTxt.setFont(new java.awt.Font("Arial", 1, 18));
        suppPANTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppPANTxtActionPerformed(evt);
            }
        });
        suppPANTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                suppPANTxtFocusLost(evt);
            }
        });
        suppPANTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                suppPANTxtKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel9.setText("PAN");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        addButton3.setFont(new java.awt.Font("Arial", 1, 24));
        addButton3.setText("Add");
        addButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton3ActionPerformed(evt);
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
        jLabel4.setText("Name");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        suppliercodeTxt.setFont(new java.awt.Font("Arial", 1, 18));
        suppliercodeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliercodeTxtActionPerformed(evt);
            }
        });
        suppliercodeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                suppliercodeTxtKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel8.setText("TAN");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(suppliercodeTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(suppAddTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(suppTINTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(suppPANTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(suppTANTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(SuppCSTTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(suppNameTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                        .addGap(405, 405, 405))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(suppliercodeTxt)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppAddTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppTINTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppPANTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppTANTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SuppCSTTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(172, 172, 172))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void suppTINTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppTINTxtActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_suppTINTxtActionPerformed

    private void suppTINTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_suppTINTxtFocusLost
        // TODO add your handling code here:
     
}//GEN-LAST:event_suppTINTxtFocusLost

    private void suppTINTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suppTINTxtKeyTyped
        // TODO add your handling code here:
     
}//GEN-LAST:event_suppTINTxtKeyTyped

    private void suppTANTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_suppTANTxtFocusLost
        // TODO add your handling code here:
//        validateNumber(evt);
}//GEN-LAST:event_suppTANTxtFocusLost

    private void suppTANTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suppTANTxtKeyTyped
        // TODO add your handling code here:
     
}//GEN-LAST:event_suppTANTxtKeyTyped

    private void SuppCSTTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SuppCSTTxtFocusLost
        // TODO add your handling code here:
}//GEN-LAST:event_SuppCSTTxtFocusLost

    private void SuppCSTTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SuppCSTTxtKeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_SuppCSTTxtKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Intent intent = getIntent().getIntent(ActivityId.WELCOME_ACTIVITY);
        startActivity(intent);
}//GEN-LAST:event_jButton5ActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        gatherDataFromUI();
}//GEN-LAST:event_updateButtonActionPerformed

    private void suppPANTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppPANTxtActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_suppPANTxtActionPerformed

    private void suppPANTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_suppPANTxtFocusLost
        // TODO add your handling code here:
//        validateNumber(evt);
}//GEN-LAST:event_suppPANTxtFocusLost

    private void suppPANTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suppPANTxtKeyTyped
        // TODO add your handling code here:
      
}//GEN-LAST:event_suppPANTxtKeyTyped

    private void addButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton3ActionPerformed
        // TODO add your handling code here:
        gatherDataFromUI();
}//GEN-LAST:event_addButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        clearItem();
}//GEN-LAST:event_jButton2ActionPerformed

    private void suppliercodeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliercodeTxtActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_suppliercodeTxtActionPerformed

    private void suppliercodeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suppliercodeTxtKeyTyped
        // TODO add your handling code here:
       
}//GEN-LAST:event_suppliercodeTxtKeyTyped

    private void SuppCSTTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppCSTTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SuppCSTTxtActionPerformed

  private void gatherDataFromUI(){
      String supID = suppliercodeTxt.getText();
      String supName = suppNameTxt.getText();
      String supAddr = suppAddTxt.getText();
      String supTIN = suppTINTxt.getText();
      String supPAN = suppPANTxt.getText();
      String supCST = SuppCSTTxt.getText();
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SuppCSTTxt;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addButton1;
    private javax.swing.JButton addButton2;
    private javax.swing.JButton addButton3;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField suppAddTxt;
    private javax.swing.JTextField suppNameTxt;
    private javax.swing.JTextField suppPANTxt;
    private javax.swing.JTextField suppTANTxt;
    private javax.swing.JTextField suppTINTxt;
    private javax.swing.JTextField suppliercodeTxt;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

}