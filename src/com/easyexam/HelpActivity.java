package com.easyexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;

public class HelpActivity extends FragmentActivity {
	private MyAdapter mAdapter;
	private ViewPager mPager;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		mAdapter = new MyAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
	}

	public static class MyAdapter extends FragmentPagerAdapter {
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new ImageFragment(R.drawable.one,"Click on the overflow button to open the menu","Menu",R.drawable.menu);
			case 1:
				return new ImageFragment(R.drawable.two,"Touch and Hold on an exam to open a context menu","Context Menu",R.drawable.context);
			case 2:
				return new ImageFragment(R.drawable.three,"Swipe from the edge of the screen or press the Toggle button on the top left to open the navigation bar ","Navigation Bar",R.drawable.navbar);
			default:
				return null;
			}
		}
	}
	public void gointo(View v)
	{
		Intent i= new Intent("com.easyexam.LOGINACTIVITY");
		i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(i);
	}
}