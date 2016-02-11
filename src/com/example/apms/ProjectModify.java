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

public class ProjectModify extends Activity {
	
	EditText editid,editName,editClient,editSdate,editEdate;
	Button btnMod;
	SQLiteDatabase db;

	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.project_modu);
	        editid=(EditText)findViewById(R.id.editid);
	        editName=(EditText)findViewById(R.id.editName);
	        editClient=(EditText)findViewById(R.id.editClient);
	        editSdate=(EditText)findViewById(R.id.editSDate);
	        editEdate=(EditText)findViewById(R.id.editEDate);
	        
	        btnMod=(Button)findViewById(R.id.btnMod);
	        
	        btnMod.setOnClickListener(onClickListener);
	        db=openOrCreateDatabase("ProjectDB", Context.MODE_PRIVATE, null);
			db.execSQL("CREATE TABLE IF NOT EXISTS project(id VARCHAR,name VARCHAR,client VARCHAR,sdate VARCHAR,edate VARCHAR);");
	
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
	    		Cursor c=db.rawQuery("SELECT * FROM project WHERE id='"+editid.getText()+"'", null);
	    		if(c.moveToFirst())
	    		{
	    			db.execSQL("UPDATE project SET name='"+editName.getText()+"',client='"+editClient.getText()+"',sdate='"+editSdate.getText()+"',edate='"+editEdate.getText()+
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
	    	    	editClient.setText("");
	    	    	editSdate.setText("");
	    	    	editEdate.setText("");
	    	    	editid.requestFocus();
	    	    }
}
	 
