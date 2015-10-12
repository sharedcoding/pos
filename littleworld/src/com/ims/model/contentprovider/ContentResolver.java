package com.ims.model.contentprovider;

import java.util.Vector;

import com.ims.model.bean.DataRow;
import com.ims.model.db.intf.DBCreater;
import com.ims.model.db.intf.DBFinder;
import com.ims.model.db.intf.DBUpdater;
import com.ims.model.db.procedure.MyStoredProcedures;

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
