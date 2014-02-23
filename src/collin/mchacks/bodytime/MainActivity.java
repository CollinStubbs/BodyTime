package collin.mchacks.bodytime;

import java.util.Calendar;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.TimePicker;



public class MainActivity extends Activity implements OnClickListener {
	LinearLayout layout;
	AlarmManager morningAlarm;
	AlarmManager nightAlarm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 Typeface t = Typeface.createFromAsset(getAssets(),
	               "KiloGram_KG.otf");
		 TextView title = (TextView) findViewById(R.id.title);
	     title.setTypeface(t);
	     
	     Button alarm = (Button)findViewById(R.id.alarm);
	     alarm.setOnClickListener(this);
	     
	     layout = (LinearLayout)findViewById(R.id.layout1);
	    morningAlarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
	    nightAlarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@SuppressLint({ "ResourceAsColor", "NewApi" })
	@Override
	public void onClick(View arg0) {
		layout.removeAllViewsInLayout();
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.alarm:
			Calendar morn = Calendar.getInstance();
			Calendar night = Calendar.getInstance();
			layout.setGravity(Gravity.CENTER_HORIZONTAL);
			
			TextView alarmSet = new TextView(this);
			alarmSet.setText("What time does your\n gym open and close?");
			alarmSet.setTextColor(R.color.black);
			alarmSet.setTextSize(22);
			alarmSet.setPadding(40,20,0,20);
			layout.addView(alarmSet);
			
			TextView alarmO = new TextView(this);
			alarmO.setText("Opening:");
			alarmO.setTextColor(R.color.black);
			alarmO.setTextSize(17);
			alarmO.setPadding(20,20,0,10);
			layout.addView(alarmO);
			
			TimePicker openTime = new TimePicker(this);
			layout.addView(openTime);
			morn.set(Calendar.HOUR_OF_DAY, openTime.getCurrentHour());
		    morn.set(Calendar.MINUTE, openTime.getCurrentMinute());
		    morn.set(Calendar.SECOND, 0);
		    morn.set(Calendar.MILLISECOND, 0);
			
			TextView alarmC = new TextView(this);
			alarmC.setText("Closing:");
			alarmC.setTextColor(R.color.black);
			alarmC.setTextSize(17);
			alarmC.setPadding(20,20,0,10);
			layout.addView(alarmC);
			
			TimePicker closeTime = new TimePicker(this);
			closeTime.setPadding(0,0,0,85);
			layout.addView(closeTime);
			night.set(Calendar.HOUR_OF_DAY, closeTime.getCurrentHour());
		    night.set(Calendar.MINUTE, closeTime.getCurrentMinute());
		    night.set(Calendar.SECOND, 0);
		    night.set(Calendar.MILLISECOND, 0);
			
			RelativeLayout.LayoutParams rel_btn = new RelativeLayout.LayoutParams(
		            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			
			Button set = new Button(this);
			set.setPadding(30, 20, 30, 20);
			set.setLayoutParams(rel_btn);
			set.setTextSize(20);
			set.setText("Set Reminder Alarm");
			set.setTextColor(Color.WHITE);
			set.setBackgroundResource(R.drawable.fadebutton);
			layout.addView(set);
			set.setOnClickListener(new OnClickListener() {           

				  @Override
				  public void onClick(View v) 
				  {
				      
				  }    
				});
					break;
		case R.id.gymfind:
			break;
		}
	}

}
