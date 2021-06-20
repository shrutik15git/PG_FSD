package com.simplilearn.workshop;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.workshop.service.ClassService;
import com.simplilearn.workshop.model.Class;

/**
 * Servlet implementation class ClassReportServlet
 */
@WebServlet("/classReport")
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int classId = Integer.valueOf(request.getParameter("classId"));
		
		if ( classId <= 0 ) {
			PrintWriter out = response.getWriter();
			
			RequestDispatcher rd = request.getRequestDispatcher("/classReportMenu.jsp");	
	    	out.println("<center><span style = 'color: red'>You need to select a class!</span></center>");
	    	rd.include(request, response);
		} else {
			ClassService classService = new ClassService();
			Class tempClass = classService.findById(classId);
			
			request.setAttribute("class", tempClass);
			
			RequestDispatcher rd = request.getRequestDispatcher("/classReport.jsp");
			rd.forward(request, response);
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
