package com.example.dangkao.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.dangkao.db.DBManager;
import com.example.dangkao.model.entity.Chapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ChapterDao {
	
	DBManager dbm;

	private SQLiteDatabase db;

	List<Chapter> chapters;
	
	public ChapterDao(Context context){
		dbm = new DBManager(context);
	}
	

	public Chapter queryChapterById(int c_id){
		if (db == null) {
			db = dbm.openConnect();
		}
		String sql = "select * from chapter where c_id=?";
		String args[] ={Integer.toString(c_id)};
		
		Chapter chapter = null;
		
		Cursor rs = db.rawQuery(sql, args);
		while(rs.moveToNext()){
			chapter = new Chapter();
			chapter.setC_id(rs.getInt(0));
			chapter.setC_title(rs.getString(1));
		}
		rs.close();
		dbm.closeConnect();
		return chapter;
	}
	

	public List<Chapter> queryChapters(){
		if(db == null){
			db = dbm.openConnect();
		}
		String sql = "select * from chapter";
		Chapter chapter = null;
		chapters = new ArrayList<Chapter>();
		Cursor rs = db.rawQuery(sql, null);
		while(rs.moveToNext()){
			chapter = new Chapter();
			chapter.setC_id(rs.getInt(0));
			chapter.setC_title(rs.getString(1));
			chapters.add(chapter);
		}
		rs.close();
		dbm.closeConnect();
		return chapters;
	}
}
