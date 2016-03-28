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
import android.widget.TextView;

public class TesterDelete extends Activity{
	
	EditText editid;
	Button btnDelete;
	SQLiteDatabase db;

	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.tester_delete);
	       
	        
	        editid=(EditText)findViewById(R.id.editid);
	        
	        btnDelete=(Button)findViewById(R.id.btnDelete);
	        
	        btnDelete.setOnClickListener(onClickListener);
	       
	        
	        db=openOrCreateDatabase("ProjectDB", Context.MODE_PRIVATE, null);
	        db.execSQL("CREATE TABLE IF NOT EXISTS tester(id VARCHAR,name VARCHAR,exp VARCHAR,addr VARCHAR,phone VARCHAR);");
	    }
	 
	 private OnClickListener onClickListener = new OnClickListener() {
	     @Override 
	 public void onClick(View view)
	    {
		 if(view==btnDelete)
	    	{
	    		if(editid.getText().toString().trim().length()==0)
	    		{
	    			showMessage("Error", "Please enter ID");
	    			return;
	    		}
	    		Cursor c=db.rawQuery("SELECT * FROM tester WHERE id='"+editid.getText()+"'", null);
	    		if(c.moveToFirst())
	    		{
	    			db.execSQL("DELETE FROM tester WHERE id='"+editid.getText()+"'");
	    			showMessage("Success", "Record Deleted");
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
	    	editid.requestFocus();
	    }
}

