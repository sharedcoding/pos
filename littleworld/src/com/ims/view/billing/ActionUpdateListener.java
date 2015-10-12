package com.ims.view.billing;

public interface ActionUpdateListener {
	
	public int SAVE = 1;
	public int PRINT = 2;
	public void notifyUpdate(int updateType);

}
