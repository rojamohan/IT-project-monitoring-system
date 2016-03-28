package com.example.apms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TesterLogin extends Activity {

	 Button testst,feed,about,settings,help;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tester_login);
		
		testst = (Button) findViewById(R.id.button1);
		feed = (Button) findViewById(R.id.button2);
		about = (Button) findViewById(R.id.button3);
		settings = (Button) findViewById(R.id.button4);
		help = (Button) findViewById(R.id.button5);
		
		testst.setOnClickListener(onClickListener);
		feed.setOnClickListener(onClickListener);
		about.setOnClickListener(onClickListener);
		settings.setOnClickListener(onClickListener);
		help.setOnClickListener(onClickListener);
		
	}
	
	
	private OnClickListener onClickListener = new OnClickListener() {
	     @Override
	     public void onClick(View v) {
	         switch(v.getId()){
	             case R.id.button1:
	            	 	Intent intent = new Intent(TesterLogin.this, ProjectTestStatus.class);
	            	    startActivity(intent);
	             break;
	             case R.id.button2:
	            	 Intent intent5 = new Intent(TesterLogin.this, Feedback.class);
	            	    startActivity(intent5);
	             break;
	             case R.id.button3:
	            	 Intent intent4 = new Intent(TesterLogin.this, About.class);
	            	    startActivity(intent4);
	             break;
	             case R.id.button4:
	            	 Intent intent3 = new Intent(TesterLogin.this, SettingsActivity.class);
	            	    startActivity(intent3);
	             break;
	             case R.id.button5:
	            	 Intent intent6 = new Intent(TesterLogin.this, UserManual.class);
	            	    startActivity(intent6);
	             break;
	         } 
	  	   }
	 	};

}