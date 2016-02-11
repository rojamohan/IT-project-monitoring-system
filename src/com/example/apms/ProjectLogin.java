package com.example.apms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProjectLogin extends Activity {

	private Button project,team,developer,tester,settings,feedback,about,help;
	
		protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.project_login);
		project = (Button) findViewById(R.id.Button01);
		team = (Button) findViewById(R.id.button1);
		developer = (Button) findViewById(R.id.Button02);
		tester = (Button) findViewById(R.id.Button03);
		settings = (Button) findViewById(R.id.Button05);
		feedback = (Button) findViewById(R.id.Button04);
		about = (Button) findViewById(R.id.Button07);
		help=(Button) findViewById(R.id.Button06);
		
		project.setOnClickListener(onClickListener);
		team.setOnClickListener(onClickListener);
		developer.setOnClickListener(onClickListener);
		tester.setOnClickListener(onClickListener);
		settings.setOnClickListener(onClickListener);
		feedback.setOnClickListener(onClickListener);
		about.setOnClickListener(onClickListener);
		help.setOnClickListener(onClickListener);
		
	}

	
	
	private OnClickListener onClickListener = new OnClickListener() {
	     @Override
	     public void onClick(View v) {
	         switch(v.getId()){
	             case R.id.Button01:
	            	 Intent intent = new Intent(ProjectLogin.this, ProjectMenu.class);
	            	    startActivity(intent);
	             break;
	             case R.id.button1:
	                  //DO something
	             break;
	             case R.id.Button02:
	                  //DO something
	             break;
	             case R.id.Button03:
	                  //DO something
	             break;
	             case R.id.Button05:
	                  //DO something
	             break;
	             case R.id.Button04:
	                  //DO something
	             break;
	             case R.id.Button07:
	                  //DO something
	             break;
	             case R.id.Button06:
	                  //DO something
	             break;
	             
	         }

	   }
	};

	
}

