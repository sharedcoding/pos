package com.ims.view.billing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ims.infra.Activity;
import com.ims.infra.Fragment;

public class BillingActionPaneFragment extends Fragment {

	private JButton saveBtn;
	private JButton printBtn;
	private ActionUpdateListener listener;
	
	public void onCreate(){
		super.onCreate();
		setPreferredSize(new Dimension(800, 35));
		setLayout(new FlowLayout());
		init();
	}
	
	private void init(){
		saveBtn = new JButton("Save");
		this.add(saveBtn);
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listener.notifyUpdate(ActionUpdateListener.SAVE);
			}
		});
		
		printBtn = new JButton("Print");
		this.add(printBtn);
		printBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listener.notifyUpdate(ActionUpdateListener.PRINT);
			}
		});
	}
	
	public void onDestroy(){
		super.onDestroy();
		saveBtn = null;
		printBtn = null;
	}
	public void onBind(Activity activity){
		this.listener = (ActionUpdateListener)activity;
	}
	
	
}
