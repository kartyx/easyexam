package com.easyexam;

import java.net.InetAddress;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.Toast;

public class RegistrationActivity extends ModulesActivity {
	String exam_name;
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
		   View activityView = layoutInflater.inflate(R.layout.registration_activity, null,false); 
		   frameLayout.addView(activityView);
		   Intent i=getIntent();
			exam_name=i.getStringExtra("ITEM");
			resumepref=getSharedPreferences("ResumePrefs",Context.MODE_PRIVATE);
			editor=resumepref.edit();
			editor.putString("resumevalue", "com.easyexam.RegistrationActivity");
			editor.putString("exam_name", exam_name);
			 editor.commit();

			boolean value=isInternetReachable(this);	
			if(!value)
				Toast.makeText(this,"No Internet Connection", Toast.LENGTH_SHORT).show();
			w=(WebView)findViewById(R.id.reg);
			w.getSettings().setJavaScriptEnabled(true);
	        w.getSettings().setBuiltInZoomControls(true);
			setContent(exam_name);
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
		getSupportActionBar().setTitle("Tripura JEE ELIGIBILTY");
		w.loadUrl("http://tbjee.nic.in/");
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
		w.loadUrl("http://117.240.224.21/oars/");
	}
	
	private void bitsat()	
	{
		getSupportActionBar().setTitle("BITSAT ELIGIBILITY");
		w.loadUrl("http://bitsadmission.com/");
}
	private void bsau()
	{
		getSupportActionBar().setTitle("BSAUEE ELIGIBILITY");
		w.loadUrl("http://oamslive.blueshiftindia.com/BSAUEEE/website/");
		
	}
	private void cat()
	{
		getSupportActionBar().setTitle("CAT ELIGIBILITY");
		w.loadUrl("https://iimcat.ac.in/EForms/Mock/Web_App_Template/756/1/index.html?1@@1@@1");
	}
	private void comedk()
	{
		getSupportActionBar().setTitle("COMEDK ELIGIBILITY");
		w.loadUrl("http://www.comedk.org/PGET/PGET_ApplicationFormInstr.aspx");
	}
	private void examcet()
	{
		getSupportActionBar().setTitle("EXAMCET ELIGIBILITY");
		w.loadUrl("http://apeamcet.org/");

	}
	private void gmat()
	{
		getSupportActionBar().setTitle("GMAT ELIGIBILITY");
		w.loadUrl("http://www.mba.com/india/the-gmat-exam/register.aspx");
}
	private void gre()
	{
		getSupportActionBar().setTitle("GRE ELIGIBILITY");
		w.loadUrl("http://www.ets.org/gre/revised_general/register?WT.ac=grehome_greregister_b_130807");		
	}
	private void ielts()
	{
		getSupportActionBar().setTitle("IELTS ELIGIBILITY");
		w.loadUrl("http://www.ielts.org/");
}
	private void isat()
	{
		getSupportActionBar().setTitle("ISAT ELIGIBILITY");
		w.loadUrl("http://www.iist.ac.in/");
}
	private void viteee()
	{
		getSupportActionBar().setTitle("ISAT ELIGIBILITY");
		w.loadUrl("http://www.vit.ac.in/viteee2014/");

		
	}
	private void upseee()
	{
		getSupportActionBar().setTitle("UPSEEE ELIGIBILITY");
		w.loadUrl("https://upsee.nic.in/default1.aspx");
		}
	private void toefl()
	{
		getSupportActionBar().setTitle("TOEFL ELIGIBILITY");
		w.loadUrl("http://www.ets.org/toefl");
	}
	private void jnu()
	{
		getSupportActionBar().setTitle("JNUEEE ELIGIBILITY");
		w.loadUrl("http://www.jnu.ac.in/");
	}
	private void cet()
	{
		getSupportActionBar().setTitle("CET ELIGIBILITY");
		w.loadUrl("http://kea.kar.nic.in/");
	}
	private void defence()
	{
		getSupportActionBar().setTitle("Defence ELIGIBILITY");
		w.loadUrl("http://nda.nic.in/");
	}
	private void keam()
	{	getSupportActionBar().setTitle("KEAM ELIGIBILITY");
		w.loadUrl("file:///android_asset/keam.html");
	}
	private void mhtcet()
	{
		getSupportActionBar().setTitle("MHTCET ELIGIBILITY");
		w.loadUrl("http://www.dtemaharashtra.gov.in/approvedinstitues/StaticPages/HomePage.aspx");
	}
	private void srm()
	{
		getSupportActionBar().setTitle("SRMEEE ELIGIBILITY");
		w.loadUrl("http://www.srmuniv.ac.in/index.html");
	}
	private void ssc()
	{
		getSupportActionBar().setTitle("SSC ELIGIBILITY");
		w.loadUrl("http://ssc.nic.in/SSC.html");

	}
	private void cpet()
	{
		getSupportActionBar().setTitle("SRMEEE ELIGIBILITY");
		w.loadUrl("file:///android_asset/cpet.html");
	}
	private void gate()
	{
		getSupportActionBar().setTitle("GATE ELIGIBILITY");
		w.loadUrl("http://gate.iitk.ac.in/GATE2015/");
	}
	private void lic()
	{
		getSupportActionBar().setTitle("LIC/GIC ELIGIBILITY");
		w.loadUrl("http://www.licindia.in/careers.htm");
	
	}
	private void vee()
	{
		getSupportActionBar().setTitle("VEE ELIGIBILITY");
		w.loadUrl("http://www.velsuniv.ac.in/");
	}
	private void tnpsc()
	{
		getSupportActionBar().setTitle("TNPSC ELIGIBILITY");
		w.loadUrl("file:///android_asset/tnpsc.html");

	}
	private void tancet()
	{
		getSupportActionBar().setTitle("TANCET ELIGIBILITY");
		w.loadUrl("http://www.annauniv.edu/tancet2014/");
	}
	private void bank()
	{	getSupportActionBar().setTitle("BANK EXAM ELIGIBILITY");
		w.loadUrl("http://rbi.org.in/scripts/bs_viewcontent.aspx?Id=2855");
	}
	private void tnea()
	{
		getSupportActionBar().setTitle("TNEA ELIGIBILITY");
		w.loadUrl("http://tnea.annauniv.edu/tnea2014/index.php");

	}
	
	private void nat()
	{
		getSupportActionBar().setTitle("NAT ELIGIBILITY");
		w.loadUrl("http://www.nts.org.pk/Products/NAT/nat-howto-register.php");
		
	}
	private void upsc()
	{
		getSupportActionBar().setTitle("UPSC ELIGIBILITY");
		w.loadUrl("http://www.upsc.gov.in/");
	}
	
	private void jee()
	{
		getSupportActionBar().setTitle("JEE ELIGIBILITY");
		w.loadUrl("http://jeemain.nic.in/jeemainapp/Welcome.aspx");
	}	
}
