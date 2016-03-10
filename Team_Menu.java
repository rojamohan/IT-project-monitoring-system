package com.example.apms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Team_Menu extends Activity {

	 Button add,views,modify,delete;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.team_menu);
		
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
	            	 	Intent intent = new Intent(Team_Menu.this, TeamAdd.class);
	            	    startActivity(intent);
	             break;
	             case R.id.btnView:
	            	 Intent intent1 = new Intent(Team_Menu.this, TeamView.class);
	            	 startActivity(intent1);
	             break;
	             case R.id.btnModify:
	            	 Intent intent2 = new Intent(Team_Menu.this, TeamModify.class);
	            	    startActivity(intent2);
	             break;
	             case R.id.btnDelete:
	            	 Intent intent3 = new Intent(Team_Menu.this, TeamDelete.class);
	            	    startActivity(intent3);
	             break;
	         } 
	  	   }
	 	};

}