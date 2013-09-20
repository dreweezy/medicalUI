package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class RecentReport extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recentreport);
        
        Button login = (Button) findViewById(R.id.recentReportBtn1);
        login.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(v.getContext(), ReportPage.class);
        		startActivityForResult(intent, 0);
        	}
        });
    }

	public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater in = getMenuInflater();
        in.inflate(R.menu.main, menu);
        return true;
    }
}
