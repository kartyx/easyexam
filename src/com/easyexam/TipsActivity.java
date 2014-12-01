package com.easyexam;

import com.easyexam.R;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TipsActivity extends ModulesActivity implements OnTouchListener{
	String exam_name,module_name;
	TextView t;
	int pos;
	final static float STEP = 200;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    SharedPreferences resumepref;
    Editor editor;
    float fontsize = 13;
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		this.finish();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		framed.removeView(defaultView);
		FrameLayout frameLayout = (FrameLayout)findViewById(R.id.activity_frame);
	    LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View activityView = layoutInflater.inflate(R.layout.tips_activity, null,false);
	    frameLayout.addView(activityView);		
	    t = (TextView) findViewById(R.id.tip);
        t.setTextSize(mRatio + 13);
	    Intent i=getIntent();
		exam_name=i.getStringExtra("ITEM");
		module_name=i.getStringExtra("MODULE");
		resumepref=getSharedPreferences("ResumePrefs",Context.MODE_PRIVATE);
		editor=resumepref.edit();
		editor.putString("resumevalue", "com.easyexam.TipsActivity");
		editor.putString("exam_name", exam_name);
		 editor.commit();

		pos=i.getIntExtra("position", -1);
		setContent(exam_name);
	}
	@Override
	 public boolean onTouchEvent(MotionEvent event) {
	        if (event.getPointerCount() == 2) {
	            int action = event.getAction();
	            int pureaction = action & MotionEvent.ACTION_MASK;
	            if (pureaction == MotionEvent.ACTION_POINTER_DOWN) {
	                mBaseDist = getDistance(event);
	                mBaseRatio = mRatio;
	            } else {
	                float delta = (getDistance(event) - mBaseDist) / STEP;
	                float multi = (float) Math.pow(2, delta);
	                mRatio = Math.min(1024.0f, Math.max(0.1f, mBaseRatio * multi));
	                t.setTextSize(mRatio + 13);
	            }
	        }
	        return true;
	    }

	    int getDistance(MotionEvent event) {
	        int dx = (int) (event.getX(0) - event.getX(1));
	        int dy = (int) (event.getY(0) - event.getY(1));
	        return (int) (Math.sqrt(dx * dx + dy * dy));
	    }
	    @Override
	    public boolean onTouch(View v, MotionEvent event) {
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
		getSupportActionBar().setTitle("GATE tips");
		t.setText("1.Study the syllabus pattern in depth and make a separate list of all topics you need to study\n2.Create a weekly study schedule to keep track of your progress\n" +
				"3.As you study prepare a list of important formulae and points to refer back to\n4.- Practice questions everyday so you do not get out of touch of the topic \n5.Incorporate a wider mix of topics to revise\n" +
				" 6.Study from books designed for GATE preparation\n 7.After completing a chapter practice at least 20-25 questions related to it\n8.Practice your calculation and approximation skills\n" +
				"9. Aim to increase speed with accuracy\n10.- Note the time it takes you to complete a set of 10 questions and practice so you can complete them under 10 minutes");
	}
	private void mhtcet() {
		getSupportActionBar().setTitle("MHTCET tips");
		t.setText("1.Speed and Accuracy\n2.Strengths and Weakness\n3.Divide your time well among all the subjects\n4.Try to solve as much MCQ as you can once you prepare the topic well\n" +
				"5.After completion of one subject try to solve previous year's papers \n7.Try to take out some spare time for yourself to release your tension");
	}
	private void bank() {
		getSupportActionBar().setTitle("BANK EXAM tips");
t.setText("1.Determine what banking information you will be required to know understand.\n 2.Understand how the test will be organized.\n 3.Consider purchasing a study guide.\n" +
		"4. Use good study habits.\n5.Ask others to quiz you.\n6.Keep a cool head.");
	}
	private void lic() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("LIC/GIC tips");
		t.setText("1.Roughly 1125 candidates will be called for interview. So your goal is to get to the interview list by scoring the maximum marks.\n" +
				"2.There are roughly 2.5 months for the written test. So make sure that you cover the prescribed sylabus in time.\n" +
				"3.The syllabus of LIC AAO is not entirely different from any others exams like Bank exams. So those who have prepared for other exams will find this exam relatively easy.\n" +
				"4.There is no information on negative marking for wrong answers. In that case candidates can attempt all questions. Please confirm before attempting the exam that there is no negative marking\n" +
				"5.Please do not forget that you need to pass Paper 2. Most candidates give very less importance to this paper and not even clear.");
	}
	private void defence() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("DEFENCE tips");
		t.setText("1.Fix your goal and start preparing early, as early as after your Class X exam. This will give you an edge over other students.\n" +
				"2.Understand the syllabus thoroughly and make a firm routine so that you cover all the subjects\n3.Go back to your basics, even if that means referring to your Class VI, VII, VIII, books for certain subjects.\n" +
				"4.Improve your English. Start reading a newspaper daily and make it a regular habit to watch news on TV. Also brush up your Grammar skills.\n5.Refer to the past years question papers so that you have a fair idea of what to expect.\n" +
				"6.Identify your weak subjects and start working on them so that you gain a stronghold.\n7.Spend time on understanding yourself, your weak areas and try to strengthen them.\n" +
				"8.Last but not the least, start thinking and behaving like an officer.");
	}
	private void ssc() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("SSC tips");
		t.setText("1.Always keep yourself abreast with the syllabus as soon as it is announced. Be thorough about the syllabus and do not leave out any topic.\n" +
				"2.While, preparing, solve the problems by timing yourself. This way, you can be rest assured that you will manage time very effectively in the examination hall.\n" +
				"3.Solve as many question papers, mock tests and online tests as you can. The more you solve, the more confident you get.\n" +
				"4.Learn tricks, maths short-cuts, memory methods, so as to solve the tests papers in an easy and efficient manner on the day of the exam.\n" +
				"5.Take the help of a coaching institute if need be.");
	}
	private void upsc() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("UPSC tips");
		t.setText("1.Proper analysis of the exam\n2.Focus on your basics\n3.Plan your preparation\n4.Practice is the only key to success\n5.Improve your problem solving and analytical skills\n" +
				"6.Prepare revision notes\n7.Mock Tests\n8.Consistent Revision\n9.Time Management\n10.Give equal importance to recreation");
	}
	private void cet() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("CET tips");
		t.setText("1.Be focussed and determined.\n 2.First solve topicwise questions and then go for solving mixed questions.\n3.Take mock self tests. These will give you a feel of the real exam and when you take the real exam you won’t feel you are doing something new or different." +
				"4.Make proper plan before you actually start the preparation. You should be mentally clear about how you are going to do the preparation.\n 5.Don’t leave the portions as all topics have a weightage.	");
	}
	private void tnea() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("TNEA tips");
		t.setText("1.Keep Calm and Composed\n2.Eat Well\n3.Sleep Well");
	}
	private void upseee() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("UPSEEE tips");
		t.setText("1.Proper analysis of the exam\n2.Focus on your basics\n3.Plan your preparation\n4.Practice is the only key to success\n" +
				"5.Improve your problem solving and analytical skills\n6.Prepare revision notes\n7.Mock Tests");
	}
	private void comedk() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("COMEDK tips");
		t.setText("1.Know COMEDK Exam Very Well\n 2.Develop Judging Ability\n 3.Solve Previous Years’ Papers.\n 4.Avoid Procrastination\n" +
				"5.Go through your notes a day before exam.");
	}
	private void examcet() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("EXAMCET tips");
		t.setText("1.Pracice continuously\n2.Answer every section appropriately in the exam.\n3.Pratice Past papers\n4.Read very carefully before you answer\n" +
				"5.Meticulous planning \n6.Positive attitude\n7.Previous Year papers");
	}
	private void keam() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("KEAM tips");
		t.setText("1.While doing calculations in mathematics use short methods and skip unimportant steps to save your time.\n" +
				"2.Try to solve easy and average questions first as it will help you immensely to get through, go in for the toughest ones. \n" +
				"3.Analysing those areas where you are taking much time to solve the problems The more you Practice, the perfect you will become more confident to attend more questions. \n" +
				"4.Practice quality questions more as doing hundred quality questions is better than doing thousands of questions. \n" +
				"5.Try to finish the paper before the time, so that in the end you get tome to revise you paper. It's good that you know almost all the answers but revision is must.\n" +
				"6.Prepare according to the exam pattern. ");
	}
	private void assam() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("Assam JAT tips");
		t.setText("1.Assam joint admission test is very competitive and securing a good score in the examination is very important in order to secure admission.\n" +
				"2.Determination is the most important thing to clear any examination.\n3.Manage your time carefully.\n" +
				"4.It is recommended that the candidate obtains complete clarity on the examination pattern and then make a preparation plan at least one year before the test date, refer previous years question papers, reference books and enroll in a coaching institute.");
	}
	private void cpet() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("CPET tips");
		t.setText("1.If you do not know thw answer,skip it. Go on with the rest of the test and come back it later. Other parts of the test may have some information that will help you out with that question.\n" +
				"2.When you first receive your test, do a quick survey of the entire test so that you know how to efficiently budget your time.\n" +
				"3.Do easiest problems first. Donot stay on a problem that you are stuck on, especially when time is factor.\n" +
				"4.Only cahnge an answer if you misread of misinterpreted the question because tha first answer that you put is usually the correct one");
	}
	private void jee() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("JEE tips");
		t.setText("1.Always start preparing from 'Basics' because it is really important to have a good base for a right foundation.\n" +
				"2.Try to solve the problem till you exhausted, always give a second or third attempt to the problem before moving to solution page.\n" +
				"3.Do not leave the question in middle. Never jump from one question to another in hurry. Lots of students practice questions without attempting it fully.\n" +
				"4.Always try a question with Conceptual Approach, do not just read the question and start solving it without realising the points that what is being asked in the question\n" +
				"5.Divide your time well for your preparation of boards and for your IIT-JEE. So you will not miss anything. Time management is really important to do well in this exam.\n" +
				"6.Always keep the syllabus with you, before preparing the new topic look at the syllabus first.");
		}
	private void aieee() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("AIEEE tips");
		t.setText("1.Relax\n2.Prioritise\n3.Practice\n4.Divide all the AIEEE Model Papers you use for practice into the following three parts. Each part should be practiced, and timed separately. This is because your strengths and weaknesses in different subject areas vary.");
	}
	private void bitsat() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("BITSAT tips");
		t.setText("1.Take a brief review of the prescribed syllabus\n2.Working knowledge of computer\n3.Preparation Schedule\n4.Practice as much as you can" +
				"5.Sample Papers\n6.Avoid making wild guesses\n7.Time management");
	}
	private void viteee() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("VITEEE tips");
		t.setText("1.VITEEE checks and select students on the basis of concept, speed, accuracy, time management and decision making power\n" +
				"2.Make a proper time table to check your level of preparation as per prescribed syllabus\n 3.Follow the given order to attempt paper\n First: Chemistry\nSecond: Physics\nThird: Maths" +
				"4.VITEEE paper has no negative marking thus try to attempt as many as question but keeping the factor of time management in mind.\n" +
				"5.Sample papers are the best source to judge the level of preparation you have done. So, try to take help from previous year papers and sample papers for better preparations.\n" +
				"6.Last and the most important thing is you need to get updated with the news regarding the entrance exam.");
	}
	private void nat() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("NAT tips");
		t.setText("1.Concentreate on General English \n2.Grammer\n3.Analytical and Logical Reasoning\n4.Quantitative Ability,Data Interpretation,Data Sufficiency\n5.Aviod Procrastination\n 6.Stree management\n7.Take more and more mock test\n 8.Time managemnt\n9.Make schedule\n" +
				"10.Take a Short breaks\n11.Revise regularity\n12.Last year papers");
	}
	private void isat() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("ISAT tips");
		t.setText("1.Perform well in the ISAT, students need to put in a lot of work over a period of time. Even though the competition is less,the exam paper is quite tough. The competition for ISAT admission test is primarily due to the less number of students being inclined towards the Space Science Studies\n" +
				"2.Candidates should havestrong knowledge of the concepts in Physics,chemistry and Mathematics. Clarity of concepts knowledge is an essential that being looked for.\n" +
				"3.Practicing with IIST sample paper is important to know the pattern of the paper.Take timed tests to calculate your problem solving ability");
	}
	private void srm() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("SRM tips");
		t.setText("1.Revise again and again.\n2.Practice as much as you can\n3.Mock Tests/ " +
				"5.Sample Papers\n4.Time management\n6.Spare some time for yourself\n7.Determination and positive attitude are two factors that can really help you in meeting your cherished goal. Hence, instead of worrying about results, just work smartly.");
	}
	private void gmat() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("GMAT tips");
		t.setText("1.Practice a lot\n2.Attempt fist five questions well\n3.Try to complete the exam\n4.Do not waste time\n" +
				"5.Read all the questions carefully\n6.Avoid random guessing");
	}
	private void aueee() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("AUEEE tips");
		t.setText("1.Make a schedule for your study\n 2.Take short breaks \n3. Try to study in the morning time \n4. Make notes \n" +
				"5.Revise regularly\n6. Good language\n 7. Last year papers");
	}
	private void vee() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("VEE tips");
		t.setText("1.Swiftly skim through your text books and course materials before you read them in depth to give you an overview of your subject\n" +
				"2.Before you do any revision, warm up by doing some gentle exercise to relieve any tension in your body and to get a rush of healthy oxygen flowing to your body\n" +
				"3.Plan your time to include study, revision and social commitments-a balance of having fun, taking breaks and studying is vital.\n" +
				"4.Do past papers under thorough exam conditions as often as possible to familiarise yourself with the format and the pressures of working under exam conditions.");
	}
	private void tigure() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("Tigure JEEE tips");
		t.setText("1.Create a study plan keeping your strengths and weaknesses in mind. Your time table should have equal distribution of time for each subject \n" +
				"2.While studying any subject or topic, candidate should devote time for both theory and practical. Solve as many test questions as you can to master that topic. Also, try to finish the paper within the specified time period\n" +
				"3.Keep the habit of reading the question twice and thrice, try to solve it using conceptual approach. Don’t jump on the writing the answering after reading the question half. Avoid this\n" +
				"4.Never mug up things. Try to understand it by studying the theory and solve. Conceptual clarity is absolutely essential because at times you may get question that is the mixture of three different questions\n" +
				"5.Try try till you succeed remember this? Never look for solution before answering the question. Always attempt a problem 2-3 times and if you don’t get the answer then refer the solution. ");
	}
	private void amrita() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("AMRITA tips");
		t.setText("1.Clear basic concepts\n2.Develop problem solving skills\n3.Practice\n4.Develop thinking skills\n5.Judge Question");
	}
	private void bsau() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("BSAU tips");
		t.setText("1.Set a realistic study schedule and begin studying early.\n2.Identify what concepts are most important\n3.Try to identify the content of the questions you will be asked\n" +
				"4.Donot simply memories facts\n 5.Actively summarize\n 6.Review past tests.");
	}
	private void jnu() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("JNU tips");
		t.setText("1.Prepare a time table and maintain it on daily basis.\n2.Equal priority must be given to each and every subject.\n" +
				"3.Lots of sample papers, test papers, and question banks must be solved.\n4.There must be a time table which should be followed every day.\n" +
				"5.The applicant must not lose their confidence level\n.6.Managing time is most important mantra for getting success in any of the examination.\n7.The subject which you feel tough should be taken care and must practice a lot.\n" +
				"8.Applicant must remember that all these exams do have cut off marks in each subject as such the candidates must give equal importance to every subject.\n9.Don’t do guess works in the examination hall as because this type of exams do have negative markings");
	}
	private void beee() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("BEEE tips");
		t.setText("1.Get the examinatin scheme\n2.Know the syllabus\n3.Previous year question papers\n4.Gothrough the model question papers\n5.Make a strategy\n6.Good study materials is the key");
	}
	private void tancet() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("TANCET tips");
		t.setText("1) Collect proper Study materials – Read the syllabus and choose study materials with previous year questions papers.\n" +
				"2) Time management is the most important factor that needs to be followed while preparing for entrance examination. Applicants should practice sample test papers within time constraint.\n" +
				"3) Be strong on basics: Always start your preparation from scratch and move on to difficult theories. If you are not strong in basics, it will become difficult to clear entrance exams.\n" +
				"4) Practice and Evaluation: Put in your efforts in practicing all model question papers. Evaluate your papers to know your weak areas and work on it.\n" +
				"5) Revision: Revising the study materials is equally important as Practice. This will be the last tip to examination.");
	}
	private void gre() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("GRE tips");
		t.setText("1. Go back to high school\n 2.Sleep with your dictionary\n 3.Take a GRE prep course (if you can afford it)");
	}
	private void toefl() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("TOEFL tips");
		t.setText("1.Make sure you understand the TOEFL!\n 2.Be prepared!\n3.Read Everything. Listen to Everything.\n4.Learn how to take good notes.\n" +
				"5. Make sure your pronunciation is clear.\n 6. Get Used to a QWERTY Keyboard\n7. Learn how to write an English Essay \n 8.Practice, practice, practice.\n" +
				"9. Learn how to relax! \n10. Take the test at least twice, if not more.");
	}
	private void ielts() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("IELTS tips");
		t.setText("1.Read the question – answer the question\n2.Don’t start writing too soon–think and plan!\n3. Write enough words\n" +
				"4.Don’t write too many words\n5.Don’t copy whole sections of the question\n6.Time is your enemy – have a plan and a watch\n7.Think about range of vocabulary");
	}
	private void cat() {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle("CAT tips");
		t.setText("1.Start with the fundamentals\n2.Start taking mock tests\n3.Overcome your weaknesses\n4.Accuracy matters\n5.Have faith");
	}
	private void tnpsc()
	{
		getSupportActionBar().setTitle("CAT tips");
		t.setText("1. Work Hard and Practice solved and unsolved questions daily.\n2.Prepare whole topics according to the syllabus.\n3.Prepare according to the previous year exam paper.\n" +
				"4.Practice more and more questions.\n5.Take guidance from the seniors.");
	}
	

	}



