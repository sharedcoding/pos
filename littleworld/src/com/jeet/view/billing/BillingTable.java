package com.jeet.view.billing;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BillingTable extends JTable{

	BillingTable(DefaultTableModel model){
		super(model);
		setRowHeight(25);
		adjustColumnWidth();
	}
	
	private void adjustColumnWidth(){
		getColumnModel().getColumn(0).setPreferredWidth(30);
		getColumnModel().getColumn(1).setPreferredWidth(150);
		getColumnModel().getColumn(2).setPreferredWidth(50);
		getColumnModel().getColumn(3).setPreferredWidth(50);
		getColumnModel().getColumn(4).setPreferredWidth(50);
		getColumnModel().getColumn(5).setPreferredWidth(50);
		getColumnModel().getColumn(6).setPreferredWidth(30);
	}
}
