package edu.ucsb.cs.cs185.istudy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class homepage extends ActionBarActivity implements OnItemClickListener {

	private ActionBarDrawerToggle drawerListener;
	private DrawerLayout drawerLayout;
	private ListView featuresList;
	private String[] features;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		
//		if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.mainContent, new HomeFragment())
//                    .commit();
//        }
		
		
		//set the action bar color
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(0xff8CD025));
		bar.setDisplayShowTitleEnabled(false);
		bar.setDisplayShowTitleEnabled(true);

		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

		//		drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

		ListView mDrawerList = (ListView) findViewById(R.id.drawerList);

		//making sure the sidebar only covers half the screen
		int width = getResources().getDisplayMetrics().widthPixels/2;
		DrawerLayout.LayoutParams params = (android.support.v4.widget.DrawerLayout.LayoutParams) mDrawerList.getLayoutParams();
		params.width = width;
		mDrawerList.setLayoutParams(params);

		features = getResources().getStringArray(R.array.features);
		featuresList = (ListView) findViewById(R.id.drawerList);
		featuresList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, features));

		featuresList.setOnItemClickListener(this);


		drawerListener = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.side_bar, R.string.openDrawer, R.string.closeDrawer){
			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerOpened(drawerView);
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(drawerView);
			}

		};

		drawerLayout.setDrawerListener(drawerListener);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		drawerListener.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.richa_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		if (drawerListener.onOptionsItemSelected(item)) {
			return true;
		}
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		switch (position) {
		case 0:
					    //Intent intent0 = new Intent(homepage.this, Newsfeed.class);
					    //startActivity(intent0);
			Toast.makeText(this, features[position]+" was selected", Toast.LENGTH_SHORT).show();
			break;
		case 1:
					    Intent intent = new Intent(homepage.this, Newsfeed.class);
					    startActivity(intent);
					    break;
			//Toast.makeText(this, features[position]+" was selected", Toast.LENGTH_SHORT).show();

		case 2:
			Intent intent_sched = new Intent(homepage.this, scheduler.class);
			startActivity(intent_sched);
						
			//Toast.makeText(this, features[position]+" was selected", Toast.LENGTH_SHORT).show();
			break;

		case 4:
					    Intent intent2 = new Intent(homepage.this, Notepad.class);
					    startActivity(intent2);
			//Toast.makeText(this, features[position]+" was selected", Toast.LENGTH_SHORT).show();
			break;

		case 8:
			//		    Intent intent = new Intent(Homepage.this, ToActivity.class);
			//		    startActivity(intent);
			Toast.makeText(this, features[position]+" was selected", Toast.LENGTH_SHORT).show();
			break;

		case 9:
					    Intent intent3 = new Intent(homepage.this, NoteEdit.class);
					    startActivity(intent3);
			//Toast.makeText(this, features[position]+" was selected", Toast.LENGTH_SHORT).show();
			break;

		}
	}

	    /**
	     * A placeholder fragment containing a simple view.
	     */
	    @SuppressLint("NewApi")
		public static class HomeFragment extends Fragment {

	        public HomeFragment() {
	        }

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            View rootView = inflater.inflate(R.layout.home_frag, container, false);
	            return rootView;
	        }
	    }

	}
