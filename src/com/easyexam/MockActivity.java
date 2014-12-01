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

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MockActivity extends ModulesActivity {
	
	private RadioGroup questions;
	int id=1;
	static int total=0;
	String jsonString,exam_name; 
	String ques,opt1,opt2,opt3,correct;
	TextView question;
	RadioButton option1,option2,option3,getOption;
	Button b;
	SharedPreferences resumepref;
	Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		framed.removeView(defaultView);
		  FrameLayout frameLayout = (FrameLayout)findViewById(R.id.activity_frame);
		  LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		  View activityView = layoutInflater.inflate(R.layout.mock_activity, null,false);
		  frameLayout.addView(activityView);
		  Intent i=getIntent();
		  exam_name=i.getStringExtra("ITEM");
		 
		  questions=(RadioGroup)findViewById(R.id.options);
		  b=(Button)findViewById(R.id.nextques);
		question=(TextView)findViewById(R.id.ques);
		option1=(RadioButton)findViewById(R.id.rop1);
		option2=(RadioButton)findViewById(R.id.rop2);
		option3=(RadioButton)findViewById(R.id.rop3);
		
		
		new GetQuestions().execute();
	}
	
	class GetQuestions extends AsyncTask<Void,Void,Void>{
		protected void onPreExecute()
		{
		super.onPreExecute();	
		}
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub

			HttpClient httpclient = new DefaultHttpClient();
			String url="http://"+WelcomeActivity.host+":8080/MockTest/questions";
		    HttpPost httppost = new HttpPost(url);

		    try {
		        // Add your data
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		        nameValuePairs.add(new BasicNameValuePair("id",Integer.toString(id)));
		        nameValuePairs.add(new BasicNameValuePair("basename",exam_name));
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        // Execute HTTP Post Request
		        HttpResponse response = httpclient.execute(httppost);
		        jsonString=readJson(response);
		    } catch (ClientProtocolException e) {
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		    }
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			//question.setText(jsonString);
			parseData();
			}	
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
	public void parseData() {
		// TODO Auto-generated method stub
		try{  
			JSONObject data=(new JSONObject(jsonString)); 
			//Log.d("MOCK",jsonString);
			ques=data.optString("ques").toString();  
			//Log.d("q",ques);
			opt1=data.optString("opt1").toString();
			opt2=data.optString("opt2").toString();
			opt3=data.optString("opt3").toString();
			correct=data.optString("correct").toString();
			question.setText(ques);
			option1.setText(opt1);
			option2.setText(opt2);
			option3.setText(opt3);
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
}
	public void nextquestion(View v)
	{	
		try
		{
		int rid=questions.getCheckedRadioButtonId();
	getOption=(RadioButton)findViewById(rid);
	if(getOption.getText().toString().equalsIgnoreCase(correct))
	{
		total++;
	}
	
		id++;
		if(id>4)
		{		
		b.setText("Submit");	
		}
		if(id<6)
		{	questions.clearCheck();
			new GetQuestions().execute();
		}
		else
		{
			Intent i=new Intent(this,MockResultActivity.class);
			startActivity(i);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	class sendScores extends AsyncTask<Void,Void,Void>{
		protected void onPreExecute()
		{
		super.onPreExecute();	
		}
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub

			HttpClient httpclient = new DefaultHttpClient();
		    HttpPost httppost = new HttpPost("http://"+WelcomeActivity.host+":8080/Score/addScore");

		    try {
		        // Add your data
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
		        nameValuePairs.add(new BasicNameValuePair("examname", exam_name));
		        nameValuePairs.add(new BasicNameValuePair("UserName", com.easyexam.LoginActivity.userName));
		        nameValuePairs.add(new BasicNameValuePair("Score",Integer.toString(total)));
		        nameValuePairs.add(new BasicNameValuePair("Name",com.easyexam.LoginActivity.Name));
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        // Execute HTTP Post Request
		        HttpResponse response = httpclient.execute(httppost);
		        //jsonString=readJson(response);
		    } catch (ClientProtocolException e) {
		        // TODO Auto-generated catch block
		    	
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		    }
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			}	
    }
	@Override
	protected void onPause() {
		super.onPause();
		this.finish();
	}
}
