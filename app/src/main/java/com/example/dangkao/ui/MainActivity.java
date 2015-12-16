package com.example.dangkao.ui;

import com.example.dangkao.R;
import com.example.dangkao.base.BaseActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

	private PractiseFragment practiseFragment;
	private RecordFragment recordFragment;
	private WrongFragment wrongFragment;
	private SaveFragment saveFragment;
	private FragmentManager fgManager;

	private RadioGroup menuTabRb;
	private TextView title_bar_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		init();
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		fgManager = this.getFragmentManager();
		practiseFragment = new PractiseFragment();
		fgManager.beginTransaction().add(R.id.fg_content, practiseFragment).commit();
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		menuTabRb = (RadioGroup)findViewById(R.id.tab_menu);
		title_bar_text = (TextView) findViewById(R.id.title_bar_text);
		menuTabRb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub

				FragmentTransaction fgTransaction = fgManager.beginTransaction();
				hideAllFragment(fgTransaction);
				switch (checkedId) {
				case R.id.tab_menu_practise:
					title_bar_text.setText("练习");
					fgTransaction.show(practiseFragment);
					break;
				case R.id.tab_menu_record:
					title_bar_text.setText("考试记录");
					if (recordFragment == null) {
						recordFragment = new RecordFragment();
						fgTransaction.add(R.id.fg_content, recordFragment);
					} else {
						fgTransaction.show(recordFragment);
					}
					break;
				case R.id.tab_menu_wrong:
					title_bar_text.setText("错题库");
					if (wrongFragment == null) {
						wrongFragment = new WrongFragment();
						fgTransaction.add(R.id.fg_content, wrongFragment);
					} else {
						fgTransaction.show(wrongFragment);
					}
					break;
				case R.id.tab_menu_save:
					title_bar_text.setText("收藏");
					if(saveFragment == null){
						saveFragment = new SaveFragment();
						fgTransaction.add(R.id.fg_content, saveFragment);
					}else{
						fgTransaction.show(saveFragment);
					}
				default:
					break;
				}
				fgTransaction.commit();
			}
		});
	}

	@Override
	public void refelsh(Object... params) {
		// TODO Auto-generated method stub

	}

	// ��������Fragment
	private void hideAllFragment(FragmentTransaction fragmentTransaction) {
		if (practiseFragment != null)
			fragmentTransaction.hide(practiseFragment);
		if (recordFragment != null)
			fragmentTransaction.hide(recordFragment);
		if (wrongFragment != null)
			fragmentTransaction.hide(wrongFragment);
		if (saveFragment != null)
			fragmentTransaction.hide(saveFragment);
	}
}
