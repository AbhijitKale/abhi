package com.net.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.net.entity.Log;

public class LoggedDao {
	public static int row=0;
	public static Connection con=null;
	public static Statement st=null;
	public static PreparedStatement pr=null;
	public static ResultSet rs=null;
	public static final String DB_URL="jdbc:mysql://localhost/CybageNet";
	public static final String DB_USERNAME="root";
	public static final	String DB_PASSWORD="root";
	public static String query;
	
	
String user;

	List<String> logedlist=new ArrayList<String>();
	public boolean insertLog(String username) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		query="insert into Logged values(?)";
		pr=con.prepareStatement(query);

		pr.setString(1, username);
		 int rocnt=pr.executeUpdate();
		 System.out.println(rocnt +"  logged Added added");
			
		
			return false;
		}
		
	
		
		

	


	public List<String> displayLogged() throws SQLException, ParseException, ClassNotFoundException, IOException
	{		try {
		//for registering the driver
		Class.forName("com.mysql.jdbc.Driver");
		//for getting connection 
		con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		//to create the stamt
		st=con.createStatement();
	// Query for execute
		query="select * from logged ";
		//execute query
		rs=st.executeQuery(query);
		System.out.println(rs.getMetaData().getColumnName(1));
		while(rs.next())
		{
			user=rs.getString(1);

			
			logedlist.add(user);
			user=null;
			
			
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
		
	
	return logedlist;
	

}
	
	
	public void delete(String username) throws SQLException
	{
		int cnt=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			query="delete from logged where username=?";
			pr=con.prepareStatement(query);
			//System.out.println(rs.getMetaData().getColumnName(1));
			
			
			pr.setString(1, username);
			cnt=pr.executeUpdate();
			System.out.println(cnt +" Row Deleted");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
