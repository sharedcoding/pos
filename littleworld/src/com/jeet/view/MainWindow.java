package com.jeet.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.KeyStore;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.jeet.infra.Activity;
import com.jeet.infra.ActivityManager;
import com.jeet.infra.Intent;
import com.jeet.model.contentprovider.ContentProvider;
import com.jeet.model.db.procedure.MyStoredProcedures;
import com.jeet.view.billing.BillingActivity;

public class MainWindow extends JFrame {
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem item;

	MainWindow() {
		setSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void init() {
		startBillingActivity();
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		item = new JMenuItem("New");
		menuBar.add(menu);
		menu.add(item);
		setJMenuBar(menuBar);
		KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
		item.setAccelerator(ks);
		item.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out
						.println("MainWindow.init().new ActionListener() {...}.actionPerformed()");
				startBillingActivity();
			}
		});
		
		JMenuItem initialize = new JMenuItem("Initialize");
		menu.add(initialize);
		initialize.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				ContentProvider.getContentResolver().createDataBase();
				MyStoredProcedures.createAllProcedures();
			}
		});
	}

	private void startBillingActivity() {
		if (ActivityManager.getInstance().getCurrentActivity() == null) {
			BillingActivity billingActivity = (BillingActivity) ActivityFactory
					.getActivity(ActivityId.BILLING_TABLE_ACTIVITY);
			Intent intent = new Intent();
			intent.putExtra("com.jeet.view.CONTENTPANE", getContentPane());
			intent.putExtra("com.jeet.view.CONTAINER", this);
			billingActivity.startActivity(intent);
		}else {
			Intent intent = new Intent(ActivityId.BILLING_TABLE_ACTIVITY);
			intent.putExtra("com.jeet.view.CONTENTPANE", getContentPane());
			intent.putExtra("com.jeet.view.CONTAINER", this);
			Activity currentActivity = ActivityManager.getInstance().getCurrentActivity();
			currentActivity.startActivity(intent);
		}
	}

	public static void main(String arg[]) {
		MainWindow window = new MainWindow();
		window.init();
		window.setVisible(true);
	}

}
