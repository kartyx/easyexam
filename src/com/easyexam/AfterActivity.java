package com.easyexam;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class AfterActivity extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.after_activity);
	}
	
public void state(View view)
{
	Intent i=new Intent("com.easyexam.STATEACTIVITY");
	startActivity(i);
}
public void national(View view)
{
	Intent i=new Intent("com.easyexam.NATIONALACTIVITY");
	startActivity(i);
}
public void university(View view)
{
	Intent i=new Intent("com.easyexam.UNIVERSITYACTIVITY");
	startActivity(i);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	MenuInflater i=getMenuInflater();
	i.inflate(R.menu.menu, menu);
	return true;
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
