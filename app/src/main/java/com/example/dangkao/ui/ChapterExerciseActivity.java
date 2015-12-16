package com.example.dangkao.ui;

import java.util.List;

import com.example.dangkao.dao.ChapterDao;
import com.example.dangkao.R;
import com.example.dangkao.base.BaseActivity;
import com.example.dangkao.model.entity.Chapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChapterExerciseActivity extends BaseActivity {

	ListView chapter_list;
	ChapterDao chapterDao;
	List<Chapter> chapters;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_exercise);
		init();
		initView();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		chapterDao = new ChapterDao(ChapterExerciseActivity.this);
		chapters = chapterDao.queryChapters();
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		chapter_list = (ListView)findViewById(R.id.chapter_list);
		BaseAdapter adapter = new BaseAdapter(){  //BaseAdapter,chapter列表

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return chapters.size();
			}

			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LayoutInflater inflater = LayoutInflater.from(ChapterExerciseActivity.this);
				if(convertView == null){
					convertView = inflater.inflate(R.layout.chapter_list_item, null);
				}
				TextView chapter_title= (TextView)convertView.findViewById(R.id.chapter_title);
				chapter_title.setText(chapters.get(position).toString());

				return convertView;

			}};
			chapter_list.setAdapter(adapter);
	}

	@Override
	public void refelsh(Object... params) {
		// TODO Auto-generated method stub
		
	}
}
