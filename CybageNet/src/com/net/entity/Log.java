package com.net.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.glassfish.external.statistics.TimeStatistic;

public class Log implements Serializable
{
	//DateFormat df=new SimpleDateFormat();
	String userName;
	Timestamp timestamp;
	public Log() {
		// TODO Auto-generated constructor stub
	}
	public Log(String userName, Timestamp timestamp) {
		super();
		this.userName = userName;
		this.timestamp = timestamp;
	}

	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Log [userName=" + userName + ", timestamp=" + timestamp + "]";
	}
	
	

}