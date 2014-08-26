package edu.ucsb.cs.cs185.istudy;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class dayScheduler extends ActionBarActivity {

	
	
	int mHour = 15;
    int mMinute = 15;
 
//    /** This handles the message send from TimePickerDialogFragment on setting Time */
//    Handler mHandler = new Handler(){
//        @Override
//        public void handleMessage(Message m){
//            /** Creating a bundle object to pass currently set Time to the fragment */
//            Bundle b = m.getData();
// 
//            /** Getting the Hour of day from bundle */
//            mHour = b.getInt("set_hour");
// 
//            /** Getting the Minute of the hour from bundle */
//            mMinute = b.getInt("set_minute");
// 
//            /** Displaying a short time message containing time set by Time picker dialog fragment */
//            Toast.makeText(getBaseContext(), b.getString("set_time"), Toast.LENGTH_SHORT).show();
//        }
//    };
 
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daysched);
	
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

//		/** Click Event Handler for button */
//        OnClickListener listener = new OnClickListener() {
//            @Override
//            public void onClick(View v) {
// 
//                /** Creating a bundle object to pass currently set time to the fragment */
//                Bundle b = new Bundle();
// 
//                /** Adding currently set hour to bundle object */
//                b.putInt("set_hour", mHour);
// 
//                /** Adding currently set minute to bundle object */
//                b.putInt("set_minute", mMinute);
// 
//                /** Instantiating TimePickerDialogFragment */
//                //setEventDialogFragment timePicker = new setEventDialogFragment(mHandler);
//                setEventDialogFragment timePicker = new setEventDialogFragment();
// 
//                /** Setting the bundle object on timepicker fragment */
//                timePicker.setArguments(b);
// 
//                /** Getting fragment manger for this activity */
//                FragmentManager fm = getSupportFragmentManager();
// 
//                /** Starting a fragment transaction */
//                FragmentTransaction ft = fm.beginTransaction();
// 
//                /** Adding the fragment object to the fragment transaction */
//                ft.add(timePicker, "time_picker");
// 
//                /** Opening the TimePicker fragment */
//                ft.commit();
//            }
            
            
//        };
 
        

        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dayscheduler, menu);
		return true;
	}

	
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}else if(id == R.id.action_addevent){
			//setEventDialogFragment newFragment = new setEventDialogFragment(mHandler);
			setEventDialogFragment newFragment = new setEventDialogFragment();
			newFragment.show(getSupportFragmentManager(), "Add Event");
			
			
			
			
			
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_daysched, container,
					false);
			return rootView;
		}
	}

}

