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

public class TeamModify extends Activity{
	
	EditText editid,editName,editTD,editTT;
	Button btnMod;
	SQLiteDatabase db;;

	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.team_mod);
	        editid=(EditText)findViewById(R.id.editText1);
	        editName=(EditText)findViewById(R.id.editText2);
	        editTD=(EditText)findViewById(R.id.editText3);
	        editTT=(EditText)findViewById(R.id.editText4);
	        
	        btnMod=(Button)findViewById(R.id.btnmod);
	        
	        btnMod.setOnClickListener(onClickListener);
	        db=openOrCreateDatabase("ProjectDB", Context.MODE_PRIVATE, null);
			db.execSQL("CREATE TABLE IF NOT EXISTS team(id VARCHAR,name VARCHAR,tdev VARCHAR,ttest VARCHAR);");
	
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
	    		Cursor c=db.rawQuery("SELECT * FROM team WHERE id='"+editid.getText()+"'", null);
	    		if(c.moveToFirst())
	    		{
	    			db.execSQL("UPDATE project SET name='"+editName.getText()+"',tdev='"+editTD.getText()+"',ttest='"+editTT.getText()+"' WHERE id='"+editid.getText()+"'");
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
	    	    	editTD.setText("");
	    	    	editTT.setText("");
	    	    	editid.requestFocus();
	    	    }
}
	 
