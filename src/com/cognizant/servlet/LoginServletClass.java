package com.cognizant.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServletClass
 */
@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int custId=Integer.parseInt(request.getParameter("custId"));
		int pin=Integer.parseInt(request.getParameter("pin"));
		
		
		ServletContext application= getServletContext();
		Connection connection=(Connection)application.getAttribute("con");

		try {
			PreparedStatement statement=connection.prepareStatement("select * from CUSTOMER_AUTH where CUST_ID=? and PIN=?");
			statement.setInt(2, pin);
			statement.setInt(1, custId);
			
			ResultSet resultSet=statement.executeQuery();
			boolean loginResult=false;
			while(resultSet.next())
			{
				loginResult=true;
			}
			
			if(loginResult){
				request.setAttribute("custId", custId);
				HttpSession session=request.getSession(true);
				session.setAttribute("custId", custId);
				RequestDispatcher dispatcher=request.getRequestDispatcher("welcome");
				dispatcher.forward(request, response);		
			}
			else{
				request.setAttribute("custId", custId);
				request.setAttribute("pin", pin);
				RequestDispatcher dispatcher=request.getRequestDispatcher("loginerror");
				dispatcher.forward(request, response);
				
				
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
