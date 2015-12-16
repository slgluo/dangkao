package com.example.dangkao.base;

import java.io.File;

import android.os.Environment;

public final class C {
	

	public static final class DIR{
		public static final String FILE_PAPER_PATH =Environment.getExternalStorageDirectory()+File.separator+"dangjiao";
		public static final String FILE_PATH = FILE_PAPER_PATH+File.separator+"dangjiao.db";
		public static final String TEP_FILE_PATH = Environment.getExternalStorageDirectory()+File.separator+"dangjiao"+File.separator+"a.db";
		public static final String SDCADR = Environment.getExternalStorageDirectory().getAbsolutePath();
	}
	

	public static final class DB{
		
		public static final String DB_NAME             = "dangjiao";
	}

}
