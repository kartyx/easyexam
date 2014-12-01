package com.easyexam;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class WelcomeActivity extends Activity{

	static SharedPreferences firsttime;
	Editor editor;
	LoginDataBaseAdapter login;
	static String host="220.227.30.54";
	Boolean isInternetPresent,isServerRunning;
	static boolean loggedin=false;
	static boolean first=true;
	static String userName;
	String Password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_activity);
	/*//shared= getSharedPreferences("EasyExamPrefs", Context.MODE_PRIVATE);
		//keep=getSharedPreferences("LoginPrefs",Context.MODE_PRIVATE);
		firsttime=getSharedPreferences("LOGINPREFERS",Context.MODE_PRIVATE);
		login=new LoginDataBaseAdapter(this);
		login=login.open();
		/*Thread t=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stu
				try{
				sleep(1000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				finally{
					//if(shared.contains("first"))
					//{
						//if(keep.contains("keep"))
						//{
					//String value=keep.getString("keep", null);
					String value="yes";
					//String uName=keep.getString("userName", null);
					/*if(value.equalsIgnoreCase("yes"))
						{
							String category=login.getCategory("After 12th");
				             if(category.equalsIgnoreCase("After 12th"))  
				               {
				            	   Intent i=new Intent("com.easyexam.AFTERACTIVITY");
				           		   startActivity(i);
				               }
				               else if(category.equalsIgnoreCase("Under Graduate"))
				               {
				            	   Intent i=new Intent("com.easyexam.ENGGACTIVITY");
				           		   startActivity(i);
				               }
				               else if(category.equalsIgnoreCase("Post Graduate"))
				               {
				           		Intent i=new Intent("com.easyexam.POSTACTIVITY");
				           		startActivity(i);
				           	
				               }
						     

						}
						else
						{
						Intent i= new Intent("com.easyexam.LOGINACTIVITY");
						i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
						startActivity(i);
						}}
					/*else
					{
					
						Intent i=new Intent("com.easyexam.POSTACTIVITY");
		           		startActivity(i);
					}
					}
					else
					{
					      Editor editor = shared.edit();
					      editor.putString("first", "No");
					      Intent i=new Intent("com.easyexam.FIRSTACTIVITY");
					      i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
					      startActivity(i);
					      editor.commit();
					}
				}
			} 
			
		};
	t.start();	
		 Intent i=new Intent("com.easyexam.AFTERACTIVITY");
 		   startActivity(i);*/
		firsttime=getSharedPreferences("LOGINPREFERS",Context.MODE_PRIVATE);
		final ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();  
		Thread t=new Thread()
		{
			private String category;

			public void run()
			{
				try{
					sleep(2000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
				  if(isInternetPresent)
				  {						first=firsttime.getBoolean("FIRST",false);
					if(!first)
					{ 
						editor=firsttime.edit();
						editor.putBoolean("FIRST", true);
						editor.commit();
						Intent loginIntent=new Intent("com.easyexam.FIRSTACTIVITY");
						startActivity(loginIntent);
					}
					else
					{
						userName=firsttime.getString("user", null);
						Password=firsttime.getString("pass", null);
						loggedin=firsttime.getBoolean("loggedin",false);
						category=firsttime.getString("category", null);
						if(loggedin)
						{
						
				             if(category.equalsIgnoreCase("After 12th"))  
				               {
				            	   Intent i=new Intent("com.easyexam.AFTERACTIVITY");
				           		   startActivity(i);
				               }
				               else if(category.equalsIgnoreCase("Under Graduate"))
				               {
				            	   Intent i=new Intent("com.easyexam.ENGGACTIVITY");
				           		   startActivity(i);
				               }
				               else if(category.equalsIgnoreCase("Post Graduate"))
				               {
				           		Intent i=new Intent("com.easyexam.POSTACTIVITY");
				           		startActivity(i);
				           	
				               }
						}
						else
						{
							Intent loginIntent=new Intent("com.easyexam.LOGINACTIVITY");
							startActivity(loginIntent);
						}
					}
				  }
				  else
				  {
					  kill();
				  }				
			}
			}
		};
	t.start();
		if(!isInternetPresent)
		{
		Toast.makeText(getBaseContext(), "No Internet Connection",Toast.LENGTH_SHORT).show();
		}
	}
	protected void kill() {
		// TODO Auto-generated method stub
		this.finish();
	}
	@Override
	protected void onPause() {
		super.onPause();
		this.finish();
	}
}
