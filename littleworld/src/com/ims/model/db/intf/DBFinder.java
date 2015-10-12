package com.ims.model.db.intf;

import java.util.Vector;

import com.ims.model.bean.DataRow;
import com.ims.model.db.impl.DBFinderImpl;

public abstract class DBFinder {
	
private static DBFinder finder;
	
	protected DBFinder(){
	}
	
	public static DBFinder getFinder(){
		if(finder == null){
			finder = new DBFinderImpl();
		}
		return finder;
	}
 
	public abstract Vector<DataRow> executeSelect(int dataRowType, String whereCondition);
}
