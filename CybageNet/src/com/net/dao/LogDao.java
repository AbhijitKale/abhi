package com.net.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.net.entity.Book;
import com.net.entity.Log;
import com.net.entity.Review;


public class LogDao 
{

	public static int row=0;
	public static Connection con=null;
	public static Statement st=null;
	public static PreparedStatement pr=null;
	public static ResultSet rs=null;
	public static final String DB_URL="jdbc:mysql://localhost/CybageNet";
	public static final String DB_USERNAME="root";
	public static final	String DB_PASSWORD="root";
	public static String query;
	
	
	Log log1=new Log();

	List<Log> loglist=new ArrayList<Log>();
	public boolean insertLog(Log log) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		query="insert into Log values(?,?)";
		pr=con.prepareStatement(query);
		
		pr.setString(1, log.getUserName());
		pr.setTimestamp(2, log.getTimestamp());
		 int rocnt=pr.executeUpdate();
		 System.out.println(rocnt +"  tt Added added");
			
		
			return false;
		}
		
	
		
		

	


	public List<Log> displayLog() throws SQLException, ParseException, ClassNotFoundException, IOException
	{		try {
		//for registering the driver
		Class.forName("com.mysql.jdbc.Driver");
		//for getting connection 
		con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		//to create the stamt
		st=con.createStatement();
	// Query for execute
		query="select * from log ";
		//execute query
		rs=st.executeQuery(query);
		System.out.println(rs.getMetaData().getColumnName(1));
		while(rs.next())
		{
			log1=new Log();
		//	System.out.println(rs.getInt(1));
			
			log1.setTimestamp(rs.getTimestamp(2));
			log1.setUserName(rs.getString(1));
			
			loglist.add(log1);
			log1=null;
			
			
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
		
	
	return loglist;
	

}
	}