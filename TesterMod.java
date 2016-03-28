package com.example.apms;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TesterMod extends Activity{
	
	EditText editid,editName,edituser,editpass,editphone;
	Button btnMod;
	SQLiteDatabase db;

	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.tester_modify);
	        editid=(EditText)findViewById(R.id.editText1);
	        editName=(EditText)findViewById(R.id.editText2);
	        edituser=(EditText)findViewById(R.id.editText3);
	        editpass=(EditText)findViewById(R.id.editText4);
	        editphone=(EditText)findViewById(R.id.editText5);
	        
	        btnMod=(Button)findViewById(R.id.button1);
	        
	        btnMod.setOnClickListener(onClickListener);
	       
	        db=openOrCreateDatabase("ProjectDB", Context.MODE_PRIVATE, null);
	        db.execSQL("CREATE TABLE IF NOT EXISTS tester(id VARCHAR,name VARCHAR,exp VARCHAR,addr VARCHAR,phone VARCHAR);");
	
	
	    }
	 private OnClickListener onClickListener = new OnClickListener() {
	     @Override 
	 public void onClick(View view)
	    {
		 if(view==btnMod)
	    	{
	    		if(editid.getText().toString().trim().length()==0)
	    		{
	    			showMessage("Error", "Please enter ID");
	    			return;
	    		}
	    		Cursor c=db.rawQuery("SELECT * FROM tester WHERE id='"+editid.getText()+"'", null);
	    		if(c.moveToFirst())
	    		{
	    			db.execSQL("UPDATE tester SET name='"+editName.getText()+"',exp='"+edituser.getText()+"',addr='"+editpass.getText()+"',phone='"+editphone.getText()+
	    					"' WHERE id='"+editid.getText()+"'");
	    			showMessage("Success", "Record Modified");
	    		}
	    		else
	    		{
	    			showMessage("Error", "Invalid id");
	    		}
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
	 
