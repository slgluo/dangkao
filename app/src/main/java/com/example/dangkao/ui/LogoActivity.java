package com.example.dangkao.ui;

import com.example.dangkao.R;
import com.example.dangkao.base.BaseActivity;
import com.example.dangkao.model.service.MainService;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class LogoActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_logo);
		init();
		initView();

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

		Intent intent = new Intent(this,MainService.class);
		startService(intent);
	//	new DB_Helper(LogoActivity.this,"dangjiao",null,1);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		AlphaAnimation animation = new AlphaAnimation(1.0f, 1.0f);
        animation.setDuration(3000);
        
        ImageView img_logo = (ImageView) this.findViewById(R.id.img_logo);
        img_logo.setAnimation(animation);
        
        
        animation.setAnimationListener(new AnimationListener(){

			public void onAnimationEnd(Animation animation)
			{
				forward(MainActivity.class);
			}

			public void onAnimationRepeat(Animation animation)
			{
				// TODO Auto-generated method stub
				
			}

			public void onAnimationStart(Animation animation)
			{
				// TODO Auto-generated method stub
				
			}});
	}

	@Override
	public void refelsh(Object... params) {
		// TODO Auto-generated method stub
		
	}


}
