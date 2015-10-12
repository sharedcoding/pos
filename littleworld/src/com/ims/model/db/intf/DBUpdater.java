package com.ims.model.db.intf;

import java.util.Vector;

import com.ims.model.bean.DataRow;
import com.ims.model.db.impl.DBUpdaterImpl;

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
