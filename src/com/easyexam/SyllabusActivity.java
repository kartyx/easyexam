package com.easyexam;
import com.easyexam.R;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.Toast;


public class SyllabusActivity extends ModulesActivity {
	String exam_name;
	//TextView t;
	WebView w;
	SharedPreferences resumepref;
	 Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		framed.removeView(defaultView);
		FrameLayout frameLayout = (FrameLayout)findViewById(R.id.activity_frame);
	    LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View activityView = layoutInflater.inflate(R.layout.syllabus_activity, null,false);
	    frameLayout.addView(activityView);
		Intent i=getIntent();
		exam_name=i.getStringExtra("ITEM");
		resumepref=getSharedPreferences("ResumePrefs",Context.MODE_PRIVATE);
		editor=resumepref.edit();
		editor.putString("resumevalue", "com.easyexam.SyllabusActivity");
		editor.putString("exam_name", exam_name);
		 editor.commit();

		w=(WebView)findViewById(R.id.syll);
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
		getSupportActionBar().setTitle("TRIPURA JEE SYLLABUS");
		w.loadUrl("file:///android_asset/stripura.html");
	}

	private void aieee()
	{
		getSupportActionBar().setTitle("AIEEE SYLLABUS");
		w.loadUrl("file:///android_asset/saieee.html");
		

		
	}
	private void assam()
	{
		getSupportActionBar().setTitle("ASSAM JAT SYLLABUS");
		w.loadUrl("file:///android_asset/sassam.html");
	}
	private void aueee()
	{
		getSupportActionBar().setTitle("AUEEE SYLLABUS");
		w.loadUrl("file:///android_asset/saueee.html");

	}
	private void beee()
	{
		getSupportActionBar().setTitle("BEEE SYLLABUS");
		w.loadUrl("file:///android_asset/sbeee.html");
		
	}
	private void amrita()
	{
		getSupportActionBar().setTitle("AMRITA SYLLABUS");
		w.loadUrl("file:///android_asset/samrita.html");
	}
	
	private void bitsat()	
	{
		getSupportActionBar().setTitle("BITSAT SYLLABUS");
		w.loadUrl("file:///android_asset/sbitsat.html");
}
	private void bsau()
	{
		getSupportActionBar().setTitle("BSAUEE SYLLABUS");
		w.loadUrl("file:///android_asset/sbsau.html");
		
	}
	private void cat()
	{
		getSupportActionBar().setTitle("CAT SYLLABUS");
		w.loadUrl("file:///android_asset/scat.html");
	}
	private void comedk()
	{
		getSupportActionBar().setTitle("COMEDK SYLLABUS");
		w.loadUrl("file:///android_asset/scomedk.html");
	}
	private void examcet()
	{
		getSupportActionBar().setTitle("EXAMCET SYLLABUS");
		w.loadUrl("file:///android_asset/sexamcet.html");

	}
	private void gmat()
	{
		getSupportActionBar().setTitle("GMAT SYLLABUS");
		w.loadUrl("file:///android_asset/sgmat.html");
}
	private void gre()
	{
		getSupportActionBar().setTitle("GRE SYLLABUS");
		w.loadUrl("file:///android_asset/sgre.html");		
	}
	private void ielts()
	{
		getSupportActionBar().setTitle("IELTS SYLLABUS");
		w.loadUrl("file:///android_asset/sielts.html");
}
	private void isat()
	{
		getSupportActionBar().setTitle("ISAT SYLLABUS");
		w.loadUrl("file:///android_asset/sisat.html");
}
	private void viteee()
	{
		PdfHandler pdf = new PdfHandler(this);
	pdf.openPdf("sviteee.pdf");
		
	}
	private void upseee()
	{
		getSupportActionBar().setTitle("UPSEEE SYLLABUS");
		w.loadUrl("file:///android_asset/supseee.html");
		}
	private void toefl()
	{
		getSupportActionBar().setTitle("TOEFL SYLLABUS");
		w.loadUrl("file:///android_asset/stoefl.html");
	}
	private void jnu()
	{
		getSupportActionBar().setTitle("JNUEEE SYLLABUS");
		w.loadUrl("file:///android_asset/sjnu.html");
	}
	private void cet()
	{
		getSupportActionBar().setTitle("CET SYLLABUS");
		w.loadUrl("file:///android_asset/scet.html");
	}
	private void defence()
	{
		getSupportActionBar().setTitle("Defence SYLLABUS");
		w.loadUrl("file:///android_asset/sdefence.html");
	}
	private void keam()
	{	getSupportActionBar().setTitle("KEAM SYLLABUS");
		w.loadUrl("file:///android_asset/skeam.html");
	}
	private void mhtcet()
	{
		getSupportActionBar().setTitle("MHTCET SYLLABUS");
		w.loadUrl("file:///android_asset/smhtcet.html");
	}
	private void srm()
	{
		getSupportActionBar().setTitle("SRMEEE SYLLABUS");
		w.loadUrl("file:///android_asset/ssrm.html");
	}
	private void ssc()
	{
		PdfHandler pdf = new PdfHandler(this);
		pdf.openPdf("sssc.pdf");

	}
	private void cpet()
	{
		getSupportActionBar().setTitle("CPET SYLLABUS");
		w.loadUrl("file:///android_asset/scpet.html");
	}
	private void gate()
	{
		PdfHandler pdf = new PdfHandler(this);
		pdf.openPdf("sgate.pdf");
	}
	private void lic()
	{

		getSupportActionBar().setTitle("LIC/GIC");
		w.loadUrl("file:///android_asset/slic.html");
	}
	private void vee()
	{
		getSupportActionBar().setTitle("VEE SYLLABUS");
		w.loadUrl("file:///android_asset/svee.html");
	}
	private void tnpsc()
	{

		PdfHandler pdf = new PdfHandler(this);
		pdf.openPdf("stnpsc.pdf");

	}
	private void tancet()
	{
		getSupportActionBar().setTitle("TANCET SYLLABUS");
		w.loadUrl("file:///android_asset/stancet.html");
	}
	private void bank()
	{	getSupportActionBar().setTitle("BANK EXAM SYLLABUS");
		w.loadUrl("file:///android_asset/sbank.html");
	}
	private void tnea()
	{
		

	}
	
	private void nat()
	{
		getSupportActionBar().setTitle("NAT SYLLABUS");
		w.loadUrl("file:///android_asset/snat.html");
		
	}
	private void upsc()
	{
		getSupportActionBar().setTitle("UPSC SYLLABUS");
		w.loadUrl("file:///android_asset/supsc.html");
	}
	
	private void jee()
	{
		PdfHandler pdf = new PdfHandler(this);
		pdf.openPdf("sjee.pdf");
	}



}