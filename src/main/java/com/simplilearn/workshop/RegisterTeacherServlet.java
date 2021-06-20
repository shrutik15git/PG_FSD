package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.workshop.model.Teacher;
import com.simplilearn.workshop.service.TeacherService;

/**
 * Servlet implementation class RegisterTeacherServlet
 */
@WebServlet("/registerTeacher")
public class RegisterTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		if ( firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || email == null || email.isEmpty() ) {
			PrintWriter out = response.getWriter();
			
			RequestDispatcher rd = request.getRequestDispatcher("/newTeacherForm.jsp");	
	    	out.println("<center><span style = 'color: red'>All fields are required!</span></center>");
	    	rd.include(request, response);
		} else {
			TeacherService teacherService = new TeacherService();
			
			Teacher teacher = new Teacher();
			teacher.setFirstName(firstName);
			teacher.setLastName(lastName);
			teacher.setEmail(email);
			
			teacherService.save(teacher);
			
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
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
