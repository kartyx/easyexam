package com.easyexam;

public class RowItem {

	 private String exam_name;
	 private int pic_id;
	 private String status;
	 
	 public RowItem(String exam_name, int pic_id, String status) {

	  this.exam_name = exam_name;
	  this.pic_id = pic_id;
	  this.status = status;
	 }

	 public RowItem(String exam_name,int pic_id)
	 {
		 this.exam_name=exam_name;
		 this.pic_id=pic_id;
	 }
	 public String getExamName() {
	  return exam_name;
	 }

	 public void setExamName(String exam_name) {
	  this.exam_name = exam_name;
	 }

	 public int getPicId() {
	  return pic_id;
	 }

	 public void setPicId(int pic_id) {
	  this.pic_id = pic_id;
	 }

	 public String getStatus() {
	  return status;
	 }

	 public void setStatus(String status) {
	  this.status = status;
	 }

	}
