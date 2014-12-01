package com.easyexam;

import java.util.ArrayList;
import java.util.List;

import com.easyexam.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.os.Bundle;
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

public class SamplesActivity extends ModulesActivity implements OnItemClickListener {

  String[] samples_exam_name;
  TypedArray samples_pic;
  String exam_name;
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
   View activityView = layoutInflater.inflate(R.layout.samples_activity, null,false);
   // add the custom layout of this activity to frame layout.
   frameLayout.addView(activityView);
   rowItems = new ArrayList<RowItem>();

   samples_exam_name = getResources().getStringArray(R.array.samples);

   samples_pic = getResources().obtainTypedArray(R.array.samplesimage);
	 Intent intent=getIntent();
		exam_name=intent.getStringExtra("ITEM");
		resumepref=getSharedPreferences("ResumePrefs",Context.MODE_PRIVATE);
		editor=resumepref.edit();
		editor.putString("resumevalue", "com.easyexam.SamplesActivity");
		editor.putString("exam_name", exam_name);
		 editor.commit();

		if(exam_name.equalsIgnoreCase("upsc"))
		{
			for (int i = 0; i < 2; i++) {
			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
			    rowItems.add(item);
			   }
		}
 		else if(exam_name.equalsIgnoreCase("ssc"))
 		{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 		}
 		else if(exam_name.equalsIgnoreCase("defence"))
 			{for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("lic/gic"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("bank exam"))
 			{
 			for (int i = 0; i < 4; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("mhtcet"))
 		{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 		}
 		else if(exam_name.equalsIgnoreCase("cet"))
 			{
 			for (int i = 0; i < 2; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("tnea"))
 			{
 			for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("upsee"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("comedk"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("examcet"))
 			{
 			for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("keam"))
 			{
 			for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("Assam jat"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("cpet"))
 			{for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("jee"))
 			{
 			for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("aieee"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("bitsat"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("viteee"))
 			{
 			for (int i = 0; i < 4; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("nat"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
		
 		else if(exam_name.equalsIgnoreCase("isat"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 			
 		else if(exam_name.equalsIgnoreCase("srm-eee"))
 			{
 			for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("vee"))
 			{
 			for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("tripura jee"))
 			{
 			for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("aueee"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("amrita"))
 			{
 			for (int i = 0; i < 3; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("bsaueee"))
 			{
 			
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("jnueee"))
 			{
 			for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("beee"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("gate"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("tancet"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("gre"))
 			{
 			for (int i = 0; i < 2; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("toefl"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("ielts"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("gmat"))
 			{
 			for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("cat"))
 			{
 			for (int i = 0; i < 1; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 		else if(exam_name.equalsIgnoreCase("tnpsc"))
 			{
 			for (int i = 0; i < samples_exam_name.length; i++) {
 			    RowItem item = new RowItem(samples_exam_name[i],samples_pic.getResourceId(i, -1));
 			    rowItems.add(item);
 			   }
 			}
 	
   

   mylistview = (ListView) findViewById(R.id.sampleslist);
   CustomAdapter adapter = new CustomAdapter(this, rowItems);
   mylistview.setAdapter(adapter);
   samples_pic.recycle();
   mylistview.setOnItemClickListener(this);

  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position,
    long id) {

  // String member_name = rowItems.get(position).getExamName();
 //  Toast.makeText(getApplicationContext(), "" + member_name,
  //   Toast.LENGTH_SHORT).show();
   setContent(exam_name,position); 
  }
  void setContent(String exam_name,int position)
 	{
 		
 		if(exam_name.equalsIgnoreCase("upsc"))
 			upsc(position);
 		else if(exam_name.equalsIgnoreCase("ssc"))
 			ssc(position);
 		else if(exam_name.equalsIgnoreCase("defence"))
 			defence(position);
 		else if(exam_name.equalsIgnoreCase("lic/gic"))
 			lic(position);
 		else if(exam_name.equalsIgnoreCase("bank exam"))
 			bank(position);
 		else if(exam_name.equalsIgnoreCase("mhtcet"))
 			mhtcet(position);
 		else if(exam_name.equalsIgnoreCase("cet"))
 			cet(position);
 		else if(exam_name.equalsIgnoreCase("tnea"))
 		{}//tnea(position);
 		else if(exam_name.equalsIgnoreCase("upsee"))
 			upseee(position);
 		else if(exam_name.equalsIgnoreCase("comedk"))
 			comedk(position);
 		else if(exam_name.equalsIgnoreCase("examcet"))
 			examcet(position);
 		else if(exam_name.equalsIgnoreCase("keam"))
 			keam(position);
 		else if(exam_name.equalsIgnoreCase("Assam jat"))
 			assam(position);
 		else if(exam_name.equalsIgnoreCase("cpet"))
 			cpet(position);
 		else if(exam_name.equalsIgnoreCase("jee"))
 			jee(position);
 		else if(exam_name.equalsIgnoreCase("aieee"))
 			aieee(position);
 		else if(exam_name.equalsIgnoreCase("bitsat"))
 			bitsat(position);
 		else if(exam_name.equalsIgnoreCase("viteee"))
 			viteee(position);
 		else if(exam_name.equalsIgnoreCase("nat"))
 			nat(position);
 		else if(exam_name.equalsIgnoreCase("isat"))
 			isat(position);
 		else if(exam_name.equalsIgnoreCase("srm-eee"))
 			srm(position);
 		else if(exam_name.equalsIgnoreCase("vee"))
 			vee(position);
 		else if(exam_name.equalsIgnoreCase("tripura jee"))
 			tripura(position);
 		else if(exam_name.equalsIgnoreCase("aueee"))
 			aueee(position);
 		else if(exam_name.equalsIgnoreCase("amrita"))
 			amrita(position);
 		else if(exam_name.equalsIgnoreCase("bsaueee"))
 			bsau(position);
 		else if(exam_name.equalsIgnoreCase("jnueee"))
 			jnu(position);
 		else if(exam_name.equalsIgnoreCase("beee"))
 			beee(position);
 		else if(exam_name.equalsIgnoreCase("gate"))
 			gate(position);
 		else if(exam_name.equalsIgnoreCase("tancet"))
 			tancet(position);
 		else if(exam_name.equalsIgnoreCase("gre"))
 			gre(position);
 		else if(exam_name.equalsIgnoreCase("toefl"))
 			toefl(position);
 		else if(exam_name.equalsIgnoreCase("ielts"))
 			ielts(position);
 		else if(exam_name.equalsIgnoreCase("gmat"))
 			gmat(position);
 		else if(exam_name.equalsIgnoreCase("cat"))
 			cat(position);
 		else if(exam_name.equalsIgnoreCase("tnpsc"))
 			tnpsc(position);
 	}
  private void keam(int position) {
	// TODO Auto-generated method stub
	
}
public void cpet(int position)
  {
  	PdfHandler pdf = new PdfHandler(this);
  	pdf.openPdf("sacpet.pdf");
  }
  public void srm(int position)
  {
  	PdfHandler pdf = new PdfHandler(this);
  	pdf.openPdf("sasrm.pdf");
  }
  public void vee(int position)
  {
  	PdfHandler pdf = new PdfHandler(this);
  	pdf.openPdf("savee.pdf");
  }
  public void tripura(int position)
  {
  	PdfHandler pdf = new PdfHandler(this);
  	pdf.openPdf("satripura.pdf");
  }
  public void jnu(int position)
  {
  	PdfHandler pdf = new PdfHandler(this);
  	pdf.openPdf("sajnu.pdf");
  }
  public void jee(int position)
  {
  	PdfHandler pdf = new PdfHandler(this);
  	pdf.openPdf("sajee.pdf");
  }
  public void examcet(int position)
  {
  	PdfHandler pdf = new PdfHandler(this);
  	pdf.openPdf("saexam.pdf");
  }
  public void tnpsc(int position)
  {
  	PdfHandler pdf = new PdfHandler(this);
  	pdf.openPdf("satnpsc.pdf");
  }

  public void comedk(int position)
  {
  	PdfHandler pdf = new PdfHandler(this);
  	pdf.openPdf("sacomedk.pdf");
  }
public void mhtcet(int position)
  {
  	PdfHandler pdf = new PdfHandler(this);
  	pdf.openPdf("samhtcet.pdf");
  }
  public void ssc(int position) 
  {
	  	PdfHandler pdf = new PdfHandler(this);
	  	pdf.openPdf("sassc.pdf");
  }
public void aieee(int position)
  {
 	  PdfHandler pdf = new PdfHandler(this);
 		pdf.openPdf("smaieee.pdf");
  }
public void upseee(int position)
	{
	PdfHandler pdf = new PdfHandler(this);
	pdf.openPdf("saupsee.pdf");
	}
  public void amrita(int position)
  {
 		
 	 if(position==0)
 	 {
 		  PdfHandler pdf = new PdfHandler(this);
 			pdf.openPdf("ammaths.pdf");
 	 }
 	else if(position==1)
 	{
 		PdfHandler pdf = new PdfHandler(this);
 		pdf.openPdf("amphy.pdf");
 	}
 	else if(position==2)
 	{
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("amchem.pdf");
 	}
 	 }
  public void cat(int position)
  {
 	 PdfHandler pdf = new PdfHandler(this);
 		pdf.openPdf("sacat.pdf");
 	 
 	 }
  public void bank(int position)
  {
 	 
 	 if(position==0)
 	 {
 		  PdfHandler pdf = new PdfHandler(this);
 			pdf.openPdf("sabank1.pdf");
 	 }
 else if(position==1)
 {
 				PdfHandler pdf = new PdfHandler(this);
 		pdf.openPdf("sabank2.pdf");
 }
 		else if(position==2)
 		{
 			PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("sabank3.pdf");
 		}
 	else if(position==3)
 	{
 		PdfHandler pdf = new PdfHandler(this);
 pdf.openPdf("sabank4.pdf");
 	}
 		 }
 public void gre(int position)
  {
 	 
 	 if(position==0)
 	 {
 		  PdfHandler pdf = new PdfHandler(this);
 			pdf.openPdf("sagre1.pdf");
 	 }
 else if(position==1)
 {
 				PdfHandler pdf = new PdfHandler(this);
 		pdf.openPdf("sagre2.pdf");
 }
  }
 public void tancet(int position)
 {
 	 PdfHandler pdf = new PdfHandler(this);
 			pdf.openPdf("satancet1.pdf");
 }
 public void assam(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("saassam.pdf");
 }
 public void aueee(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("saaueee.pdf");
 }
 public void upsc(int position)
 {
 	 if(position==0)
 	 {
 		  PdfHandler pdf = new PdfHandler(this);
 			pdf.openPdf("saupsc1.pdf");
 	 }
 else if(position==1)
 {
 				PdfHandler pdf = new PdfHandler(this);
 		pdf.openPdf("saupsc2.pdf");
 }
 	
 }
 public void toefl(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("satoefl.pdf");
 }
 public void nat(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("sanat.pdf");
 }
 public void viteee(int position)
 {
 	if(position==0)
  {
 	  PdfHandler pdf = new PdfHandler(this);
 		pdf.openPdf("vmaths.pdf");
  }
 else if(position==1)
 {
 			PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("vphy.pdf");
 }
 	else if(position==2)
 	{
 		PdfHandler pdf = new PdfHandler(this);
 pdf.openPdf("vchem.pdf");
 	}
 else if(position==3)
 {
 	PdfHandler pdf = new PdfHandler(this);
 pdf.openPdf("vbio.pdf");
 } 	
 }
 public void cet(int position)
 {

	 if(position==0)
  {
 	  PdfHandler pdf = new PdfHandler(this);
 		pdf.openPdf("cemaths.pdf");
  }
 else if(position==1)
 {
 			PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("cechem.pdf");
 }
 	}
 public void gate(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("sagate.pdf");
 }
 public void lic(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("salic.pdf");
 }
 public void gmat(int position)
 {
  if(position==0){
 	  PdfHandler pdf = new PdfHandler(this);
 		pdf.openPdf("gverbal.pdf");
  }
 else if(position==1){
 			PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("gmaths.pdf");
 }
 	
 }
 public void ielts(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("saielts.pdf");
 }
 public void beee(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("sabeee.pdf");	
 }
 public void bsau(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("sabsau.pdf");	
 }
 public void bitsat(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("sabsau.pdf");
 }
 public void defence(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("sadefence.pdf");
 }
 public void isat(int position)
 {
 	PdfHandler pdf = new PdfHandler(this);
 	pdf.openPdf("saisat.pdf");	
 }


 
}