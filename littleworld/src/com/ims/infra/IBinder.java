package com.ims.infra;

public interface IBinder {
	
	public static final int STOP = 1;
	
	public static final int PAUSE = 2;
	
	public static final int RESUME = 3;
	
	public void actionOnService(int actionId);

}
