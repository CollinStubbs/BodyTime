package collin.mchacks.bodytime;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.google.android.gms.location.LocationClient;

import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.telephony.TelephonyManager;
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
import android.widget.Toast;



public class MainActivity extends Activity implements OnClickListener {
	LinearLayout layout;
	int hour, min;
	TimePicker openTime;
	TimePicker myTimePicker;
    TimePickerDialog timePickerDialog;
    private LocationClient mLocationClient;
    private Location mCurrentLocation;

    final static int RQS_1 = 1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 Typeface t = Typeface.createFromAsset(getAssets(),
	               "KiloGram_KG.otf");
		 TextView title = (TextView) findViewById(R.id.title);
	     title.setTypeface(t);
	     
	     Button al = (Button)findViewById(R.id.al);
	     al.setOnClickListener(this);
	     
	    layout = (LinearLayout)findViewById(R.id.layout1);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

//	@SuppressLint({ "ResourceAsColor", "NewApi" })
	@Override
	public void onClick(View arg0) {
		
		layout.removeAllViewsInLayout();
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.al:
	
			
			layout.setGravity(Gravity.CENTER_HORIZONTAL);
			
			TextView alarmSet = new TextView(this);
			alarmSet.setText("When are you going \nto go to the gym?");
			alarmSet.setTextColor(Color.BLACK);
			alarmSet.setTextSize(22);
			alarmSet.setPadding(80,20,0,120);
			layout.addView(alarmSet);
			
			
			openTime = new TimePicker(this);
			layout.addView(openTime);
			
			TextView alarmC = new TextView(this);
			alarmC.setText(" ");
			alarmC.setTextColor(Color.BLACK);
			alarmC.setTextSize(17);
			alarmC.setPadding(20,20,0,90);
			layout.addView(alarmC);
			
			
		    

		 
		
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
					  hour = openTime.getCurrentHour();
					  min = openTime.getCurrentMinute();
					  Intent i = new Intent(AlarmClock.ACTION_SET_ALARM); 
					  i.putExtra(AlarmClock.EXTRA_MESSAGE, "Time to go to the gym!"); 
					  i.putExtra(AlarmClock.EXTRA_HOUR, hour); 
					  i.putExtra(AlarmClock.EXTRA_MINUTES, min); 
					  startActivity(i); 
					  mCurrentLocation = new Location("you");
					  Location aloc = new Location("mcgill");
					  aloc.setLatitude(45.504813);
					  aloc.setLongitude(-73.576215);
					 // mCurrentLocation = mLocationClient.getLastLocation();
					  //if(mCurrentLocation == null){
					//	  Toast.makeText(getApplicationContext(), "NULL",
					//			   Toast.LENGTH_LONG).show();
					 // }
					  
					  Location locationb = new Location("the gym");
					  locationb.setLatitude(
							  45.501399);
					  locationb.setLongitude(-73.571194);
					  float distance = aloc.distanceTo(locationb);
					  if(distance>5000){
						  TelephonyManager tMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
						  String mPhoneNumber = tMgr.getLine1Number();
						  Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "sms:" + mPhoneNumber ) );
						  intent.putExtra( "sms_body", "HAH, over 5 km's from the gym? Stay average." ); startActivity( intent );
						  
					  }else{
						  Toast.makeText(getApplicationContext(), "You're so close! Don't Give up!",
								   Toast.LENGTH_LONG).show();
					  }
					  
				      
				  }    
				});
				break;
		case R.id.gymfind:
			break;
		}
		
	}
 
}
