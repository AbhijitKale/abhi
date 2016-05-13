package com.net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.net.entity.Book;
import com.net.entity.Review;

public class ReviewDao {
	
	public static int row=0;
	public static Connection con=null;
	public static Statement st=null;
	public static PreparedStatement pr=null;
	public static ResultSet rs=null;
	public static final String DB_URL="jdbc:mysql://localhost/CybageNet";
	public static final String DB_USERNAME="root";
	public static final	String DB_PASSWORD="root";
	public static String query;
	
	//to display the data from table 
	public List<Review> displayReviews(int rbookId) throws SQLException
	{
		List<Review> reviewList=new ArrayList<Review>();
		
		
		try {
			//for registering the driver
			Class.forName("com.mysql.jdbc.Driver");
			//for getting connection 
			con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			
			st=con.createStatement();
		// Query for execute
			query="select * from review where bookid=? ";
			//execute query
			
			pr=con.prepareStatement(query);
			pr.setInt(1,rbookId );
			rs=pr.executeQuery();
			
			
			while(rs.next())
			{
				Review review1=new Review();
				System.out.println(rs.getInt(1));
				
				review1.setReviewId(rs.getInt("id"));
				review1.setRbookid(rs.getInt("bookid"));
				
				
				review1.setUsername(rs.getString("username"));
				review1.setReview(rs.getString("review"));
				reviewList.add(review1);
				review1=null;
				
				
				
			}
			
			
			
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reviewList;
	}
	
	
	
	public boolean insertReviewObject(Review review) throws SQLException
	{
		
		int rocnt=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			query="insert into Review values(?,?,?,?)";
			pr=con.prepareStatement(query);
			
			pr.setInt(1, review.getReviewId());
			pr.setInt(2, review.getRbookid());
			pr.setString(3, review.getUsername());
			pr.setString(4,review.getReview());
			 rocnt=pr.executeUpdate();
			 System.out.println(rocnt +"  Review Added ");
		
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rocnt>0)
			 return true;
			return false;
		
	}

	
	

}
