package com.easyexam;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	static ViewHolder holder = null;

 Context context;
 List<RowItem> rowItems;

 CustomAdapter(Context context, List<RowItem> rowItems) {
  this.context = context;
  this.rowItems = rowItems;
 }

 @Override
 public int getCount() {
  return rowItems.size();
 }

 @Override
 public Object getItem(int position) {
  return rowItems.get(position);
 }

 @Override
 public long getItemId(int position) {
  return rowItems.indexOf(getItem(position));
 }

 /* private view holder class */
 class ViewHolder {
  ImageView pic;
  TextView name;
  TextView status;
 }

 @Override
 public View getView(int position, View convertView, ViewGroup parent) {


  LayoutInflater mInflater = (LayoutInflater) context
    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
  if (convertView == null) {
   convertView = mInflater.inflate(R.layout.list, null);
   holder = new ViewHolder();

   holder.name = (TextView) convertView
     .findViewById(R.id.name);
   holder.pic = (ImageView) convertView
     .findViewById(R.id.pic);
   holder.status = (TextView) convertView.findViewById(R.id.status);
   

   convertView.setTag(holder);
  } else {
   holder = (ViewHolder) convertView.getTag();
  }
  RowItem row_pos = rowItems.get(position);

  holder.pic.setImageResource(row_pos.getPicId());
  holder.name.setText(row_pos.getExamName());
  holder.status.setText(row_pos.getStatus());

  return convertView;
 }

}