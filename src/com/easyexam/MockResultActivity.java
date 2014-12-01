package com.easyexam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MockResultActivity extends Activity {
	TextView t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.mock_result_activity);
		  t=(TextView)findViewById(R.id.mockres);
		  t.setText("Your Total is "+MockActivity.total);	  
	}
}
