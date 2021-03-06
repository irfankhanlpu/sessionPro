package com.cognizant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MiniStatementServletClass
 */
@WebServlet(name = "MiniStatementServlet", urlPatterns = { "/ministatement" })
public class MiniStatementServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiniStatementServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	int custId=0;
    	try{
		custId=(Integer)request.getAttribute("custId");}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		HttpSession session=request.getSession(false);
		
		
		PrintWriter out=response.getWriter();
		if(session!=null)
		{
			int custIdSession =(Integer)session.getAttribute("custId");
			out.println("Cust Id from request object:"+custId);
			out.println("Cust Id from Session object:"+custIdSession);
			
		}
		else{
			out.println("<p style='red'>Session expired!!</p>");
		}
    	
		
		
	}

}
