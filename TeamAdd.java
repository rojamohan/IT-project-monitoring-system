package com.example.apms;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class TeamAdd extends Activity{
	
	EditText editid,editName,editTD,editTT;
	Button btnAdd;
	SQLiteDatabase db;;

	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.team_add);
	        editid=(EditText)findViewById(R.id.editText1);
	        editName=(EditText)findViewById(R.id.editText2);
	        editTD=(EditText)findViewById(R.id.editText3);
	        editTT=(EditText)findViewById(R.id.editText4);
	        
	        btnAdd=(Button)findViewById(R.id.btnteamAdd);
	        
	        btnAdd.setOnClickListener(onClickListener);
	        db=openOrCreateDatabase("ProjectDB", Context.MODE_PRIVATE, null);
			db.execSQL("CREATE TABLE IF NOT EXISTS team(id VARCHAR,name VARCHAR,tdev VARCHAR,ttest VARCHAR);");
	
	    }
	 private OnClickListener onClickListener = new OnClickListener() {
	     @Override 
	 public void onClick(View view)
	    {
	    	if(view==btnAdd)
	    	{
	    		if(editid.getText().toString().trim().length()==0||
	    		   editName.getText().toString().trim().length()==0||
	    		   editTD.getText().toString().trim().length()==0||
	    		   editTT.getText().toString().trim().length()==0)
	    		{
	    			showMessage("Error", "Please enter all values");
	    			return;
	    		}
	    		db.execSQL("INSERT INTO team VALUES('"+editid.getText()+"','"+editName.getText()+"','"+editTD.getText()+"','"+editTT+"');");
	    		showMessage("Success", "Record added");
	    		clearText();
	    	}
	    }
	 };
	    	 public void showMessage(String title,String message)
	    	    {
	    	    	Builder builder=new Builder(this);
	    	    	builder.setCancelable(true);
	    	    	builder.setTitle(title);
	    	    	builder.setMessage(message);
	    	    	builder.show();
	    		}
	    	    public void clearText()
	    	    {
	    	    	editid.setText("");
	    	    	editName.setText("");
	    	    	editTD.setText("");
	    	    	editTT.setText("");
	    	    	editid.requestFocus();
	    	    }
}
	 
