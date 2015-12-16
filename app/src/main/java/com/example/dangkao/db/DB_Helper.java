package com.example.dangkao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Helper extends SQLiteOpenHelper {
	
	private final String CREATE_TABLE_CHAPTER = "create table chapter("
			+ "c_id integer primary key autoincrement,"
			+ "c_title TEXT)";
	
	private final String CREATE_TABLE_CHOICE_QUESTION = "create table choice_question("
			+ "_id integer primary key autoincrement,"
			+ "c_id integer,"
			+ "title TEXT,choice_A TEXT,choice_B TEXT,choice_C TEXT,choice_D TEXT,"
			+ "answer TEXT,"
			+ "is_wrong integer,"
			+ "is_save integer,"
			+ "foreign key(c_id) references chapter(c_id))";
	private final String CREATE_TABLE_TF_QUESTION = "create table tf_question("
			+ "_id integer primary key autoincrement,"
			+ "c_id integer,"
			+ "title TEXT"
			+ "answer TEXT,"
			+ "is_wrong integer,"
			+ "is_save integer,"
			+ "foreign key(c_id) references chapter(c_id))";
	private final String CREATE_TABLE_BF_QUESTION = "create table bf_question("
			+ "_id integer primary key autoincrement,"
			+ "c_id integer,"
			+ "title TEXT,"
			+ "answer TEXT,"
			+ "is_wrong integer,"
			+ "is_save integer,"
			+ "foreign key(c_id) references chapter(c_id))";
	private final String CREATE_TABLE_ESSAY_QUESTION = "create table essay("
			+ "_id integer primary key autoincrement,"
			+ "c_id integer,"
			+ "title TEXT,"
			+ "answer TEXT,"
			+ "is_wrong integer,"
			+ "is_save integer,"
			+ "foreign key(c_id) references chapter(c_id))";

	public DB_Helper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_CHAPTER);
		db.execSQL(CREATE_TABLE_CHOICE_QUESTION);
		db.execSQL(CREATE_TABLE_TF_QUESTION);
		db.execSQL(CREATE_TABLE_BF_QUESTION);
		db.execSQL(CREATE_TABLE_ESSAY_QUESTION);
		System.out.println("sql create success!");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
