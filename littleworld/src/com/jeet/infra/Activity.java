package com.jeet.infra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.jeet.view.ActivityFactory;
import com.jeet.view.FragmentFactory;

public class Activity extends JPanel {

	private Vector<Fragment> fragmentList;
	private Intent intent;
	private Timer timer;

	public Activity() {
		fragmentList = new Vector<Fragment>();
	}

	protected void onCreate() {
		for (Fragment fragment : fragmentList) {
			fragment.onCreate();
			fragment.onBind(this);
			this.add(fragment);
		}
	}

	protected void onDestroy() {
		if (fragmentList != null) {
			for (Fragment fragment : fragmentList) {
				System.out.println("Activity.onDestroy() --------------------");
				this.remove(fragment);
				fragment.onDestroy();
			}
			fragmentList.removeAllElements();
			fragmentList = null;
		}
	}

	protected void addFragment(Fragment frag) {
		fragmentList.add(frag);
	}
	
	public void startActivity(Intent intent){
		final Activity activity;
		if(intent != null && intent.getActId() != 0){
			onDestroy();
			activity = ActivityFactory.getActivity(intent.getActId());
			ActivityManager.getInstance().setCurrentActivity(this, activity);
			System.out.println("Activity.startActivity()"+activity);
			activity.setIntent(intent);
			activity.onCreate();
		}else {
			activity = this;
			ActivityManager.getInstance().setCurrentActivity(null, this);
			this.setIntent(intent);
			this.onCreate();
		}
		
		timer = new Timer(100, new ActionListenerImpl(activity));
		timer.start();
	}
	
	class ActionListenerImpl implements ActionListener {
		private Activity act;
		ActionListenerImpl(Activity act){
			this.act = act;
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("Activity.ActionListenerImpl.actionPerformed()");
			act.onStart();
			timer.stop();
			timer = null;
		}
		
	}
	
	public void setIntent(Intent intent){
		this.intent = intent;
	}
	public Intent getIntent() {
		return intent;
	}
	
	protected void onStart(){
		
	}
	protected void onStop(){
		
	}
}
