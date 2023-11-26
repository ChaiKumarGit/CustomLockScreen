package com.example.lockscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Lock extends Activity {
	
	String key;

	
	/* (non-Javadoc)
	 * @see android.app.Activity#onAttachedToWindow()
	 */
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
	}
	

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lock);
		
		Time today = new Time(Time.getCurrentTimezone());
		today.setToNow();
		String time =today.format("%k:%M:%S");
		TextView tv = (TextView) findViewById(R.id.TimeTextView);
		tv.setText(time);
		
		key="";
		key = key+((Integer.parseInt(today.format("%k"))%10)+1);
		key = key+((Integer.parseInt(today.format("%M"))%10)+1);
		key = key+((Integer.parseInt(today.format("%S"))%10)+1);
		key = key+((Integer.parseInt(today.format("%k"))%10)+2);
		
    }
   
   
    public void unlock(View view)
    {
    	EditText et = (EditText)findViewById(R.id.LockEditText);

    	if(key.equals(et.getText().toString()))
        	this.finish();
    	
    	et.setText("");
   
    }
    
    public void getUserKey(View view)
    {
    	EditText et = (EditText)findViewById(R.id.LockEditText);
    	Button bt = (Button)findViewById(view.getId());
    	String value = bt.getText().toString();
    	
    	et.setText(et.getText()+value);
    }
 }
    