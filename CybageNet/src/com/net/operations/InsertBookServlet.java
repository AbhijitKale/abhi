package com.net.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.net.dao.BookDao;
import com.net.entity.Book;

/**
 * Servlet implementation class InsertBookServlet
 */
@WebServlet("/InsertBookServlet")
public class InsertBookServlet extends HttpServlet {
	Book book;
	BookDao dao;
	PrintWriter pw;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		book=new Book();
		dao=new BookDao();
		pw=response.getWriter();
		boolean status=false;
		this.book.setAuthor(request.getParameter("bookauthor"));
		this.book.setBookId(Integer.parseInt(request.getParameter("bookid")));
		this.book.setBookName(request.getParameter("bookname"));
		try {
			status=dao.insertData(book);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status==true)
		{
			
		pw.print("Successfully added");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
