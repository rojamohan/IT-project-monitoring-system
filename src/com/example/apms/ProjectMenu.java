package com.example.apms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProjectMenu extends Activity {

	 Button add,views,modify,delete;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.project_project);
		
		add = (Button) findViewById(R.id.btnAdd);
		views = (Button) findViewById(R.id.btnView);
		modify = (Button) findViewById(R.id.btnModify);
		delete = (Button) findViewById(R.id.btnDelete);
		
		add.setOnClickListener(onClickListener);
		views.setOnClickListener(onClickListener);
		modify.setOnClickListener(onClickListener);
		delete.setOnClickListener(onClickListener);
		
	}
	
	
	private OnClickListener onClickListener = new OnClickListener() {
	     @Override
	     public void onClick(View v) {
	         switch(v.getId()){
	             case R.id.btnAdd:
	            	 	Intent intent = new Intent(ProjectMenu.this, ProjectAdd.class);
	            	    startActivity(intent);
	             break;
	             case R.id.btnView:
	            	 Intent intent1 = new Intent(ProjectMenu.this, ProjectView.class);
	            	 startActivity(intent1);
	             break;
	             case R.id.btnModify:
	            	 Intent intent2 = new Intent(ProjectMenu.this, ProjectModify.class);
	            	    startActivity(intent2);
	             break;
	             case R.id.btnDelete:
	            	 Intent intent3 = new Intent(ProjectMenu.this, ProjectDelete.class);
	            	    startActivity(intent3);
	             break;
	         } 
	  	   }
	 	};

}