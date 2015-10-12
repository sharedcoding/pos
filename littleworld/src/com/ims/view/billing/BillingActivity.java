package com.ims.view.billing;

import java.awt.Container;
import java.awt.Dimension;

import com.ims.infra.Activity;
import com.ims.infra.IBinder;
import com.ims.infra.Intent;
import com.ims.view.ActivityId;
import com.ims.view.FragmentFactory;
import com.ims.view.FragmentId;

public class BillingActivity extends Activity implements ActionUpdateListener {
	
	private BillingInfoPaneFragment infoPaneFragment;
	private BillingActionPaneFragment actionPaneFragment;
	private IBinder binder;
	public BillingActivity(){
		super();
		infoPaneFragment = (BillingInfoPaneFragment)FragmentFactory.getFragmnet(FragmentId.BILLING_INFO_FRAGMENT);
		actionPaneFragment = (BillingActionPaneFragment)FragmentFactory.getFragmnet(FragmentId.BILLING_ACTION_FRAGMENT);
		addFragment(infoPaneFragment);
		addFragment(actionPaneFragment);
	}
	
	protected void onCreate(){
		super.onCreate();
		System.out.println("BillingActivity.onCreate()");
		setPreferredSize(new Dimension(800,700));
		
	}
	
	protected void onStart() {
		super.onStart();
		System.out.println("BillingActivity.onStart()");
		((Container)getIntent().getExtra("com.jeet.view.CONTENTPANE")).add(this);
		setVisible(true);
		this.revalidate();
	}
	
	protected void onDestroy(){
		super.onDestroy();
		((Container)getIntent().getExtra("com.jeet.view.CONTENTPANE")).remove(this);
		setVisible(false);
		((Container)getIntent().getExtra("com.jeet.view.CONTAINER")).repaint();
	}

	public void notifyUpdate(int updateType) {
		System.out.println("BillingActivity.notifyUpdate()"+updateType);
		switch(updateType){
		case ActionUpdateListener.SAVE:
			infoPaneFragment.save();
			break;
		case ActionUpdateListener.PRINT:
			infoPaneFragment.billNumUpdate();
			infoPaneFragment.save();
			Intent intent = getIntent().getIntent(ActivityId.BILLING_PRINTABLE_ACTIVITY);
			startActivity(intent);
			break;
			
		}
	}
}
