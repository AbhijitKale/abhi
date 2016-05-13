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
import com.net.entity.Book;

/**
 * Servlet implementation class ShowBooksServlet
 */
@WebServlet("/ShowBooksServlet")
public class ShowBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDao dao;
	PrintWriter pw;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao=new BookDao();
		List<Book> booklist=null;
		pw=response.getWriter();
		try {
			booklist=dao.displayData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.print("ID      NAME       AUTHOR");
		//pw.print("Name");
		//pw.print("Author");
	
		pw.print("<html>");
		pw.print("<body>");
		for (Book book : booklist) 
	{
			
		pw.print("<br> ");
		pw.print("<br> ");
		pw.print(book.getBookId()+"   "+book.getBookName()+"   "+book.getAuthor());
		
	}
		/*pw.print(" <form method='get' action='InsertReviewServlet'> ");
		pw.print("Enter the book Id for review -:<input type='text' name='rbookid'>");
		pw.print("Enter the review-: ");
		pw.print("<textarea rows='4' cols='4' name='review'>");
		pw.print("<input type='submit' value='Add Review'> ");*/
		
		//pw.print(" <input type='submit' value='Delete'> ");
		pw.print("</form>");
		pw.print("</body>");
		pw.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
