package com.example.test;


import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


public class MainMenu extends ListActivity {
	
	String classNames[] = { "SelectPatient", "ReportPage", "RecentReport" };
	EditText editSearch;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classNames));
        
    }
    
	public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater in = getMenuInflater();
        in.inflate(R.menu.main, menu);
        
        
        return true;

        
    }
	
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.settings:
			Intent intent = new Intent(this, Settings.class);
			startActivity(intent);
			break;
		case R.id.logout:
			Intent backToLogIn = new Intent(this, MainActivity.class);
			startActivity(backToLogIn);
			Toast.makeText(getApplicationContext(), "You have successfully logged out.", Toast.LENGTH_LONG).show();
			break;
		case R.id.create:
			Intent create = new Intent(this, CreateReport.class);
			startActivity(create);
			break;
		case R.id.view:
			break;
		}
		
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String click = classNames[position];
		
		try {
		Class thisClass = Class.forName("com.example.test." + click);
		Intent intent = new Intent(this, thisClass);
		startActivity(intent);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	} 

}
