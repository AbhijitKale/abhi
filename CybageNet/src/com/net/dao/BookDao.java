package com.net.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.net.entity.Book;

public class BookDao {
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
	public List<Book> displayData() throws SQLException
	{
		List<Book> bookList=new ArrayList<Book>();
		
		
		try {
			//for registering the driver
			Class.forName("com.mysql.jdbc.Driver");
			//for getting connection 
			con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			//to create the stamt
			st=con.createStatement();
		// Query for execute
			query="select * from book ";
			//execute query
			rs=st.executeQuery(query);
			System.out.println(rs.getMetaData().getColumnName(1));
			while(rs.next())
			{
				Book book1=new Book();
				System.out.println(rs.getInt(1));
				book1.setBookId(rs.getInt("id"));
				book1.setBookName(rs.getString("bookname"));
				book1.setAuthor(rs.getString("author"));
				bookList.add(book1);
				book1=null;
				
				
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}
	//to update the data in table
	/*public void updateData(int empid,String order) throws SQLException
	{
		int cnt;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			query="update employee set ortder=? where empid=?";
			pr=con.prepareStatement(query);
			//System.out.println(rs.getMetaData().getColumnName(1));
			
			pr.setString(1,order);
			pr.setInt(2, empid);
			cnt=pr.executeUpdate();
			System.out.println(cnt +" Rows Updated");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	//To insert the data in table
		
		public boolean insertData(Book book1) throws SQLException
		{
			
			int rocnt=0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
				query="insert into Book values(?,?,?)";
				pr=con.prepareStatement(query);
				
				pr.setInt(1, book1.getBookId());
				pr.setString(2, book1.getBookName());
				pr.setString(3, book1.getAuthor());
				 rocnt=pr.executeUpdate();
				 System.out.println(rocnt +"  Book Added added");
			
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rocnt>0)
				 return true;
				return false;
			
		}
		
		//For deleting data from table
		public boolean deleteData(int bookid) throws SQLException
		{
			int cnt=0;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
				query="delete from Book where id=?";
				pr=con.prepareStatement(query);
				//System.out.println(rs.getMetaData().getColumnName(1));
				
				
				pr.setInt(1, bookid);
				cnt=pr.executeUpdate();
				System.out.println(cnt +" Row Deleted");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(cnt>0)
			 return true;
			return false;

		}
	
		
		
		
		public Book searchBook(String name) throws SQLException
		{
			Book book1=null;
			
			
			try {
				//for registering the driver
				Class.forName("com.mysql.jdbc.Driver");
				//for getting connection 
				con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
				//to create the stamt
			
			// Query for execute
				query="select * from book where bookname=?";
				//execute query
				pr=con.prepareStatement(query);
				pr.setString(1,name);
				rs=pr.executeQuery();
				System.out.println(rs.getMetaData().getColumnName(1));
				while(rs.next())
				{
					book1=new Book();
					System.out.println(rs.getInt(1));
					book1.setBookId(rs.getInt("id"));
					book1.setBookName(rs.getString("bookname"));
					book1.setAuthor(rs.getString("author"));
				//	book1=null;
					
					
					
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return book1;
		}
		

}
