package edu.ucsb.cs.cs185.istudy;

 
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
 

public class setEventDialogFragment extends DialogFragment {
    Handler mHandler ;
    int mHour;
    int mMinute;
    	
    	
    	
    	@Override
    	public Dialog onCreateDialog(Bundle savedInstanceState){
            /** Creating a bundle object to pass currently set time to the fragment */
    		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    	    LayoutInflater inflater = getActivity().getLayoutInflater();

    	    View view = inflater.inflate(R.layout.fragment_seteventdialog, null);
//            Bundle b = getArguments();
//     
//            /** Getting the hour of day from bundle */
//            mHour = b.getInt("set_hour");
//     
//            /** Getting the minute of hour from bundle */
//            mMinute = b.getInt("set_minute");
//     
//            TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
//            	@Override
//                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//     
//                    mHour = hourOfDay;
//                    mMinute = minute;
//     
//                    /** Creating a bundle object to pass currently set time to the fragment */
//                    Bundle b = new Bundle();
//     
//                    /** Adding currently set hour to bundle object */
//                    b.putInt("set_hour", mHour);
//                    
//     
//                    /** Adding currently set minute to bundle object */
//                    b.putInt("set_minute", mMinute);
//     
//                    /** Adding Current time in a string to bundle object */
//                    b.putString("set_time", "Set Time : " + Integer.toString(mHour) + " : " + Integer.toString(mMinute));
//     
//                    /** Creating an instance of Message */
//                    Message m = new Message();
//     
//                    /** Setting bundle object on the message object m */
//                    m.setData(b);
//     
//                    /** Message m is sending using the message handler instantiated in MainActivity class */
//                    mHandler.sendMessage(m);
//            }
//    	};
    	    
//    	    final TimePicker st = (TimePicker) (R.id.startTime;
//    		final TimePicker et = (TimePicker) findViewById(R.id.endTime);
    	    
    	    builder.setTitle("New Event").setView(inflater.inflate(R.layout.fragment_seteventdialog, null)).setPositiveButton("SET", new DialogInterface.OnClickListener(){
    	    	public void onClick(DialogInterface dialog, int id){
    	    		
//    	    		String newEvent = st.getCurrentHour() + ":" + st.getCurrentMinute() + " - " + et.getCurrentHour() + ":" + et.getCurrentMinute();
//    				
//    				Toast.makeText(dayScheduler.this, newEvent, Toast.LENGTH_LONG).show();
    	    	}
    	    })
    	    .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
    	    	public void onClick(DialogInterface dialog, int d){
    	    		
    	    	}
    	    });
    	
    	return builder.create();
//    		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//    		
//    		builder.setMessage(R.string.action_settings).setNeutralButton("ok", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int id) {
//                    // User cancelled the dialog
//                }
//            });
//    		return builder.create();
    	}
    
    
}