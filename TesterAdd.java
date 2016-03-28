package com.example.apms;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TesterAdd extends Activity{
	
	EditText editid,editName,edituser,editpass,editphone;
	Button btnAdd;
	SQLiteDatabase db;

	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.tester_add);
	        editid=(EditText)findViewById(R.id.editText1);
	        editName=(EditText)findViewById(R.id.editText2);
	        edituser=(EditText)findViewById(R.id.editText3);
	        editpass=(EditText)findViewById(R.id.editText4);
	        editphone=(EditText)findViewById(R.id.editText5);
	        
	        btnAdd=(Button)findViewById(R.id.button1);
	        
	        btnAdd.setOnClickListener(onClickListener);
	        
	        db=openOrCreateDatabase("ProjectDB", Context.MODE_PRIVATE, null);
			db.execSQL("CREATE TABLE IF NOT EXISTS tester(id VARCHAR,name VARCHAR,exp VARCHAR,addr VARCHAR,phone VARCHAR);");
	
	    }
	 private OnClickListener onClickListener = new OnClickListener() {
	     @Override 
	 public void onClick(View view)
	    {
	    	if(view==btnAdd)
	    	{
	    		if(editid.getText().toString().trim().length()==0||
	    		   editName.getText().toString().trim().length()==0||
	    		   edituser.getText().toString().trim().length()==0||
	    	       editpass.getText().toString().trim().length()==0||
	    		   editphone.getText().toString().trim().length()==0)
	    		{
	    			showMessage("Error", "Please enter all values");
	    			return;
	    		}
	    		db.execSQL("INSERT INTO tester VALUES('"+editid.getText()+"','"+editName.getText()+"','"+edituser.getText()+"','"+editpass.getText()+"','"+editphone.getText()+"');");
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
	    	    	edituser.setText("");
	    	    	editpass.setText("");
	    	    	editphone.setText("");
	    	    	
	    	    	editid.requestFocus();
	    	    }
}
	 
