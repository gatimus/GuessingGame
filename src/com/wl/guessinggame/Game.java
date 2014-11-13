package com.wl.guessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Game extends ActionBarActivity implements OnClickListener {
	
	private final int SETTING_CODE = 2;
	private int min;
	private int max;
	private int number;
	private int guess;
	private int score;
	private Button btnGuess;
	private EditText inputGuess;
	private Toast toast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		min = 0;
		max = 100;
		score = 0;
		btnGuess = (Button) findViewById(R.id.btnGuess);
		btnGuess.setOnClickListener(this);
		inputGuess = (EditText) findViewById(R.id.editGuess);
		newGame();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch(id){
			case R.id.action_settings :
				openSettings();
				break;
			case R.id.action_quit :
				System.exit(0);
				break;
			default :
				return false;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void openSettings() {
		 Intent i = new Intent(getApplicationContext(), Settings.class);
		 i.putExtra("min", min);
		 i.putExtra("max", max);
		 startActivityForResult(i, SETTING_CODE);
	}

	@Override
	public void onClick(View v) {
		score ++;
		guess = Integer.parseInt(inputGuess.getText().toString());
		if(guess == number) {
			win();
		}
		else {
			toast = Toast.makeText(getApplicationContext(), "Score: " + String.valueOf(score), Toast.LENGTH_SHORT);
			toast.show();
		}
	}
	
	public void newGame() {
		number = min + (int)(Math.random() * ((max - min) + 1));
		score = 0;
		toast = Toast.makeText(getApplicationContext(), "New Game" + String.valueOf(number), Toast.LENGTH_LONG);
		toast.show();
	}
	
	public void win() {
		toast = Toast.makeText(getApplicationContext(), "You Won! In " + String.valueOf(score) + " tries.", Toast.LENGTH_LONG);
		toast.show();
		newGame();
	}
	
	@Override
	public void onActivityResult(int RequestCode, int resultCode, Intent settingData) {
		super.onActivityResult(RequestCode, resultCode, settingData);
		
	}
	
}
