package com.example.apms;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private EditText username;
	private EditText password;
	private Button login;
	private TextView loginLockedTV;
	private TextView attemptsLeftTV;
	private TextView numberOfRemainingLoginAttemptsTV;
	int numberOfRemainingLoginAttempts = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupVariables();
	}
	
	public void authenticateLogin(View view) {
		if (username.getText().toString().equals("admin") && 
				password.getText().toString().equals("admin")) {
			
			Intent i = new Intent(getApplicationContext(),ProjectMenu.class);
            startActivity(i);
			
			Toast.makeText(getApplicationContext(), "Hello admin!", 
			Toast.LENGTH_SHORT).show();
		}
		
		else if (username.getText().toString().equals("team") && 
				password.getText().toString().equals("team")) {
			
			Intent i = new Intent(getApplicationContext(),TeamLeaderLogin.class);
            startActivity(i);
			
			Toast.makeText(getApplicationContext(), "Hello Team Leader!", 
			Toast.LENGTH_SHORT).show();
		}
		
		
		else if (username.getText().toString().equals("developer") && 
				password.getText().toString().equals("developer")) {
			
			Intent i = new Intent(getApplicationContext(),DeveloperLogin.class);
            startActivity(i);
			
			Toast.makeText(getApplicationContext(), "Hello Developer!", 
			Toast.LENGTH_SHORT).show();
		
		}
		
		else if (username.getText().toString().equals("tester") && 
				password.getText().toString().equals("tester")) {
			
			Intent i = new Intent(getApplicationContext(),TesterLogin.class);
            startActivity(i);
			
			Toast.makeText(getApplicationContext(), "Hello Tester!", 
			Toast.LENGTH_SHORT).show();
		}
		
		else {
			Toast.makeText(getApplicationContext(), "Invalid Authentication", 
					Toast.LENGTH_SHORT).show();
			numberOfRemainingLoginAttempts--;
			attemptsLeftTV.setVisibility(View.VISIBLE);
			numberOfRemainingLoginAttemptsTV.setVisibility(View.VISIBLE);
			numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));
			
			if (numberOfRemainingLoginAttempts == 0) {
				login.setEnabled(false);
				loginLockedTV.setVisibility(View.VISIBLE);
				loginLockedTV.setBackgroundColor(Color.RED);
				loginLockedTV.setText("LOGIN LOCKED!!!");
			}
		}
	}

	private void setupVariables() {
		username = (EditText) findViewById(R.id.usernameET);
		password = (EditText) findViewById(R.id.passwordET);
		login = (Button) findViewById(R.id.loginBtn);
		loginLockedTV = (TextView) findViewById(R.id.loginLockedTV);
		attemptsLeftTV = (TextView) findViewById(R.id.attemptsLeftTV);
		numberOfRemainingLoginAttemptsTV = (TextView) findViewById(R.id.numberOfRemainingLoginAttemptsTV);
		numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));
	}
	
}
