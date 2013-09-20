package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateReport extends Activity {
	ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createreport);
        
        image = (ImageView) findViewById(R.id.imageView);
        
        Button cameraButton = (Button) findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        		startActivityForResult(intent, 0);
        	}
        });
        
        Button saveAndExit = (Button) findViewById(R.id.saveAndExit);
        saveAndExit.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		
        		Intent intent = new Intent(v.getContext(), MainMenu.class);
        		startActivityForResult(intent, 0);
        		Toast.makeText(getApplicationContext(), "You have successfully saved.", Toast.LENGTH_LONG).show();
        	}
        });
    }

	public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater in = getMenuInflater();
        in.inflate(R.menu.main, menu);
        return true;
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == 0) {
			
			Bitmap theImage = (Bitmap) data.getExtras().get("data");
			image.setImageBitmap(theImage);
		}
	}
	
}
