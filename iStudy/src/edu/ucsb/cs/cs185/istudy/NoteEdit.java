
package edu.ucsb.cs.cs185.istudy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteEdit extends ActionBarActivity {

    private EditText mTitleText;
    private EditText mBodyText;
    private Long mRowId;
    private NotesDbAdapter mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_edit);
        setTitle(R.string.edit_note);

        mTitleText = (EditText) findViewById(R.id.title);
        mBodyText = (EditText) findViewById(R.id.body);
        mDbHelper = new NotesDbAdapter(this);
        mDbHelper.open();

        Button confirmButton = (Button) findViewById(R.id.confirm);

        mRowId = (savedInstanceState == null) ? null :
            (Long) savedInstanceState.getSerializable(NotesDbAdapter.KEY_ROWID);
        if (mRowId == null) {
            Bundle extras = getIntent().getExtras();
            mRowId = extras != null ? extras.getLong(NotesDbAdapter.KEY_ROWID)
                                    : null;
        }

        populateFields();
        
        confirmButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                
                setResult(RESULT_OK);
                finish();
                
            }

        });
    }
    
    @SuppressWarnings("deprecation")
	private void populateFields() {
        if (mRowId != null) {
            Cursor note = mDbHelper.fetchNote(mRowId);
            startManagingCursor(note);
            mTitleText.setText(note.getString(
                        note.getColumnIndexOrThrow(NotesDbAdapter.KEY_TITLE)));
            mBodyText.setText(note.getString(
                    note.getColumnIndexOrThrow(NotesDbAdapter.KEY_BODY)));
        }
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveState();
        outState.putSerializable(NotesDbAdapter.KEY_ROWID, mRowId);
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        saveState();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        populateFields();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.take_photo:
            	takePhoto();
            	return true;
            case R.id.record_audio:
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
    
      
    private void saveState() {
        String title = mTitleText.getText().toString();
        String body = mBodyText.getText().toString();

        if (mRowId == null) {
            long id = mDbHelper.createNote(title, body);
            if (id > 0) {
                mRowId = id;
            }
        } else {
            mDbHelper.updateNote(mRowId, title, body);
        }
    }
}
