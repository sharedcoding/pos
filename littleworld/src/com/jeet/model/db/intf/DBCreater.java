package com.jeet.model.db.intf;

import com.jeet.model.db.impl.DBCreaterImpl;

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