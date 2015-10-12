package com.ims.model.db.intf;

import com.ims.model.db.impl.DBCreaterImpl;

public abstract class DBCreater {
	
	private static DBCreater creater;
	
	protected DBCreater(){
	}
	
	public static DBCreater getCreater(){
		if(creater == null){
			creater = new DBCreaterImpl();
		}
		return creater;
	}
	
	public abstract boolean createDBTables();
}