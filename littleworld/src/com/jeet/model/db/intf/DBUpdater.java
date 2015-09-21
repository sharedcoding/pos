package com.jeet.model.db.intf;

import java.util.Vector;

import com.jeet.model.bean.DataRow;
import com.jeet.model.db.impl.DBUpdaterImpl;

public abstract class DBUpdater {
	
	private static DBUpdater updater;
	protected DBUpdater(){
	}
	
	public static DBUpdater getUpdater(){
		if(updater == null){
			updater = new DBUpdaterImpl();
		}
		return updater;
	}

	public abstract int executeUpdate(Vector<DataRow> dataRow);
}
