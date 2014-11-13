package com.wl.guessinggame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class Splash extends Activity implements OnClickListener{
	
	private CheckBox accept;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		accept = (CheckBox) findViewById(R.id.checkBox);
		accept.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(accept.isChecked()) {
			Intent i = new Intent(getApplicationContext(),Game.class);
			startActivity(i);
			finish();
		}
	}
	
}