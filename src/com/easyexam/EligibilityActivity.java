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
import android.widget.TextView;
public class EligibilityActivity extends ModulesActivity {
	String exam_name;
	TextView t;
	WebView w;
	SharedPreferences resumepref;
	 Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		framed.removeView(defaultView);
		FrameLayout frameLayout = (FrameLayout)findViewById(R.id.activity_frame);
	    LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View activityView = layoutInflater.inflate(R.layout.eligibility_activity, null,false);
	    frameLayout.addView(activityView);
	    Intent i=getIntent();
		exam_name=i.getStringExtra("ITEM");
		resumepref=getSharedPreferences("ResumePrefs",Context.MODE_PRIVATE);
		editor=resumepref.edit();
		editor.putString("resumevalue", "com.easyexam.EligibilityActivity");
		editor.putString("exam_name", exam_name);
		 editor.commit();

		w=(WebView)findViewById(R.id.elig);
		w.getSettings().setJavaScriptEnabled(true);
        w.getSettings().setBuiltInZoomControls(true);
		setContent(exam_name);
		}
	
	@Override
	protected void onPause() {
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
		
	}

	private void aieee()
	{
		getSupportActionBar().setTitle("AIEEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/aieee.html");
		

		
	}
	private void assam()
	{
		getSupportActionBar().setTitle("ASSAM JAT ELIGIBILITY");
		w.loadUrl("file:///android_asset/assam.html");
	}
	private void aueee()
	{
		getSupportActionBar().setTitle("AUEEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/aueee.html");

	}
	private void beee()
	{
		getSupportActionBar().setTitle("BEEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/beee.html");
		
	}
	private void amrita()
	{
		getSupportActionBar().setTitle("AMRITA ELIGIBILITY");
		w.loadUrl("file:///android_asset/amrita.html");
	}
	
	private void bitsat()	
	{
		getSupportActionBar().setTitle("BITSAT ELIGIBILITY");
		w.loadUrl("file:///android_asset/bitsat.html");
}
	private void bsau()
	{
		getSupportActionBar().setTitle("BSAUEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/bsau.html");
		
	}
	private void cat()
	{
		getSupportActionBar().setTitle("CAT ELIGIBILITY");
		w.loadUrl("file:///android_asset/cat.html");
	}
	private void comedk()
	{
		getSupportActionBar().setTitle("COMEDK ELIGIBILITY");
		w.loadUrl("file:///android_asset/comedk.html");
	}
	private void examcet()
	{
		getSupportActionBar().setTitle("EXAMCET ELIGIBILITY");
		w.loadUrl("file:///android_asset/examcet.html");

	}
	private void gmat()
	{
		getSupportActionBar().setTitle("GMAT ELIGIBILITY");
		w.loadUrl("file:///android_asset/gmat.html");
}
	private void gre()
	{
		getSupportActionBar().setTitle("GRE ELIGIBILITY");
		w.loadUrl("file:///android_asset/gre.html");		
	}
	private void ielts()
	{
		getSupportActionBar().setTitle("IELTS ELIGIBILITY");
		w.loadUrl("file:///android_asset/ielts.html");
}
	private void isat()
	{
		getSupportActionBar().setTitle("ISAT ELIGIBILITY");
		w.loadUrl("file:///android_asset/isat.html");
}
	private void viteee()
	{
		PdfHandler pdf = new PdfHandler(this);
	pdf.openPdf("eviteee.pdf");
		
	}
	private void upseee()
	{
		getSupportActionBar().setTitle("UPSEEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/upseee.html");
		}
	private void toefl()
	{
		getSupportActionBar().setTitle("TOEFL ELIGIBILITY");
		w.loadUrl("file:///android_asset/toefl.html");
	}
	private void jnu()
	{
		getSupportActionBar().setTitle("JNUEEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/jnu.html");
	}
	private void cet()
	{
		getSupportActionBar().setTitle("CET ELIGIBILITY");
		w.loadUrl("file:///android_asset/cet.html");
	}
	private void defence()
	{
		getSupportActionBar().setTitle("Defence ELIGIBILITY");
		w.loadUrl("file:///android_asset/defence.html");
	}
	private void keam()
	{	getSupportActionBar().setTitle("KEAM ELIGIBILITY");
		w.loadUrl("file:///android_asset/keam.html");
	}
	private void mhtcet()
	{
		getSupportActionBar().setTitle("MHTCET ELIGIBILITY");
		w.loadUrl("file:///android_asset/emhtcet.html");
	}
	private void srm()
	{
		getSupportActionBar().setTitle("SRMEEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/srm.html");
	}
	private void ssc()
	{
		getSupportActionBar().setTitle("SSC ELIGIBILITY");
		w.loadUrl("file:///android_asset/ssc.html");

	}
	private void cpet()
	{
		getSupportActionBar().setTitle("SRMEEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/cpet.html");
	}
	private void gate()
	{
		getSupportActionBar().setTitle("GATE ELIGIBILITY");
		w.loadUrl("file:///android_asset/gate.html");
	}
	private void lic()
	{
		getSupportActionBar().setTitle("LIC/GIC ELIGIBILITY");
		w.loadUrl("file:///android_asset/lic.html");
	
	}
	private void vee()
	{
		getSupportActionBar().setTitle("VEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/vee.html");
	}
	private void tnpsc()
	{
		getSupportActionBar().setTitle("TNPSC ELIGIBILITY");
		w.loadUrl("file:///android_asset/tnpsc.html");

	}
	private void tancet()
	{
		getSupportActionBar().setTitle("TANCET ELIGIBILITY");
		w.loadUrl("file:///android_asset/tancet.html");
	}
	private void bank()
	{	getSupportActionBar().setTitle("BANK EXAM ELIGIBILITY");
		w.loadUrl("file:///android_asset/ebank.html");
	}
	private void tnea()
	{
		getSupportActionBar().setTitle("TNEA ELIGIBILITY");
		w.loadUrl("file:///android_asset/tnea.html");

	}
	
	private void nat()
	{
		getSupportActionBar().setTitle("NAT ELIGIBILITY");
		w.loadUrl("file:///android_asset/nat.html");
		
	}
	private void upsc()
	{
		getSupportActionBar().setTitle("UPSC ELIGIBILITY");
		w.loadUrl("file:///android_asset/upsc.html");
	}
	
	private void jee()
	{
		getSupportActionBar().setTitle("JEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/jee.html");
	}



}
