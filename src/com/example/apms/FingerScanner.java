package com.example.apms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;

public class FingerScanner extends Activity {

	ImageView finger;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fingerprint);
	
	finger = (ImageView) findViewById(R.id.finger);
	finger.setOnLongClickListener(new OnLongClickListener() {

		@Override
		public boolean onLongClick(View arg0) {
			
			Intent i = new Intent(getApplicationContext(),ProjectLogin.class);
            startActivity(i);
			
			return false;
		}
	});
	
}
}

