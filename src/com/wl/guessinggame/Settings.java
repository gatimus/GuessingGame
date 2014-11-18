package com.wl.guessinggame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class Settings extends Activity implements OnClickListener, OnEditorActionListener  {
	
	private int min;
	private int max;
	private Intent intent;
	private Button btnSet;
	private EditText etMin;
	private EditText etMax;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			min = extras.getInt("min", 0);
			max = extras.getInt("max", 100);
		}
		btnSet = (Button) findViewById(R.id.btnSet);
		btnSet.setOnClickListener(this);
		etMin = (EditText) findViewById(R.id.etMin);
		etMin.setOnEditorActionListener(this);
		etMax = (EditText) findViewById(R.id.etMax);
		etMax.setOnEditorActionListener(this);
		etMin.setText(String.valueOf(min));
		etMax.setText(String.valueOf(max));
		intent = this.getIntent();
	}

	@Override
	public void onClick(View v) {
		min = Integer.parseInt(etMin.getText().toString());
		max = Integer.parseInt(etMax.getText().toString());
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

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		if (actionId == EditorInfo.IME_ACTION_DONE) {
			onClick(btnSet);
		}
		return false;
	}
	
}
