package com.easyexam;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.easyexam.R;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

public class ModulesActivity extends ActionBarActivity {

 String[] modules_exam_name;
 TypedArray modules_pic;
 String item;
 int i;
 private DrawerLayout mDrawerLayout = null;
 private ActionBarDrawerToggle mDrawerToggle = null;
 static final Class[] classArray = new Class[] { com.easyexam.EligibilityActivity.class,com.easyexam.RegistrationActivity.class,com.easyexam.SyllabusActivity.class,com.easyexam.MaterialsActivity.class,com.easyexam.PreviousActivity.class,com.easyexam.SamplesActivity.class,com.easyexam.TipsActivity.class,com.easyexam.ResultsActivity.class,com.easyexam.MockActivity.class };
 static final String[] names={"com.easyexam.EligibilityActivity","com.easyexam.RegistrationActivity","com.easyexam.SyllabusActivity","com.easyexam.MaterialsActivity","com.easyexam.PreviousActivity","com.easyexam.SamplesActivity","com.easyexam.TipsActivity","com.easyexam.ResultsActivity","com.easyexam.MockActivity" };
 List<RowItem> rowItems;
 ListView mylistview;
 Intent intentObject;
 FrameLayout framed;
 View defaultView;
 ImageView moduleimage;
 TextView description;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.modules_activity);

  framed = (FrameLayout)findViewById(R.id.activity_frame);
  LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  defaultView = layoutInflater.inflate(R.layout.modules_defualt, null,false);
  framed.addView(defaultView);
  
  mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
  
  mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
  mDrawerToggle = new ActionBarDrawerToggle(this,
          mDrawerLayout, R.drawable.ic_drawer,
          R.string.drawer_open, R.string.drawer_close) {
   @TargetApi(Build.VERSION_CODES.HONEYCOMB) 
   public void onDrawerOpened(View view) {
              invalidateOptionsMenu();
          }

   @TargetApi(Build.VERSION_CODES.HONEYCOMB) 
   public void onDrawerClosed(View view) {
              invalidateOptionsMenu();
              
          }
      };


  moduleimage=(ImageView)findViewById(R.id.moduleimage);
  description=(TextView)findViewById(R.id.descriptiontext);
  rowItems = new ArrayList<RowItem>();

  modules_exam_name = getResources().getStringArray(R.array.modules);

  modules_pic = getResources().obtainTypedArray(R.array.modulesimage);

  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  getSupportActionBar().setHomeButtonEnabled(true);
  getSupportActionBar().setTitle("Select a module");
 
      mDrawerLayout.setDrawerListener(mDrawerToggle);

  for (i = 0; i < modules_exam_name.length; i++) {
   RowItem item = new RowItem(modules_exam_name[i], modules_pic.getResourceId(i, -1));
   rowItems.add(item);
  }
  
  mylistview = (ListView) findViewById(R.id.left_drawer);
  ModulesAdapter adapter = new ModulesAdapter(this, rowItems);
  mylistview.setAdapter(adapter);
  modules_pic.recycle();
  mylistview.setOnItemClickListener(new DrawerItemClickListener());
  intentObject = getIntent();
  item = intentObject.getStringExtra("ITEM");
  change();


 }


 @Override
 protected void onPostCreate(Bundle savedInstanceState) {
     super.onPostCreate(savedInstanceState);
     mDrawerToggle.syncState();
 }

 @Override
 public void onConfigurationChanged(Configuration newConfig) {
     super.onConfigurationChanged(newConfig);
     mDrawerToggle.onConfigurationChanged(newConfig);
 }
 
 @Override
 public boolean onPrepareOptionsMenu(Menu menu) {
     boolean drawerOpen = mDrawerLayout.isDrawerOpen(mylistview);

     for (int index = 0; index < menu.size(); index++) {
         MenuItem menuItem = menu.getItem(index);
         if (menuItem != null) {
             // hide the menu items if the drawer is open
             menuItem.setVisible(!drawerOpen);
         }
     }

     return super.onPrepareOptionsMenu(menu);
 }

 @Override
 public void onBackPressed(){
	 super.onBackPressed();
	 if(mDrawerLayout.isDrawerOpen(Gravity.LEFT))
		 mDrawerLayout.closeDrawer(Gravity.LEFT);
	 else
	 this.finish();
 }

 

private class DrawerItemClickListener implements ListView.OnItemClickListener{
	 @Override
	 public void onItemClick(AdapterView<?> parent, View view, int position,
	   long id) {
		 mDrawerLayout.closeDrawers();
	  String member_name = rowItems.get(position).getExamName();
	  Intent i=new Intent(ModulesActivity.this,classArray[position]);
	  i.putExtra("ITEM", item);
	  i.setAction(names[position]);
	  startActivity(i);
	 }
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// TODO Auto-generated method stub
	MenuInflater i=getMenuInflater();
	i.inflate(R.menu.menu, menu);
	return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	if (mDrawerToggle.onOptionsItemSelected(item)) {
        return true;
    }
	
	 	switch(item.getItemId())
	 	{
	 	case R.id.LogOut:
	 		Intent loginIntent=new Intent(getApplicationContext(),LoginActivity.class);
	 		loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	 		startActivity(loginIntent);
	 		
	 	break;
	 	case R.id.Help:
	 		Intent helpIntent=new Intent("com.easyexam.HELPACTIVITY");
		      helpIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		      startActivity(helpIntent);
	 		break;
	 	case R.id.dash:
	 		Toast.makeText(this, "DashBoard soon", Toast.LENGTH_SHORT).show();
	 		break;
	 	default:
	 	return super.onOptionsItemSelected(item);
	 	}
	 	return true;
	 }

void change()
{
	if(item.equalsIgnoreCase("upsc"))
	{
		moduleimage.setImageResource(R.drawable.upsc);
		description.setText("The Union Public Service Commission (UPSC) is India's central agency authorized to conduct the Civil Services Examination, Engineering Services Examination, Combined Defence Services Examination, National Defence Academy Examination, Naval Academy Examination, Combined Medical Services Examination, Special Class Railway Apprentice, Indian Economic Service/Indian Statistical Service Examination, Geologists' Examination, and Central Armed Police Forces(Assistant Commandant) Examination.");
	}
            else if(item.equalsIgnoreCase("ssc"))
        {
               moduleimage.setImageResource(R.drawable.ssc);
		description.setText("Staff Selection Commission (SSC) is an Indian organization to recruit staff for various posts in the various Ministries and Departments of the Government of India and in Subordinate Offices.This commission is an attached office of the Department of Personnel and Training (DoPT) which consists of Chairman, two Members and a Secretary-cum-Controller of Examinations.");
        }
		else if(item.equalsIgnoreCase("defence"))
        {
             moduleimage.setImageResource(R.drawable.defence);
		description.setText("The National Defence Academy (NDA) is the Joint Services academy of the Indian Armed Forces, where cadets of the three services, the Army, theNavy and the Air Force train together before they go on to pre-commissioning training in their respective service academies. The NDA is located inKhadakwasla near Pune, Maharashtra. It is the first tri-service academy in the world.NDA alumni have led and fought in every major conflict in which the Indian Armed Forces has been called to action since the academy was established. The alumni include 3 Param Vir Chakra recipients and 9 Ashoka Chakra recipients.");
        }
		
		else if(item.equalsIgnoreCase("lic/gic"))
       {
	    moduleimage.setImageResource(R.drawable.lic);
		description.setText("Life Insurance Corporation of India (LIC) is an Indian state-owned insurance group and investment company head quartered in Mumbai. It is the largest insurance company in India with an estimated asset value of  1560481.84 crore (US$250 billion). As of 2013 it had total life fund of Rs.1433103.14 crore with total value of policies sold of 367.82 lakh that year. GIC of India (GIC Re) is the sole reinsurance company in the Indian insurance market with over four decades of experience.GIC Re has its registered office and headquarters in Mumbai.");
       }
		else if(item.equalsIgnoreCase("bank"))
      {
	moduleimage.setImageResource(R.drawable.bank);
		description.setText("Institute of Banking Personnel Selection (IBPS) is an autonomous agency in India, which started its operation in 1975 as Personnel Selection Services (PSS). In 1984, IBPS became an independent entity at the behest of Reserve Bank of India (RBI) and Public Sector Banks. IBPS is envisioned as self-governed academic and research oriented Institute, with a mission of enhancing human-resource development through personnel assessment. In 2011, IBPS announced a Common Written Examination (CWE) for the selection Officers and Clerks in Indian banks. IBPS CWE is now mandatory for anyone who seeks an employment in 20 public sector and Regional Rural banks.");
       }
		else if(item.equalsIgnoreCase("mhtcet"))
	{
	    moduleimage.setImageResource(R.drawable.mhtcet);
		description.setText("The MHT-CET or Common Entrance Test is an annual entrance exam conducted by the Government of Maharashtra. It is conducted by the Directorate of Technical Education. The degree courses of the following streams are mainly accounted for in this entrance exam Health Sciences Pharmacy The test is conducted in offline mode, however online practice tests are also available");
       }
		else if(item.equalsIgnoreCase("cet"))
        {
	    moduleimage.setImageResource(R.drawable.cet);
		description.setText("The Common Entrance Test (CET) is a competitive exam conducted for the purpose of admission of students to the first year or first semester of full-time courses in Medical, Dental and Engineering courses in professional colleges within the state in question in India.The professional colleges in the state offering such courses are affiliated with the state run universities, and admit students through the CET annually. The fee structure varies from year to year.");
       }
	
		else if(item.equalsIgnoreCase("tnea"))
	{
	    moduleimage.setImageResource(R.drawable.tnea);
		description.setText("TNEA is the Tamilnadu Engineering Admission conducted by the Anna University for the undergraduate admissions in the state. A formal entrance exam is absent for the tnea. Candidates will be selected on the basis of the performance in their 10+2 as per the specified guideline. Candidates can avail the complete details of TNEA  like the exam details, eligibility criteria, application procedures and seat allotment.");
       }
		else if(item.equalsIgnoreCase("upsee"))
        {
	    moduleimage.setImageResource(R.drawable.upsc);
		description.setText("The State Entrance Examination - Uttar Pradesh Technical University(SEE-UPTU) (formerly known as UPSEAT) is an annual college entrance examination in Uttar Pradesh for engineering, architecture, pharmacy and management courses. All institutions affiliated to Gautam Buddha Technical University and Mahamaya Technical University admit students through centralized counselling of SEE-UPTU. The private institutions may, however, admit 15% of the total intake directly. The exam is conducted by the two universities on a rotating basis.");
       }
		else if(item.equalsIgnoreCase("comedk"))
      {
	    moduleimage.setImageResource(R.drawable.comedk);
		description.setText("COMEDK is the “Consortium of Medical, Engineering and Dental Colleges of Karnataka” to determine the merit of students seeking admissions to the undergraduate courses in the Member Institutions of the Karnataka Professional Colleges Foundation Trust (KPCF) in its endeavor to offer an effective, fair, transparent and non-exploitative testing procedure.There are 12 Medical, 25 Dental and more than 150 engineering colleges who make available almost 20,000 seats for admission.COMEDK has been assigned the task of organizing a Common Entrance Test for the current academic year.");
       }
			
		else if(item.equalsIgnoreCase("examcet"))
       {
	    moduleimage.setImageResource(R.drawable.examcet);
		description.setText("Engineering Agricultural and Medical Common Entrance Test, commonly called as EAMCET, is an entrance examination required for admission to some engineering and medical colleges in the state of Andhra Pradesh, India. Many other colleges offering graduation courses like BDS, B.Pharm., BSc., Pharm.D. , B.E, B. Tech, etc. require qualification in this exam. The coaching industry for the EAMCET is estimated at nearly Rs. 50 billion (approximately $110 million) a year.");
       }
			
		else if(item.equalsIgnoreCase("keam"))
      {
	    moduleimage.setImageResource(R.drawable.keam);
		description.setText("KEAM, short for Kerala Engineering Agricultural Medical is an entrance examination series for admissions to various professional degree courses in the state of Kerala, India. It is conducted by the Office of the Commissioner of Entrance Exams run by the Government of Kerala. Kerala Govt recently started a programme for KEAM Coaching named as PEECS.");
       }
		else if(item.equalsIgnoreCase("Assam jat"))
      {
	    moduleimage.setImageResource(R.drawable.assamjat);
		description.setText("A joint admission test conducted by Director of Technical education Assam for selection of candidates for Engineering admission for first year B.E to the two state government college and REC");
       }
		else if(item.equalsIgnoreCase("cpet"))
	{
	    moduleimage.setImageResource(R.drawable.cpet);
		description.setText("The exam CPET is for category the category of Engineering and is conducted at the national level.National Institute of Technology, Hamirpur, conducts the Combined Pre-Entrance Test (CPET) for admission to 4 year BTech courses.");
       }
		else if(item.equalsIgnoreCase("jee"))
	{
	    moduleimage.setImageResource(R.drawable.jee);
		description.setText("Joint Entrance Examination (JEE) is an all India common entrance examination which is conducted for admission in various engineering courses. In 2012, CBSE (Central Board of Secondary Education) has announced this common examination in place of AIEEE and IIT-JEE. JEE (Joint Entrance Examination) is being conducted into two parts, JEE-Main and JEE-Advanced. JEE-Advanced is for admission in Indian Institutes of Technology,and the Indian School of Mines (ISM), Dhanbad and JEE-Main exam is to admission in IIITs (Indian Institutes of Information Technology), National Institutes of Technology, CFTIs (Central Funded Technical Institute), etc");
       }
		else if(item.equalsIgnoreCase("aieee"))
	{
	    moduleimage.setImageResource(R.drawable.aieee);
		description.setText("The All India Engineering Entrance Examination (AIEEE), was an examination organised by the Central Board of Secondary Education (CBSE) in India. Introduced in the year 2002, this national level competitive test is for admission to various under-graduate engineering and architecture courses in institutes accepting the AIEEE score, mainly 30 National Institutes of Technology (NITs) and 5 Indian Institute of Information Technology (IIITs)");
       }
		else if(item.equalsIgnoreCase("bitsat"))
	{
	    moduleimage.setImageResource(R.drawable.bitsat);
		description.setText("Birla Institute of Technology & Science is an Indian institute of higher education and a deemed to be university under Section 3 of the UGC Act. The university has 15 academic departments, and focuses primarily on undergraduate education in engineering and the sciences.BITS administers the all-India computerised competitive entrance examination, BITSAT (BITS Admission Test), Admission is merit-based, as assessed by the BITSAT examination.");
       }
		else if(item.equalsIgnoreCase("viteee"))
	{
	    moduleimage.setImageResource(R.drawable.viteee);
		description.setText("VIT University formally called Vellore Engineering College is an Indian institute of higher education and a Deemed University under Section 3 of the UGC Act. Founded in 1984, as Vellore Engineering College, by Mr. G. Viswanathan, the institution offers 18 undergraduate and 34 postgraduate programmes and draws students from 47 countries as well as from every state in India. It has campuses both at Vellore and Chennai, Tamil Nadu, India and its Bangalore campus will be functioning from the academic year 2015.The university has been consistently placed among top 10 Indian engineering colleges by leading magazines like India Today and The Week");
       }
		else if(item.equalsIgnoreCase("nat"))
	{
	    moduleimage.setImageResource(R.drawable.nata);
		description.setText("The National Achievement Test is an annual examination given to Grade 6and Grade 10 students in the Philippines. The students' knowledge and mastery over the subjects English, Mathematics, Science, Filipino, and Hekasi is measured using a multiple choice type test. The examination is administered by the Department of Education's National Educational Testing and Research Center (NETRC).");
       }
		else if(item.equalsIgnoreCase("isat"))
	{
	    moduleimage.setImageResource(R.drawable.isat);
		description.setText("The Indian Institute of Space Science and Technolog (IIST) is a government aided institute and deemed university for the study and research of space science, located at Valiamala, Thiruvananthapuram, Kerala. It is the first university in Asia to be solely dedicated to the study and research of Outer Space.It was inaugurated on 14 September 2007 by G. Madhavan Nair, the then Chairman of ISRO.");
       }
		else if(item.equalsIgnoreCase("srm-eee"))
	{
	    moduleimage.setImageResource(R.drawable.srm);
		description.setText("The SRM University (Sri Ramaswamy Memorial University), formerly SRM Institute of Science and Technology, is a co-educational private university in the state of Tamil Nadu, India. It was founded in 1985 as SRM Engineering College in Kattankulathur, under University of Madras. It now has four campuses in Tamil Nadu—Kattankulathur, Ramapuram, Vadapalani and Tiruchirapalli—and three in the rest of India such as Modinagar near Delhi, Sonepat in Haryana and Gangtok in Sikkim.");
       }		
		else if(item.equalsIgnoreCase("vee"))
	{
	    moduleimage.setImageResource(R.drawable.vels);
		description.setText("Vels Entrance Exam (VEE-2014) is a Common Entrance Examination conducted for admission to B.E/ M.E, M.B.A, M.C.A, B. Pharm., Pharm. D, and M. Pharm/ Phar.D (P.B) Courses.");
       }
		else if(item.equalsIgnoreCase("tripura jee"))
	{
	    moduleimage.setImageResource(R.drawable.tripura);
		description.setText("The Tripura joint Entrance Examinations Board was formed for Admission to Engineering Degree Colleges, Medical Colleges, and other professional degree courses.Born out of a concept of holding a common admission test for the Engineering colleges and Medical Colleges. The basic purpose was to select candidates for consideration for admission to the Colleges on the basis of the results of a single competitive examination, which would also lead to saving of time, energy and expenditure on the part of the candidates in appearing at number of entrance tests.");
       }
		else if(item.equalsIgnoreCase("aueee"))
	{
	    moduleimage.setImageResource(R.drawable.ic_launcher);
		description.setText("Annamalai University is one of Asia's largest public residential universities located in Annamalai Nagar, Chidambaram, Tamil Nadu, India. The university is spread across 1,500 acres (6.1 km2) acres in Chidambaram and offers courses of higher education in science, engineering, humanities, agriculture and arts.The university also provides more than 500 courses through distance education.The Directorate of Distance Education (DDE) of Annamalai University offers education to those people who are unable to attend the campus but who desire to study.");
       }
		else if(item.equalsIgnoreCase("amrita"))
	{
	    moduleimage.setImageResource(R.drawable.amrita);
		description.setText("Amrita conducts entrance exams for admission to many of its bachelors and masters level programs. Nation-wide entrance exams are conducted for B Tech, MBBS, BDS, BAMS and MCA. For many other programs, entrance exams are conducted at the schoolspremises.");
       }
		else if(item.equalsIgnoreCase("basueee"))
	{
	    moduleimage.setImageResource(R.drawable.bsau);
		description.setText("B.S. Abdur Rahman University  is a private university in the state of Tamil Nadu, India. Previously functioning under Madras University (1984-01) and Anna University (2001–09) as B. S. Abdur Rahman Crescent Engineering College, the institute gained deemed status in 2008–09. The university is located in Vandalur near Tambaram, a suburban area of Chennai, India. It is one of the largest engineering institutions in India and is ranked among the top-50 engineering colleges of the country.");
       }
		else if(item.equalsIgnoreCase("jnueee"))
	{
	    moduleimage.setImageResource(R.drawable.jnu);
		description.setText("The Jawaharlal Nehru University is one of the premier institutes in India providing higher education. JNU conducts entrance exam called JNU Engineering Entrance Exam for admission to Engineering courses.Every year, lakhs of students take the JNU Entrance Exam in various nooks and corners of the country and seeks to become a part of the JNU community. The JNU Entrance exam is also unique in the sense that apart from providing reservation to the backward sections of the society, it allots deprivation points to the girl candidates and to candidates coming from the least developed states.");
       }
		else if(item.equalsIgnoreCase("beee"))
	{
	    moduleimage.setImageResource(R.drawable.bharath);
		description.setText("Bharath University, formerly Bharath Institute of Higher Education and Research and Bharath Institute of Science and Technology (BIST), is a private deemed university in Chennai, Tamil Nadu, India.");
       }
		else if(item.equalsIgnoreCase("gate"))
	{
	    moduleimage.setImageResource(R.drawable.gate);
		description.setText("The Graduate Aptitude Test in Engineering (GATE) is an all-India examination that primarily tests the comprehensive understanding of various undergraduate subjects in engineering and science. GATE is conducted jointly by the Indian Institute of Science and seven Indian Institutes of Technology (IIT Bombay, IIT Delhi, IIT Guwahati, IIT Kanpur, IIT Kharagpur, IIT Madras and IIT Roorkee) on behalf of the National Coordination Board – GATE, Department of Higher Education, Ministry of Human Resources Development (MHRD), Government of India.");
       }
		else if(item.equalsIgnoreCase("tancet"))
       {
	    moduleimage.setImageResource(R.drawable.tancet);
		description.setText("The Tamil Nadu Common Entrance Test is an eligibility examination for studying post graduate courses like M.E., M.Tech., M.Arch., M.Plan., M.B.A. and M.C.A. in colleges of Tamil Nadu, India. This examination is conducted by Anna University, Chennai. The Government of  Tamilnadu have authorised Anna University for conducting the Tamilnadu Common Entrance Test (TANCET) for admission to 1) M.B.A 2) M.C.A & 3) M.E./ M.Tech./ M.Arch./ M.Plan. Degree Programmes offered in colleges in Tamilnadu.");
       }
		else if(item.equalsIgnoreCase("gre"))
	{
	    moduleimage.setImageResource(R.drawable.gre);
		description.setText("The Graduate Record Examinations (GRE) is a standardised test that is an admissions requirement for most graduate schools in the United States. Created and administered by Educational Testing Service (ETS) in 1949,[8] the exam aims to measure verbal reasoning, quantitative reasoning, analytical writing, and critical thinking skills that have been acquired over a long period of time and that are not related to any specific field of study. The GRE General Test is offered as a computer-based exam administered at Prometric testing centers.");
       }
		else if(item.equalsIgnoreCase("toefl"))
	{
	    moduleimage.setImageResource(R.drawable.toefl);
		description.setText("Test of English as a Foreign Language or TOEFL is a standardised test of English language proficiency for non-native English language speakers wishing to enroll in U.S. universities. The test is accepted by many English-speaking academic and professional institutions. TOEFL is one of the two major English-language tests in the world, the other being the IELTS.TOEFL is a trademark of ETS (Educational Testing Service), a private non-profit organization, which designs and administers the tests. The scores are valid for two years; then they are no longer reported.");
       }
		else if(item.equalsIgnoreCase("ielts"))
	{
	    moduleimage.setImageResource(R.drawable.ielts);
		description.setText("The International English Language Testing System, or IELTS  is an international standardised test of English languageproficiency for non-native English language speakers. It is jointly managed by Cambridge English Language Assessment, the British Council and IDP Education Pvt Ltd, and was established in 1989. IELTS is one of the two major English-language tests in the world, the other being theTOEFL. There are two versions of the IELTS: the Academic Version and the General Training Version");
       }
		else if(item.equalsIgnoreCase("gmat"))
	{
	    moduleimage.setImageResource(R.drawable.gmat);
		description.setText("The Graduate Management Admission Test (GMAT) is a computer adaptive test (CAT) which seeks to assess a person's analytical, writing, quantitative, verbal, and reading skills in standard written English in preparation for being admitted into a graduate management program, such as an MBA. The GMAT does not measure business knowledge or skill. According to the test owning company, the Graduate Management Admission Council (GMAC), the GMAT assesses analytical writing and problem-solving abilities, while also addressing data sufficiency, logic, and critical reasoning skills that it believes to be vital to real-world business and management success.");
       }
		else if(item.equalsIgnoreCase("cat"))
      {
	    moduleimage.setImageResource(R.drawable.cat);
		description.setText("The Common Admission Test (CAT) is a computer based test held in India. This test scores a person on the bases of quantitative ability,data interpretation, verbal ability and logical reasoning. The Indian Institutes of Management (IIMs) started this exam and use the test for selecting students for their business administration programs. The test is conducted every year by one of the IIM's based on a policy of rotation. In August 2011, it was announced that Indian Institutes of Technology (IITs) and Indian Institute of Science (IISc) would also use the CAT scores, instead of the Joint Management Entrance Test (JMET), to select students for their management programmes from 2012-14 year. ");
       }
		else if(item.equalsIgnoreCase("tnpsc"))
	{
	    moduleimage.setImageResource(R.drawable.tnpsc);
		description.setText("The Tamil Nadu Public Service Commission (TNPSC) is a central agency established in 1923 by the Constitution of India that acts to ensure future capability and sustainability within the Public Service in the Indian state of Tamil Nadu. n the year 1923, the Indian Government established a Public Service Commission to examine the salary structure of the Indian Civil Service. The Commission was composed of four Englishmen and four Indian with Lord Lee of Fareham serving as its Chairman. The Commission also addressed the rate of Indianization of the Indian Civil Service and the Indian Police");
       }
}
}
