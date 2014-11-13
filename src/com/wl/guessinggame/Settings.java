package com.wl.guessinggame;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;


public class Settings extends PreferenceActivity {
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
            super.onCreate(savedInstanceState);
    }
	

	@Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_headers, target);
    }
	

	public static class PrefsFragment extends PreferenceFragment {
		@Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
	            super.onCreate(savedInstanceState);
	            addPreferencesFromResource(R.xml.pref_general);
	    }
	}

}
