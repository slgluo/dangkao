package com.example.dangkao.model.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.example.dangkao.base.BaseActivity;
import com.example.dangkao.model.entity.Task;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class MainService extends Service implements Runnable{
	

	private static Queue<Task> Tasks = new LinkedList<Task>();

	private static List<BaseActivity> Activitys = new ArrayList<BaseActivity>();

	private static boolean isRun = false;

	
	@Override
	public void onCreate() {
		isRun = true;
		Thread t = new Thread(this);
		t.start();
		System.out.println("service start");
		System.out.println(t.getId()+"..."+t.getName());
	}


	public static void addTask(Task t){
		Tasks.add(t);
		System.out.println("addTask");
	}
	

	public static void addActivity(BaseActivity activity){
		Activitys.add(activity);
		System.out.println("addActivity");
	}
	

    public static BaseActivity getActivityByName(String name) {
        for (BaseActivity ac : Activitys) {
            if (ac.getClass().getName().indexOf(name) >= 0) {
                return ac;
            }
        }
        return null;
    }

	
	@Override
	public void run() {
		System.out.println("run");
		Task task = null;
		while(isRun){
			if(!Tasks.isEmpty()){
				task = Tasks.poll();
				if(null != task){
					doTask(task);
				}
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			System.out.println("handleMessage");
			super.handleMessage(msg);
			BaseActivity ui = null;
			switch(msg.what){
			default:
				break;
			}
		}
		
	};
	
	private void doTask(Task t){
		String result = "";
		Message msg = handler.obtainMessage();
		msg.what = t.getTaskId();
		System.out.println("do Task");
		switch(t.getTaskId()){

		default:
			break;
		}
		handler.sendMessage(msg);
	}
	
	

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
