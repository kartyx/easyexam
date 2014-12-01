package com.easyexam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends Activity {

	EditText editTextUserName,editTextPassword;
    LoginDataBaseAdapter loginDataBaseAdapter;
    String password,jsonString;
    String storedPass,storedCat;
    static String userName,Name;
    SharedPreferences login,resumepref;
    Editor editor;
    CheckBox keep; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
		editTextUserName=(EditText)findViewById(R.id.LoginUserText);
	    editTextPassword=(EditText)findViewById(R.id.LoginPassText);
	    keep=(CheckBox)findViewById(R.id.keeplogged);
	    resumepref=getSharedPreferences("ResumePrefs",Context.MODE_PRIVATE);
		editor=resumepref.edit();
		editor.putString("resumevalue", "com.easyexam.LOGINACTIVITY");
		 editor.commit();
	}
 public void login(View view)
  { 
	 userName=editTextUserName.getText().toString();
     password=editTextPassword.getText().toString();
    /* login=getSharedPreferences("LoginPrefs",Context.MODE_PRIVATE);
     editor=login.edit();
	 if(keep.isChecked())
	 {
		 editor.putString("keep","yes");
		 editor.putString("userName",userName);
		 editor.commit();
	 }
	 else
	 {
		
		 editor.putString("keep","no");
		 editor.putString("userName", "no");
		 editor.commit();
	 }*/
     
      
     if(userName.equals("admin")&&password.equals("admin"))
     {
    	 Intent i=new Intent("com.easyexam.CATEGORYACTIVITY");
    	 startActivity(i);
     }
     else
     {
             // fetch the Password form database for respective user name
     //String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);
     try{ 
    /* String category=loginDataBaseAdapter.getCategory(userName);
             // check if the Stored password matches with  Password entered by user
             if(password.equals(storedPassword))
             {
                 Toast.makeText(this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
               if(category.equals("After 12th"))  
               {
            	   Intent i=new Intent("com.easyexam.AFTERACTIVITY");
           		   startActivity(i);
               }
               else if(category.equals("Under Graduate"))
               {
            	   Intent i=new Intent("com.easyexam.ENGGACTIVITY");
           		   startActivity(i);
               }
               else if(category.equals("Post Graduate"))
               {

           		Intent i=new Intent("com.easyexam.POSTACTIVITY");
           		startActivity(i);
           	
               }
             }
             else
             {	
            	 Toast.makeText(this, "Offline Login Failed...Trying Online",Toast.LENGTH_SHORT).show();
             	 boolean value=isInternetReachable(this);
             	 if(value)
                 new LoginOnline().execute();
             	 else
             	 Toast.makeText(this,"No Internet Connection", Toast.LENGTH_SHORT).show();
             }*/
         new LoginOnline().execute();
}
catch(Exception e)
{e.printStackTrace();
}
     }
         }
 public static boolean isInternetReachable(Context c)
 {
		 ConnectivityManager cm = (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);
		 NetworkInfo ni = cm.getActiveNetworkInfo();

		 if (ni != null && ni.isConnected())
		   return true;
		 else
		   return false;
		  }
public void signup(View view)
 {
	 Intent i=new Intent("com.easyexam.SIGNUPACTIVITY");
	 i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
	 startActivity(i);
 }
 @Override
 public void onBackPressed(){
	 	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
	 	alertDialogBuilder.setTitle("Really Exit?");
		alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				kill();
			}

		})
		.setNegativeButton("CANCEL", null);
		alertDialogBuilder.show();	 
 }
protected void kill() {
	Intent intent=new Intent(Intent.ACTION_MAIN);
	intent.addCategory(Intent.CATEGORY_HOME);
	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent);
	System.exit(0);
}
protected String readJson(HttpResponse resp)
        throws IOException {
 		StringBuffer buffer;
        BufferedReader reader = null;  

        try {
            reader = new BufferedReader(new InputStreamReader(
                    resp.getEntity().getContent()));
             buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
        } finally {
            if (reader != null)
                reader.close();
        }
        return buffer.toString();
    }
class LoginOnline extends AsyncTask<Void,Void,Void>{
	protected void onPreExecute()
	{
	super.onPreExecute();	
	}
	@Override
	protected Void doInBackground(Void... params) {

		HttpClient httpclient = new DefaultHttpClient();
		String url="http://"+WelcomeActivity.host+":8080/LoginValidate/Validate";
	    HttpPost httppost = new HttpPost(url);

	    try {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("userName", userName));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        jsonString=readJson(response);
	    } catch (ClientProtocolException e) {
	    } catch (IOException e) {
	    }
		return null;
	}
	@Override
	protected void onPostExecute(Void result) {
		Log.d("return",jsonString);
		parseData();
		}	
}
public void parseData() {
	try{  
		JSONObject data=(new JSONObject(jsonString));  
		storedPass=data.optString("PASSWORD").toString();  
		storedCat=data.optString("CATEGORY").toString();
		Name=data.optString("NAME").toString();
		if(password.equals(storedPass))  
		{
  			WelcomeActivity.loggedin=true;
			editor=WelcomeActivity.firsttime.edit();
  			editor.putBoolean("loggedin",WelcomeActivity.loggedin);
  			editor.putString("user",userName);
  			editor.putString("pass",password);
  			editor.putString("category",storedCat);
  			editor.commit();
			  Toast.makeText(this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
              if(storedCat.equalsIgnoreCase("After 12th"))  
              {
           	   Intent i=new Intent("com.easyexam.AFTERACTIVITY");
          		   startActivity(i);
          		
              }
              else if(storedCat.equalsIgnoreCase("Under Graduate"))
              {
           	   Intent i=new Intent("com.easyexam.ENGGACTIVITY");
          		   startActivity(i);
              }
              else if(storedCat.equalsIgnoreCase("Post Graduate"))
              {

          		Intent i=new Intent("com.easyexam.POSTACTIVITY");
          		startActivity(i);
          	
              }

		}
		else
		{
			Toast.makeText(this,"Wrong UserName or Password",Toast.LENGTH_SHORT).show();
		}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}  
		  
}
@Override
protected void onPause() {
	super.onPause();
	this.finish();
}



}
