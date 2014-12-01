package com.easyexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
public class CategoryActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_activity);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
	}
	public void after(View view)
	{
		Intent i=new Intent("com.easyexam.AFTERACTIVITY");
		startActivity(i);
	}
	public void engg(View view)
	{
		Intent i=new Intent("com.easyexam.ENGGACTIVITY");
		startActivity(i);
	}
	public void post(View view)
	{
		Intent i=new Intent("com.easyexam.POSTACTIVITY");
		startActivity(i);
	}

	@Override
	 public boolean onOptionsItemSelected(MenuItem item) {
	 	// TODO Auto-generated method stub
	 	switch(item.getItemId())
	 	{
	 	case R.id.LogOut:
	 		Intent loginIntent=new Intent(getApplicationContext(),LoginActivity.class);
	 		loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	 		startActivity(loginIntent);
	 		
	 	break;
	 	case R.id.Help:
	 		Intent helpIntent=new Intent("com.easyexam.HELPACTIVITY");
		      helpIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		      startActivity(helpIntent);
	 		break;
	 	case R.id.dash:
	 		Toast.makeText(this, "DashBoard soon", Toast.LENGTH_SHORT).show();
	 		break;
	 	default:
	 	return super.onOptionsItemSelected(item);
	 	}
	 	return true;
	 }
}
