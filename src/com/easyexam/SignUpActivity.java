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

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class SignUpActivity extends Activity
{
    EditText editTextUserName,editTextPassword,editTextConfirmPassword,editTextName;
    Button btnCreateAccount;
    Spinner Category;
    String jsonString;
    
    static String userName,password,category,confirmPassword,Name;
 
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
 
        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
 
        // Get Refferences of Views
        Category=(Spinner)findViewById(R.id.Categoryspinner);
        editTextName=(EditText)findViewById(R.id.signupNameText);
        editTextUserName=(EditText)findViewById(R.id.signupUserNameText);
        editTextPassword=(EditText)findViewById(R.id.signupPasswordText);
        editTextConfirmPassword=(EditText)findViewById(R.id.ConfirmPasswordText);

        	
    }
public void createAccount(View view)        
{
	Name=editTextName.getText().toString();
	userName=editTextUserName.getText().toString();
    password=editTextPassword.getText().toString();
    confirmPassword=editTextConfirmPassword.getText().toString();
    category=Category.getSelectedItem().toString();
            // check if any of the fields are vaccant
            if(userName.equalsIgnoreCase(null)||password.equalsIgnoreCase(null)||confirmPassword.equalsIgnoreCase(null)||Name.equalsIgnoreCase(null)||category.equalsIgnoreCase(null))
            {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
            }
            // check if both password matches
            if(!password.equals(confirmPassword))
            {
                Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                return;
            }
            else
            {
                // Save the Data in Database
            	
            	new signupOnline().execute();
            }
}
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
    class signupOnline extends AsyncTask<Void,Void,Void>{
		protected void onPreExecute()
		{
		super.onPreExecute();	
		}
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub

			HttpClient httpclient = new DefaultHttpClient();
			String url="http://"+WelcomeActivity.host+":8080/Login/Register";
		    HttpPost httppost = new HttpPost(url);

		    try {
		        // Add your data
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		        nameValuePairs.add(new BasicNameValuePair("Name", Name));
		        nameValuePairs.add(new BasicNameValuePair("UserName", userName));
		        nameValuePairs.add(new BasicNameValuePair("Password",password));
		        nameValuePairs.add(new BasicNameValuePair("category",category));
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        // Execute HTTP Post Request
		        HttpResponse response = httpclient.execute(httppost);
		        jsonString=readJson(response);
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
			//super.onPostExecute(result);
			Log.d("res",jsonString);
			start();		
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
	public void start() {
		// TODO Auto-generated method stub
		if(jsonString.trim().equalsIgnoreCase("YES"))
		{
			loginDataBaseAdapter.insertEntry(Name,userName, password,category);
            Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
            Intent i=new Intent("com.easyexam.LOGINACTIVITY");
            startActivity(i);
		}
		else
		{
			Toast.makeText(getApplicationContext(), "UserName Already Exists ", Toast.LENGTH_LONG).show();
            
		}
	}

}