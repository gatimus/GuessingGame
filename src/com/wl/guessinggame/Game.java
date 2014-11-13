package com.wl.guessinggame;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Game extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
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
		Dialog d = new Dialog(getApplicationContext());
        d.setContentView(R.layout.dialog);
        d.setTitle("This is custom dialog box");
        d.show(); 
	}
	
}
