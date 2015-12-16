package com.example.dangkao.model.entity;

import java.util.HashMap;

import android.content.Context;

public class Task {

	
	private int taskId;
	private HashMap taskParams;
	
	private Context context;
	
	public final static int LOAD_CHAPTER = 1;
	
	public int getTaskId() {
		return taskId;
	}
	
	public Task(){}
	
	public Task(int taskId, HashMap taskParams, Context context) {
		super();
		this.taskId = taskId;
		this.taskParams = taskParams;
		this.context = context;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public HashMap getTaskParams() {
		return taskParams;
	}
	public void setTaskParams(HashMap taskParams) {
		this.taskParams = taskParams;
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	

}