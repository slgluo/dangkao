package com.example.dangkao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	
	private Context context;
	private SQLiteDatabase db;
	
	public DBManager(Context context){
		this.context = context;
	}
	

	public SQLiteDatabase openConnect(){
		if (db == null) {
			ReleaseDataBase releasedatabase = new ReleaseDataBase(this.context);
			releasedatabase.openDatabase();
			db = releasedatabase.getDatabase();
			System.out.println(db.toString());
		}
		return db;
	}

	public void closeConnect() {
		if (db != null) {
			db.close();
			db = null;
		}
	}
}
