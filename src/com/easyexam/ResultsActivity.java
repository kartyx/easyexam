package com.easyexam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;

public class ResultsActivity extends ModulesActivity {
	String exam_name,module_name;
	//TextView t;
	WebView w;
	SharedPreferences resumepref;
	 Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		framed.removeView(defaultView);
		FrameLayout frameLayout = (FrameLayout)findViewById(R.id.activity_frame);
	    LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View activityView = layoutInflater.inflate(R.layout.results_activity, null,false);
	    frameLayout.addView(activityView);
		Intent i=getIntent();
		exam_name=i.getStringExtra("ITEM");
		resumepref=getSharedPreferences("ResumePrefs",Context.MODE_PRIVATE);
		editor=resumepref.edit();
		editor.putString("resumevalue", "com.easyexam.ResultsActivity");
		editor.putString("exam_name", exam_name);
		editor.commit();

		w=(WebView)findViewById(R.id.results);
		w.getSettings().setJavaScriptEnabled(true);
        w.getSettings().setBuiltInZoomControls(true);
		setContent(exam_name);
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		this.finish();
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
		else if(exam_name.equalsIgnoreCase("tripura jee"))
			tripura();
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
	
	private void tripura() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("TRIPURA JEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rtripura.html");
	}

	private void aieee()
	{
		getSupportActionBar().setTitle("AIEEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/raieee.html");
		

		
	}
	private void assam()
	{
		getSupportActionBar().setTitle("ASSAM JAT RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rassam.html");
	}
	private void aueee()
	{
		getSupportActionBar().setTitle("AUEEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/raueee.html");

	}
	private void beee()
	{
		getSupportActionBar().setTitle("BEEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rbeee.html");
		
	}
	private void amrita()
	{
		getSupportActionBar().setTitle("AMRITA RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/ramrita.html");
	}
	
	private void bitsat()	
	{
		getSupportActionBar().setTitle("BITSAT RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rbitsat.html");
}
	private void bsau()
	{
		getSupportActionBar().setTitle("BSAUEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rbsau.html");
		
	}
	private void cat()
	{
		getSupportActionBar().setTitle("CAT RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rcat.html");
	}
	private void comedk()
	{
		getSupportActionBar().setTitle("COMEDK RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rcomdek.html");
	}
	private void examcet()
	{
		getSupportActionBar().setTitle("COMEDK RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rexamcet.html");

	}
	private void gmat()
	{
		getSupportActionBar().setTitle("GMAT RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rgmat.html");
}
	private void gre()
	{
		getSupportActionBar().setTitle("GRE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rgre.html");		
	}
	private void ielts()
	{
		getSupportActionBar().setTitle("IELTS RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rielts.html");
}
	private void isat()
	{
		getSupportActionBar().setTitle("ISAT RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/risat.html");
}
	private void viteee()
	{
		getSupportActionBar().setTitle("VITEEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rviteee.html");
		
	}
	private void upseee()
	{
		getSupportActionBar().setTitle("UPSEEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rupseee.html");
		}
	private void toefl()
	{
		getSupportActionBar().setTitle("TOEFL RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rtoefl.html");
	}
	private void jnu()
	{
		getSupportActionBar().setTitle("JNUEEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rjnu.html");
	}
	private void cet()
	{
		getSupportActionBar().setTitle("CET RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rcet.html");
	}
	private void defence()
	{
		getSupportActionBar().setTitle("DEFENCE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rdefence.html");
	}
	private void keam()
	{	getSupportActionBar().setTitle("KEAM RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rkeam.html");
	}
	private void mhtcet()
	{
		getSupportActionBar().setTitle("MHTCET RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rmhtcet.html");
	}
	private void srm()
	{
		getSupportActionBar().setTitle("SRMEEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rsrmeee.html");
	}
	private void ssc()
	{
		getSupportActionBar().setTitle("SSC RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rssc.html");

	}
	private void cpet()
	{
		getSupportActionBar().setTitle("SRMEEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rcpet.html");
	}
	private void gate()
	{
		getSupportActionBar().setTitle("GATE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rgate.html");
	}
	private void lic()
	{
		getSupportActionBar().setTitle("LIC/GIC RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rlic.html");
	
	}
	private void vee()
	{
		getSupportActionBar().setTitle("VEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rvee.html");
	}
	private void tnpsc()
	{
		getSupportActionBar().setTitle("TNPSC RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rtnpsc.html");

	}
	private void tancet()
	{
		getSupportActionBar().setTitle("TANCET RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rtancet.html");
	}
	private void bank()
	{	getSupportActionBar().setTitle("BANK EXAM RESULT ANALYSISY");
		w.loadUrl("file:///android_asset/rbank.html");
	}
	private void tnea()
	{
		getSupportActionBar().setTitle("TNEA RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rtnea.html");

	}
	
	private void nat()
	{
		getSupportActionBar().setTitle("NAT RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rnat.html");
		
	}
	private void upsc()
	{
		getSupportActionBar().setTitle("UPSC RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rupsc.html");
	}
	
	private void jee()
	{
		getSupportActionBar().setTitle("JEE RESULT ANALYSIS");
		w.loadUrl("file:///android_asset/rjee.html");
	}
	
	
}