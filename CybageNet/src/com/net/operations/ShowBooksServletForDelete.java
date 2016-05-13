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
@WebServlet("/ShowBooksServletForDelete")
public class ShowBooksServletForDelete extends HttpServlet {
	BookDao dao;
	PrintWriter pw;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBooksServletForDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dao=new BookDao();
		List<Book> booklist=null;
		pw=response.getWriter();
		try {
			booklist=dao.displayData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//pw.print("Name");
		//pw.print("Author");
	
		pw.print("<html>");
		pw.print("<body background='C:\\Users\\ajinkyaja\\Desktop\\wall.jpg'>");
		pw.print("<style>");
		
		pw.print("table{border-collapse: collapse;margin: auto;margin-top: 15%;}");
		pw.print("td{border-collapse: collapse;margin: auto;margin-top: 15%;padding: 5px;}");
		pw.print("</style>");
		
		pw.print(" <form method='get' action='DeleteServlet'> ");
		pw.print("<br><br><br><h1 align='center'>Remove Book</h1>");
		pw.print("<table style='width:25%' border-collapse: collapse;margin: auto;margin-top: 15%;>");
		
		pw.print("<tr><td><font style='font-weight: bold;'>ID</td> <td><font style='font-weight: bold;'>NAME</td> <td><font style='font-weight: bold;'>AUTHOR</td></tr>");
		
		for (Book book : booklist) 
	{
			
		pw.print("<tr><td>"+book.getBookId()+"</td>   <td>"+book.getBookName()+"</td>   <td>"+book.getAuthor()+"</td></tr>");
		
	}
		
		
		
		
		
		//pw.print("<table style='width:25%' border-collapse: collapse;margin: auto;margin-top: 15%;>");
		
		pw.print("<tr><td><font style='font-weight: bold;'>Enter book id  : </td>  <td><input type='text' name='deletedBook'></td></tr>");
		pw.print(" <tr><td></td> <td border-collapse: collapse;margin: auto;margin-top: 15%;padding: 5px;><input type='submit' value='Remove Book'> </td></tr>");
		pw.print("</table>");
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
