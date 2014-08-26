package edu.ucsb.cs.cs185.istudy;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		
		Button button_signin = (Button) findViewById(R.id.login_signinbutton);
		
		if (button_signin == null)
			Log.d("wtf", "button is null...fuck.");
		
		button_signin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent loginToHome = new Intent(MainActivity.this, homepage.class);
				MainActivity.this.startActivity(loginToHome);
			}
		});
		
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		switch(item.getItemId()) {
        case R.id.add_note:
        	Log.d("addnote","wtf");
            createNote();
            return true;
        case R.id.take_photo:
        	Log.d("takephoto","wtf");
        	takePhoto();
        	return true;
        case R.id.record_audio:
        	Log.d("recordaudio","wtf");
        	recordAudio();
        	return true;
    }
		
		return super.onOptionsItemSelected(item);
	}

	private void takePhoto() {
    	new AlertDialog.Builder(this).setTitle("Take Photo").setMessage("This is where you would take photos for notes").setNeutralButton(":/", new DialogInterface.OnClickListener() {
    		
    		@Override
    		public void onClick(DialogInterface dialog, int which) {
    			
    		}
    	}).show();
    }
    
    private void recordAudio() {
    	new AlertDialog.Builder(this).setTitle("Record Audio").setMessage("This is where you would record audio for notes").setNeutralButton(":/", new DialogInterface.OnClickListener() {
    		
    		@Override
    		public void onClick(DialogInterface dialog, int which) {
    			
    		}
    	}).show();
    }
    
    private void createNote() {
        Intent i = new Intent(this, NoteEdit.class);
        startActivityForResult(i, 0);
    }*/
	
}
