package com.net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class LoginDao 
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
	
	
	public boolean validate(String uname, String upass) throws SQLException
	{		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			 
			con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			
			st=con.createStatement();

			query="select * from login where name=? and password=?";
			
			
			pr=con.prepareStatement(query);
			pr.setString(1, uname);
			pr.setString(2, upass);
			
			rs=pr.executeQuery();					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(rs.next())
			return true;
		return false;
		
	}
}
