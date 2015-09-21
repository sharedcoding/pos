package com.jeet.model.contentprovider;

import java.util.Vector;

import com.jeet.model.bean.DataRow;
import com.jeet.model.db.intf.DBCreater;
import com.jeet.model.db.intf.DBFinder;
import com.jeet.model.db.intf.DBUpdater;
import com.jeet.model.db.procedure.MyStoredProcedures;

public class ContentResolver {

	ContentResolver() {
	}

	public Vector<DataRow> executeSelect(int dataRowType, String whereCondition) {
		return DBFinder.getFinder().executeSelect(dataRowType, whereCondition);
	}
	
	public void executeUpdate(Vector<DataRow> rows){
		DBUpdater.getUpdater().executeUpdate(rows);
	}
	
	public void createDataBase(){
		DBCreater.getCreater().createDBTables();
	}
}
