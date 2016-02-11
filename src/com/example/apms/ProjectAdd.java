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

public class ProjectAdd extends Activity
{
	
	EditText editid,editName,editClient,editSdate,editEdate;
	Button btnAdd;
	SQLiteDatabase db;

	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.project_add);
	        editid=(EditText)findViewById(R.id.editid);
	        editName=(EditText)findViewById(R.id.editName);
	        editClient=(EditText)findViewById(R.id.editClient);
	        editSdate=(EditText)findViewById(R.id.editSDate);
	        editEdate=(EditText)findViewById(R.id.editEDate);
	        
	        btnAdd=(Button)findViewById(R.id.btnAdd);
	        
	        btnAdd.setOnClickListener(onClickListener);
	        db=openOrCreateDatabase("ProjectDB", Context.MODE_PRIVATE, null);
			db.execSQL("CREATE TABLE IF NOT EXISTS project(id VARCHAR,name VARCHAR,client VARCHAR,sdate VARCHAR,edate VARCHAR);");
			
	
	    }
	 private OnClickListener onClickListener = new OnClickListener() {
	     @Override 
	 public void onClick(View view)
	    {
	    	if(view==btnAdd)
	    	{
	    		if(editid.getText().toString().trim().length()==0||
	    		   editName.getText().toString().trim().length()==0||
	    		   editClient.getText().toString().trim().length()==0||
	    		   editSdate.getText().toString().trim().length()==0||
	    		   editEdate.getText().toString().trim().length()==0)
	    		{
	    			showMessage("Error", "Please enter all values");
	    			return;
	    		}
	    		db.execSQL("INSERT INTO project VALUES('"+editid.getText()+"','"+editName.getText()+"','"+editClient.getText()+"','"+editSdate.getText()+"','"+editEdate.getText()+"');");
	    		showMessage("Success", "Record added");
	    		clearText();//clears all
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
	 
