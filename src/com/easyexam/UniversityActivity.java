package com.easyexam;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class UniversityActivity extends ActionBarActivity implements OnItemClickListener {

 String[] university_exam_name;
 TypedArray university_pic;


 List<RowItem> rowItems;
 ListView mylistview;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.university_activity);
  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  rowItems = new ArrayList<RowItem>();

  university_exam_name = getResources().getStringArray(R.array.university);

  university_pic = getResources().obtainTypedArray(R.array.universityimage);


  for (int i = 0; i < university_exam_name.length; i++) {
   RowItem item = new RowItem(university_exam_name[i],
     university_pic.getResourceId(i, -1));
   rowItems.add(item);
  }

  mylistview = (ListView) findViewById(R.id.universitylist);
  CustomAdapter adapter = new CustomAdapter(this, rowItems);
  mylistview.setAdapter(adapter);
  university_pic.recycle();
  mylistview.setOnItemClickListener(this);

 }

 @Override
 public void onItemClick(AdapterView<?> parent, View view, int position,
   long id) {

  String member_name = rowItems.get(position).getExamName();
  Toast.makeText(getApplicationContext(), "" + member_name,
    Toast.LENGTH_SHORT).show();
  Intent i=new Intent("com.easyexam.MODULESACTIVITY");
  i.putExtra("ITEM", member_name);
  startActivity(i);
 }
 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
 	// TODO Auto-generated method stub
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