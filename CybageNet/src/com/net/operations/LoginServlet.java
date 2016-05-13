package com.net.operations;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.net.dao.LogDao;
import com.net.dao.LoggedDao;
import com.net.dao.LoginDao;
import com.net.entity.Log;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
    Log log;
    LogDao logdao;
	LoginDao logindao;  
	LoggedDao lastdao;
	static int countLoggedUsers = 0;
	static Cookie visitors = new Cookie("visitor", "0");
	
	//public static File f1=new File("abc");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = 0;
		
		logindao=new LoginDao();
		
		session = request.getSession();
		logdao=new LogDao();
		log=new Log();
		lastdao=new LoggedDao();
		String s1=request.getParameter("name");
		String s2= request.getParameter("pass");
		
	
		
		session.setAttribute("NAME", s1);
		
		
		try {
			if(logindao.validate(s1,s2) == true)
					{
						if(s1.equals("Admin"))
						{
							response.sendRedirect("AdminPage.html");
							//logdao.insertLog(log,f1);
							
						}
							else
							{
								
								String username=s1;
								try {
									lastdao.insertLog(username);
									LoginServlet.countLoggedUsers++;
									session.setAttribute("count",  countLoggedUsers);
									id = Integer.parseInt(visitors.getValue()); 
									id++;
									System.out.println("before : " + id);
									visitors.setValue(String.valueOf(id));
									System.out.println("After : " + String.valueOf(id));
									response.addCookie(visitors);
									
									
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							response.sendRedirect("UserPage.html");
							//logdao.insertLog(log,f1);
							
							}
				
					}
			
			else
			{
				response.sendRedirect("failed.html");
			}
		} catch (SQLException e) {
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
