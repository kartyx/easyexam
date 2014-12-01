package com.easyexam;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class PreviousActivity extends ModulesActivity implements OnItemClickListener {

 String[] previous_exam_name;
 TypedArray previous_pic;
 String filename;
 String exam_name,jsonString;
 private ProgressDialog pDialog;
 public static final int progress_bar_type = 0; 
 SharedPreferences resumepref;
 Editor editor;
 String[] links;
 JSONArray jArray=null;
 List<RowItem> rowItems;
 List<String> linklist;
 ListView mylistview;
 Integer in;
 

 @Override
 protected void onCreate(Bundle savedInstanceState){
  super.onCreate(savedInstanceState);
  Toast.makeText(getBaseContext(), "Will Be Updated Soon", Toast.LENGTH_SHORT).show();
 /* framed.removeView(defaultView);
  FrameLayout frameLayout = (FrameLayout)findViewById(R.id.activity_frame);
  LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  View activityView = layoutInflater.inflate(R.layout.previous_activity, null,false);
  frameLayout.addView(activityView);
  rowItems = new ArrayList<RowItem>();
  linklist=new ArrayList<String>();

  previous_exam_name = getResources().getStringArray(R.array.previous);
  previous_pic = getResources().obtainTypedArray(R.array.previousimage);
  new PopulateData().execute();

*/
  }

 @Override
 public void onItemClick(AdapterView<?> parent, View view, int pos,
   long id) {

  
	 filename=links[pos].substring(links[pos].lastIndexOf("/")+1);
		int s=open(filename);
		if(s==0)
			new DownloadFile().execute(links[pos]);
	 	}

private int open(String filename) {
		File f=new File("/sdcard/EasyExam/"+filename);
		if(f.exists())
		{
			Intent target=new Intent(Intent.ACTION_VIEW);
			target.setDataAndType(Uri.fromFile(f), "application/pdf");
			target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			Intent intent=Intent.createChooser(target, "Open File");
			try{
			startActivity(intent);
			
			}
			catch(ActivityNotFoundException e)
			{
				AlertDialog.Builder New = new AlertDialog.Builder(getBaseContext());
				New.setMessage("Please Install a PDF reader");

			}
			return 1;
		}
		else
  return 0;
  
	}
	
	@Override
	    protected Dialog onCreateDialog(int id) {
	        switch (id) {
	        case progress_bar_type: // we set this to 0
	            pDialog = new ProgressDialog(this);
	            pDialog.setMessage("Downloading file. Please wait...");
	            pDialog.setIndeterminate(false);
	            pDialog.setMax(100);
	            pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	            pDialog.setCancelable(true);
	            pDialog.show();
	            return pDialog;
	        default:
	            return null;
	        }
	   
	}
	
	class DownloadFile extends AsyncTask<String, String, String> {
		
		@Override
	    protected void onPreExecute() {
	        super.onPreExecute();
	        showDialog(progress_bar_type);

	    }

	    @Override
	    protected String doInBackground(String... f_url) {
	        int count;
	        try {
	            URL url = new URL(f_url[0]);
	            URLConnection conection = url.openConnection();
	            conection.connect();
	            int lenghtOfFile = conection.getContentLength();

	            InputStream input = new BufferedInputStream(url.openStream(), 8192);

	            OutputStream output = new FileOutputStream("/sdcard/EasyExam/"+filename);

	            byte data[] = new byte[1024];

	            long total = 0;

	            while ((count = input.read(data)) != -1) {
	                total += count;
	                // publishing the progress....
	                // After this onProgressUpdate will be called
	                publishProgress(""+(int)((total*100)/lenghtOfFile));

	                // writing data to file
	                output.write(data, 0, count);
	            }

	            // flushing output
	            output.flush();

	            // closing streams
	            output.close();
	            input.close();

	        } catch (Exception e) {
	            Log.e("Error: ", e.getMessage());
	        }

	        return null;
	    }

	
	    protected void onProgressUpdate(String... progress) {
	    		pDialog.setProgress(Integer.parseInt(progress[0]));
	   }

	    

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
		}

	}
	
class PopulateData extends AsyncTask<String, String, String> {
		
		@Override
	    protected void onPreExecute() {
	        super.onPreExecute();

	    }

	    @Override
	    protected String doInBackground(String... f_url) {
	    	HttpClient httpclient = new DefaultHttpClient();
	    	
		    HttpPost httppost = new HttpPost("http://10.0.2.2:8080/links/LinkServlet");

		    try {
		        // Add your data
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		        nameValuePairs.add(new BasicNameValuePair("ExamName", exam_name));
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        HttpResponse response = httpclient.execute(httppost);
		        jsonString=readJson(response);
		    } catch (ClientProtocolException e) {
		    	
		    } catch (IOException e) {
		    }
	       
	       
	        return null;
	    }
	    

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			try {
				parseData();
				for (int i = 0; i <in ; i++) {
					   RowItem item = new RowItem(previous_exam_name[i],
					     previous_pic.getResourceId(i, -1));
					   rowItems.add(item);
					 }
					  
					  mylistview = (ListView) findViewById(R.id.previouslist);
					  CustomAdapter adapter = new CustomAdapter(com.easyexam.PreviousActivity.this, rowItems);
					  mylistview.setAdapter(adapter);
					  previous_pic.recycle();
					  mylistview.setOnItemClickListener(com.easyexam.PreviousActivity.this);
					  Intent i=getIntent();
						exam_name=i.getStringExtra("ITEM");
					 
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

	}

public String readJson(HttpResponse response)   throws IOException {
 		StringBuffer buffer;
        BufferedReader reader = null;  

        try {
            reader = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
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

public void parseData() throws JSONException {
JSONObject jObj=new JSONObject(jsonString);
jArray=jObj.getJSONArray("links");
try{
for(int i=0;i<jArray.length();i++)
{
linklist.add(jArray.getJSONObject(i).getString("link"));
}
links=linklist.toArray(new String[linklist.size()]);
Log.d("links",links[2]);

 in=links.length;
		Log.d("lenth", in.toString());
}
catch(Exception e)
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

