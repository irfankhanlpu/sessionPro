package com.cognizant.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServletClass
 */
@WebServlet(name = "WelcomeServlet", urlPatterns = { "/welcome" })
public class WelcomeServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int custId=(Integer)request.getAttribute("custId");
		PrintWriter out=response.getWriter();
		out.println("Cust Id from request object:"+custId);
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			int custIdSession=(Integer)session.getAttribute("custId");
			out.println("</br>cust Id from session object:" + custIdSession);
		}
		else{
			out.println("<p style='red'>Session expired!");
		}
		//to retrieve data from database
		ServletContext application=getServletContext();
		Connection connection=(Connection)application.getAttribute("con");
		
		out.println("</br><a href='ministatement'>Mini Statemnet</a>");
		out.println("</br><a href='fundtransfer'>fund Transfer</a>");
		out.println("</br><a href='logout'>Log Out</a>");
		
		
		
	}

}
