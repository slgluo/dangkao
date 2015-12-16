package com.example.dangkao.ui;

import java.util.List;

import com.example.dangkao.R;
import com.example.dangkao.base.BaseActivity;
import com.example.dangkao.dao.ChoiceQuestionDao;
import com.example.dangkao.model.entity.Chapter;
import com.example.dangkao.model.entity.ChoiceQuestion;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class OrderExerciseActivity extends BaseActivity {

	ChoiceQuestionDao choiceQuestionDao = null;
	List<ChoiceQuestion> choiceQuestionList = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_exercise);
		init();
		initView();
	}

	private class MyHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			choiceQuestionList = (List)msg.obj;
			refelsh(choiceQuestionList);
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		final MyHandler myHandler = new MyHandler();
		new Thread(){
			@Override
			public void run() {
				Message msg = new Message();
				choiceQuestionDao = new ChoiceQuestionDao(getApplicationContext());
				msg.obj = choiceQuestionDao.queryAllChoiceQuestions();
				myHandler.sendMessage(msg);
			}
		}.start();
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refelsh(Object... params) {
		// TODO Auto-generated method stub
	}

}
