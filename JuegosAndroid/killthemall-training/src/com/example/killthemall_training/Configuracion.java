package com.example.killthemall_training;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;


public class Configuracion extends PreferenceActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	addPreferencesFromResource(R.xml.settings);
	}
	
	public static boolean getMusic(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
		.getBoolean("música", true);
		}


}