package com.example.dangkao.ui;


import com.example.dangkao.R;
import com.example.dangkao.db.DB_Helper;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class PractiseFragment extends Fragment {
	
	private Button btn_exercise_chapter = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_practise, container, false);
		btn_exercise_chapter = (Button)view.findViewById(R.id.btn_exercise_chapter);
		btn_exercise_chapter.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DB_Helper db_helper = new DB_Helper(PractiseFragment.this.getActivity(),"dangjiao",null,1);
				db_helper.getReadableDatabase();
				Intent intent = new Intent(PractiseFragment.this.getActivity(),ChapterExerciseActivity.class);
				startActivity(intent);
			}
			
		});
		return view;
	}
	
}
