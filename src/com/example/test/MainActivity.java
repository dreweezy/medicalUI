package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        Button login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(v.getContext(), MainMenu.class);
        		startActivityForResult(intent, 0);
        		
        		Toast toast = Toast.makeText(getApplicationContext(), "Logged in as ____", Toast.LENGTH_LONG);
        		toast.setGravity(Gravity.TOP|Gravity.RIGHT, 0, 0);
        		toast.show();
        	}
        });
    }
    
}
