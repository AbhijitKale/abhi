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
import com.net.dao.ReviewDao;
import com.net.entity.Review;

/**
 * Servlet implementation class InsertReviewServlet
 */
@WebServlet("/InsertReviewServlet")
public class InsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDao dao;
	PrintWriter pw;
	ReviewDao rdao;
	Review review;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		pw=response.getWriter();
		
		Boolean status=false;
		review=new Review();
		rdao = new ReviewDao();
		review.setReview(request.getParameter("review"));
		review.setRbookid(Integer.parseInt(request.getParameter("rbookid")));
		try {
			status=rdao.insertReviewObject(review);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status==true)
			pw.print("Review added");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
