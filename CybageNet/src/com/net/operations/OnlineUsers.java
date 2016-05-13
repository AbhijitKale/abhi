package com.net.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.net.dao.LoggedDao;

/**
 * Servlet implementation class OnlineUsers
 */
@WebServlet("/OnlineUsers")
public class OnlineUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoggedDao ld;
	List<String> onlineList;
	PrintWriter pw;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession();
		ld = new LoggedDao();
		pw = response.getWriter();
		onlineList = new ArrayList<String>();
		pw.print("Number of Online Users : ");
		try {
			onlineList = ld.displayLogged();
			pw.print(session.getAttribute("count"));
			/*for (String string : onlineList) 
			{
				pw.print(string);
			}
			*/
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
