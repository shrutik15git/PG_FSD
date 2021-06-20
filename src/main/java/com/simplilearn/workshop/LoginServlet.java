package com.simplilearn.workshop;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.workshop.model.SystemUser;
import com.simplilearn.workshop.service.SystemUserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        SystemUserService systemUserService = new SystemUserService();
        List<SystemUser> systemUserList = systemUserService.getSystemUserList();
        
        RequestDispatcher rd = null;
        
        for (SystemUser user : systemUserList) {
        	if (username != null && username.contentEquals(user.getUsername()) && 
        		password != null && password.contentEquals(user.getPassword())) {
            	rd = request.getRequestDispatcher("dashboard.jsp");
            	rd.forward(request, response);
            }
        }
        
    	rd = request.getRequestDispatcher("index.html");	
    	out.println("<center><span style = 'color: red'>Invalid Credentials!</span></center>");
    	rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
