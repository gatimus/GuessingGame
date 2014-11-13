package com.wl.guessinggame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Settings extends Activity implements OnClickListener {
	
	private int min;
	private int max;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			min = extras.getInt("min", 0);
			max = extras.getInt("max", 100);
		}
		intent = this.getIntent();
	}

	@Override
	public void onClick(View v) {
		intent.putExtra("min", min);
		intent.putExtra("max", max);
		this.setResult(RESULT_OK, intent);
		finish();
	}
	
	@Override
	public void onBackPressed() {
		this.setResult(RESULT_CANCELED, intent);
		super.onBackPressed();
	}
	
}
