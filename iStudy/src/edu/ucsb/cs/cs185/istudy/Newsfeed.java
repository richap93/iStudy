package edu.ucsb.cs.cs185.istudy;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Newsfeed extends ActionBarActivity {
	
	private List<Update> updatesList = new ArrayList<Update>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newsfeed);
		
		populateList();
		populateListView();
		
	}

	private void populateListView() {
		// TODO Auto-generated method stub
		ArrayAdapter<Update> adapter = new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.newsfeedList);
		
		list.setAdapter(adapter);
		
	}
	
	private class MyListAdapter extends ArrayAdapter<Update> {

		public MyListAdapter() {
			super(Newsfeed.this, R.layout.custom_list_view, updatesList);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			//make sure there's a view to work with
			View itemView = convertView;
			if (itemView == null) {
				itemView = getLayoutInflater().inflate(R.layout.custom_list_view, parent, false);
			}
			
			//find the update to work with
			Update currentUpdate = updatesList.get(position);
			
			
			//fill the view
			ImageView imageView = (ImageView) itemView.findViewById(R.id.profileIcon);
			imageView.setImageResource(currentUpdate.getIcon());
			
			//message
			TextView textMsg = (TextView)itemView.findViewById(R.id.tvMessage);
			textMsg.setText(currentUpdate.getMessage());
			
			//message content
			TextView textContent = (TextView)itemView.findViewById(R.id.tvContent);
			textContent.setText(currentUpdate.getContent());
			
			//date and time
			TextView textDate = (TextView)itemView.findViewById(R.id.tvDateTime);
			textDate.setText(currentUpdate.getDateTime());
			
			
			
			return itemView;
		}
	}

	private void populateList() {
		// TODO Auto-generated method stub
		updatesList.add(new Update("Sarah M. added text", "to Note1 under Tab1", "March 15, 2014 4:02 PM", R.drawable.sophia));
		updatesList.add(new Update("You added a photo", "to Note1 under Tab1", "March 15, 2014 3:30 PM", R.drawable.profile_pic));
		updatesList.add(new Update("Sarah M. added text", "to Note2 under Tab3", "March 15, 2014 3:05 PM", R.drawable.sophia));
		updatesList.add(new Update("Sarah M. created", "Note2 under Tab3", "March 14, 2014 8:59 AM", R.drawable.sophia));
		updatesList.add(new Update("You created", "Note1 under Tab1", "March 13, 2014 9:15 AM", R.drawable.profile_pic));

	}

	@Override
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
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if (id == R.id.home_button){ 
			Log.d("WTF", "I definitely clicked this");
			Intent goToHome = new Intent(Newsfeed.this, homepage.class);
			Newsfeed.this.startActivity(goToHome);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
