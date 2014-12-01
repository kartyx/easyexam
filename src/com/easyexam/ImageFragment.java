package com.easyexam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageFragment extends Fragment {
	private final int imageResourceId;
	private final String title;
	private final int circleId;
	private final String desc; 

	public ImageFragment(int circleId,String desc,String title,int imageResourceId) {
		this.imageResourceId = imageResourceId;
		this.circleId=circleId;
		this.title=title;
		this.desc=desc;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.image_layout, container, false);
		ImageView circle=(ImageView)view.findViewById(R.id.navCircles);
		circle.setImageResource(circleId);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
		imageView.setImageResource(imageResourceId);
		TextView textView=(TextView)view.findViewById(R.id.textview1);
		textView.setText(desc);
		TextView titletext=(TextView)view.findViewById(R.id.title);
		titletext.setText(title);
		return view;
	}
}