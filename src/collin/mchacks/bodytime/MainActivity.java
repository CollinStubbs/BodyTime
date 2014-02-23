package collin.mchacks.bodytime;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity implements OnClickListener {

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
	 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@SuppressLint("ResourceAsColor")
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.alarm:
			LinearLayout layout = (LinearLayout)findViewById(R.id.layout1);
			layout.setGravity(Gravity.CENTER_HORIZONTAL);
			
			TextView alarmSet = new TextView(this);
			alarmSet.setText("What time does your\n gym open and close?");
			alarmSet.setTextColor(R.color.black);
			alarmSet.setTextSize(22);
			alarmSet.setPadding(0,20,0,20);
			layout.addView(alarmSet);
			
			TimePicker openTime = new TimePicker(this);
			layout.addView(openTime);
					break;
		case R.id.gymfind:
			break;
		}
	}

}
