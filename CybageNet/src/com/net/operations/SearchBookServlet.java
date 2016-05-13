package com.net.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.net.dao.BookDao;
import com.net.dao.ReviewDao;
import com.net.entity.Book;
import com.net.entity.Review;

/**
 * Servlet implementation class SearchBookServlet
 */

@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   PrintWriter pw;
   ReviewDao rdao;
   BookDao dao;
   Book book;
   List<Review> reviews;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		pw=response.getWriter();
		dao=new BookDao();
		rdao=new ReviewDao();
		
		try {
			
			book=dao.searchBook(request.getParameter("sbookname"));
			
			reviews= rdao.displayReviews(book.getBookId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print(book.toString());
		
		for (Review review : reviews) {
			pw.print(review.getReview());
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
