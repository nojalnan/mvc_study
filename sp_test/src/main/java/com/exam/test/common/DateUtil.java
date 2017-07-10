package com.exam.test.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil{
	SimpleDateFormat sdfDate;
	SimpleDateFormat sdfTime;
	Date date;
	
	public DateUtil(String dateFormat, String timeFormat){
		this.date = new Date();
		this.sdfDate = new SimpleDateFormat(dateFormat);
		this.sdfTime = new SimpleDateFormat(timeFormat);
	}
	
	public String getDate(){
		return 	this.sdfDate.format(this.date); 
	}
	
	public String getTime(){
		return 	this.sdfTime.format(this.date); 
	}
}
