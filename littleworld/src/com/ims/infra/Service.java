package com.ims.infra;

public abstract class Service extends Thread{

	public void startService(){
		this.start();
	}
	
	public void stopService(){
		
	}
	
	public IBinder bindService(){
		startService();
		return onBind();
	}
	
	protected IBinder onBind(){
		return null;
		
	}
	
	protected void onDestroy(){
		
	}
	
	protected void onServiceStart(){
		
	}
	
	public void run(){
		onServiceStart();
	}
}
