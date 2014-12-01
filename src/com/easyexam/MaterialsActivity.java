package com.easyexam;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MaterialsActivity extends ModulesActivity {
 String exam_name;
 WebView w;
 String[] materials_exam_name;
 TypedArray materials_pic;
 private ProgressDialog pDialog;
 public static final int progress_bar_type = 0; 
 SharedPreferences resumepref;
 Editor editor;
 List<RowItem> rowItems;
 ListView mylistview;
 
 @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		this.finish();
	}
 
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
	framed.removeView(defaultView);
	FrameLayout frameLayout = (FrameLayout)findViewById(R.id.activity_frame);
  LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  View activityView = layoutInflater.inflate(R.layout.materials_activity, null,false);
  frameLayout.addView(activityView);
	Intent i=getIntent();
	exam_name=i.getStringExtra("ITEM");
	resumepref=getSharedPreferences("ResumePrefs",Context.MODE_PRIVATE);
	editor=resumepref.edit();
	editor.putString("resumevalue", "com.easyexam.MaterialsActivity");
	editor.putString("exam_name", exam_name);
	 editor.commit();

	w=(WebView)findViewById(R.id.mat);
	w.getSettings().setJavaScriptEnabled(true);
  w.getSettings().setBuiltInZoomControls(true);
	setContent(exam_name);

 }

 void setContent(String exam_name)
	{
		
		if(exam_name.equalsIgnoreCase("upsc"))
			upsc();
		else if(exam_name.equalsIgnoreCase("ssc"))
			ssc();
		else if(exam_name.equalsIgnoreCase("defence"))
			defence();
		else if(exam_name.equalsIgnoreCase("lic/gic"))
			lic();
		else if(exam_name.equalsIgnoreCase("bank exam"))
			bank();
		else if(exam_name.equalsIgnoreCase("mhtcet"))
			mhtcet();
		else if(exam_name.equalsIgnoreCase("cet"))
			cet();
		else if(exam_name.equalsIgnoreCase("tnea"))
			tnea();
		else if(exam_name.equalsIgnoreCase("upsee"))
			upseee();
		else if(exam_name.equalsIgnoreCase("comedk"))
			comedk();
		else if(exam_name.equalsIgnoreCase("examcet"))
			examcet();
		else if(exam_name.equalsIgnoreCase("keam"))
			keam();
		else if(exam_name.equalsIgnoreCase("Assam jat"))
			assam();
		else if(exam_name.equalsIgnoreCase("cpet"))
			cpet();
		else if(exam_name.equalsIgnoreCase("jee"))
			jee();
		else if(exam_name.equalsIgnoreCase("aieee"))
			aieee();
		else if(exam_name.equalsIgnoreCase("bitsat"))
			bitsat();
		else if(exam_name.equalsIgnoreCase("viteee"))
			viteee();
		else if(exam_name.equalsIgnoreCase("nat"))
			nat();
		else if(exam_name.equalsIgnoreCase("isat"))
			isat();
		else if(exam_name.equalsIgnoreCase("srm-eee"))
			srm();
		else if(exam_name.equalsIgnoreCase("vee"))
			vee();
		else if(exam_name.equalsIgnoreCase("tigure jee"))
			tigure();
		else if(exam_name.equalsIgnoreCase("aueee"))
			aueee();
		else if(exam_name.equalsIgnoreCase("amrita"))
			amrita();
		else if(exam_name.equalsIgnoreCase("basueee"))
			bsau();
		else if(exam_name.equalsIgnoreCase("jnueee"))
			jnu();
		else if(exam_name.equalsIgnoreCase("beee"))
			beee();
		else if(exam_name.equalsIgnoreCase("gate"))
			gate();
		else if(exam_name.equalsIgnoreCase("tancet"))
			tancet();
		else if(exam_name.equalsIgnoreCase("gre"))
			gre();
		else if(exam_name.equalsIgnoreCase("toefl"))
			toefl();
		else if(exam_name.equalsIgnoreCase("ielts"))
			ielts();
		else if(exam_name.equalsIgnoreCase("gmat"))
			gmat();
		else if(exam_name.equalsIgnoreCase("cat"))
			cat();
		else if(exam_name.equalsIgnoreCase("tnpsc"))
			tnpsc();
	}
 
	private void gate() {
 
		getSupportActionBar().setTitle("BEEE SYLLABUS");
		w.loadUrl("file:///android_asset/magate.html");
	}
	

	private void mhtcet() {
		 
		getSupportActionBar().setTitle("MHTCET Materials");
		w.loadUrl("file:///android_asset/mamhtcet.html");	 
	}
	private void bank() {
		 
		getSupportActionBar().setTitle("BANK EXAM Materials");
		w.loadUrl("file:///android_asset/mabank.html");	 

	 
	}
	private void lic() {
		 
		getSupportActionBar().setTitle("LIC/GIC Materials");
		w.loadUrl("file:///android_asset/malic.html");	 

	 
	}
	private void defence() {
		 
		getSupportActionBar().setTitle("DEFENCE Materials");
		w.loadUrl("file:///android_asset/madefence.html");	 

	 
	}
	private void ssc() {
		 
		getSupportActionBar().setTitle("SSC Materials");
		w.loadUrl("file:///android_asset/massc.html");	 

	}
	private void upsc()
	{
		 
		getSupportActionBar().setTitle("UPSC Materials");
		w.loadUrl("file:///android_asset/maupsc.html");	 

	}
	private void cet() {
		 
		getSupportActionBar().setTitle("CET Materials");
		w.loadUrl("file:///android_asset/macet.html");	 

	 
	}
	private void tnea() {
		 
		//getSupportActionBar().setTitle("TNEA Materials");
		//w.loadUrl("file:///android_asset/sbeee.html");	 

	 
	}
	private void upseee() {
		 
		getSupportActionBar().setTitle("UPSEEE Materials");
		w.loadUrl("file:///android_asset/maupseee.html");	 

	}
	private void comedk() {
		 
		getSupportActionBar().setTitle("COMEDK Materials");
		w.loadUrl("file:///android_asset/macomedk.html");	 

	 
	}
	private void examcet() {
		 
		getSupportActionBar().setTitle("EXAMCET Materials");
		w.loadUrl("file:///android_asset/maexamcet.html");	 

	}
	private void keam() {
		 
		getSupportActionBar().setTitle("KEAM Materials");
		w.loadUrl("file:///android_asset/makeam.html");	 

	 
	}
	private void assam() {
		 
		getSupportActionBar().setTitle("Assam JAT Materials");
		w.loadUrl("file:///android_asset/maassam.html");	 

	 
	}
	private void cpet() {
		 
		getSupportActionBar().setTitle("CPET Materials");
		w.loadUrl("file:///android_asset/macpet.html");	 

	 
	}
	private void jee() {
		 
		getSupportActionBar().setTitle("JEE Materials");

		w.loadUrl("file:///android_asset/majee.html");	 

	}
	private void aieee() {
		 
		getSupportActionBar().setTitle("AIEEE Materials");

		w.loadUrl("file:///android_asset/maaieee.html");	 

	}
	private void bitsat() {
		 
		getSupportActionBar().setTitle("BITSAT Materials");

		w.loadUrl("file:///android_asset/mabitsat.html");	 

	}
	private void viteee() {
		 
		getSupportActionBar().setTitle("VITEEE Materials");

		w.loadUrl("file:///android_asset/mavit.html");	 

	}
	private void nat() {
		 
		getSupportActionBar().setTitle("NAT Materials");
		w.loadUrl("file:///android_asset/manat.html");	 
	}

	private void isat() {
		 
		getSupportActionBar().setTitle("ISAT Materials");
		w.loadUrl("file:///android_asset/maisat.html");	 

	}
	private void srm() {
		 
		getSupportActionBar().setTitle("SRM Materials");
		w.loadUrl("file:///android_asset/masrm.html");	 
	}
	private void gmat() {
		 
		getSupportActionBar().setTitle("GMAT Materials");
		w.loadUrl("file:///android_asset/magmat.html");	 

	}
	private void aueee() {
		 
		getSupportActionBar().setTitle("AUEEE Materials");
		w.loadUrl("file:///android_asset/maaueee.html");	 

	}
	private void vee() {
		 
		getSupportActionBar().setTitle("VEE Materials");
		w.loadUrl("file:///android_asset/mavee.html");	 
	}
	private void tigure() {
		 
		getSupportActionBar().setTitle("Tigure JEEE Materials");
		w.loadUrl("file:///android_asset/matripura.html");	 

	}
	private void amrita() {
		 
		getSupportActionBar().setTitle("AMRITA Materials");
		w.loadUrl("file:///android_asset/maamrita.html");	 

	}
	private void bsau() {
		 
		getSupportActionBar().setTitle("BSAU Materials");
		w.loadUrl("file:///android_asset/mabsau.html");	 

	}
	private void jnu() {
		 
		getSupportActionBar().setTitle("JNU Materials");
		w.loadUrl("file:///android_asset/majnu.html");	 

	}
	private void beee() {
		 
		getSupportActionBar().setTitle("BEEE Materials");
		w.loadUrl("file:///android_asset/mabeee.html");	 

	}	
	private void tancet() {
		 
		getSupportActionBar().setTitle("TANCET Materials");
		w.loadUrl("file:///android_asset/matancet.html");	 

	}
	private void gre() {
		 
		getSupportActionBar().setTitle("GRE Materials");
		w.loadUrl("file:///android_asset/magre.html");	 

	}
	private void toefl() {
		 
		getSupportActionBar().setTitle("TOEFL Materials");
		w.loadUrl("file:///android_asset/matoefl.html");	 

	}
	private void ielts() {
		 
		getSupportActionBar().setTitle("IELTS Materials");
		w.loadUrl("file:///android_asset/maielts.html");	 

	}
	private void cat() {
		 
		getSupportActionBar().setTitle("CAT Materials");
		w.loadUrl("file:///android_asset/macat.html");	 

	}
	private void tnpsc() {
		 
		getSupportActionBar().setTitle("CAT Materials");
		w.loadUrl("file:///android_asset/matnpsc.html");	 

	}
}
