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

public class TesterView extends Activity{
	
	TextView t1,t2,t3,t4,t5;
	EditText editid;
	Button btnView,btnViewall;
	SQLiteDatabase db;

	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.tester_view);
	        
	        t1=(TextView)findViewById(R.id.textView4);
	        t2=(TextView)findViewById(R.id.textView1);
	        t3=(TextView)findViewById(R.id.textView2);
	        t4=(TextView)findViewById(R.id.textView3);
	        t5=(TextView)findViewById(R.id.textView5);
	        
	        editid=(EditText)findViewById(R.id.editid);
	        
	        btnView=(Button)findViewById(R.id.btnView);
	        
	        btnView.setOnClickListener(onClickListener);
	        
	        btnViewall=(Button)findViewById(R.id.btnViewall);
	        
	        btnViewall.setOnClickListener(onClickListener);
	        
	        db=openOrCreateDatabase("ProjectDB", Context.MODE_PRIVATE, null);
	        db.execSQL("CREATE TABLE IF NOT EXISTS tester(id VARCHAR,name VARCHAR,exp VARCHAR,addr VARCHAR,phone VARCHAR);");
	    }

	 private OnClickListener onClickListener = new OnClickListener() {
	     @Override 
	 public void onClick(View view)
	    {
		 if(view==btnView)
	    	{
	    		if(editid.getText().toString().trim().length()==0)
	    		{
	    			showMessage("Error", "Please enter id");
	    			return;
	    		}
	    		Cursor c=db.rawQuery("SELECT * FROM tester WHERE id='"+editid.getText()+"'", null);
	    		if(c.moveToFirst())
	    		{
	    			t1.setText("ID : "+c.getString(0));
	    			t2.setText("NAME : "+c.getString(1));
	    			t3.setText("EXPERIENCE : "+c.getString(2));
	    			t4.setText("ADDRESS : "+c.getString(3));
	    			t5.setText("PHONE : "+c.getString(4));
	    			
	    		}
	    		
	    		else
	    		{
	    			showMessage("Error", "Invalid Id");
	    			clearText();
	    		}
	    	}
	    	if(view==btnViewall)
	    	{
	    		Cursor c=db.rawQuery("SELECT * FROM tester", null);
	    		if(c.getCount()==0)
	    		{
	    			showMessage("Error", "No records found");
	    			return;
	    		}
	    		StringBuffer buffer=new StringBuffer();
	    		while(c.moveToNext())
	    		{
	    			buffer.append("Id		: "+c.getString(0)+"\n");
	    			buffer.append("Name		: "+c.getString(1)+"\n");
	    			buffer.append("Experience: "+c.getString(2)+"\n");
	    			buffer.append("Address	: "+c.getString(3)+"\n");
	    			buffer.append("Phone	: "+c.getString(4)+"\n\n");
	    		}
	    		showMessage("Tester Details", buffer.toString());
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
	    	t1.setText("");
	    	t2.setText("");
	    	t3.setText("");
	    	t4.setText("");
	    	t5.setText("");
	    	editid.requestFocus();
	    }
}

