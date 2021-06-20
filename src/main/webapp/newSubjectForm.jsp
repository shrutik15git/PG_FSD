
<%@ page import="com.simplilearn.workshop.model.Class" %>
<%@ page import="com.simplilearn.workshop.service.ClassService"%>
<%@ page import="com.simplilearn.workshop.model.Teacher" %>
<%@ page import="com.simplilearn.workshop.service.TeacherService"%>
<%@ page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.register {border: 1px solid #000; margin: 10px; background-color: #ADD8E6;color: black;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
	.previous {border: 1px solid #000; margin: 10px; background-color: #f1f1f1;color: black;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
</style>
<meta charset="ISO-8859-1">
<title>Register Subject</title>
</head>
<body>
	<div style="text-align: center">
		<h1>New Subject</h1>
		
		<%! ClassService classService = new ClassService(); 
			TeacherService teacherService = new TeacherService();
		%>  
		<% List<Class> classList = classService.getClassList();
		   request.setAttribute("classList", classList);
		   
		   List<Teacher> teacherList = teacherService.getTeacherList();
		   request.setAttribute("teacherList", teacherList);
		%>
				
		<form action="registerSubject" method="post">
			<label for="name">Name:</label>
			<input type="text" id="name" name="name">
			<br><br>
			<label for="code">Code:</label>
			<input type="text" id="code" name="code">
			<br><br>
			<label for="classId">Class:</label>
			<select id="classId" name="classId">
				<c:forEach items="${classList}" var="item">
				    <option value="${item.id}">${item.name}</option>
				</c:forEach>			
			</select>
			<br><br>
			<label for="teacherId">Teacher:</label>
			<select id="teacherId" name="teacherId">
				<c:forEach items="${teacherList}" var="teacher">
				    <option value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
				</c:forEach>			
			</select>
			<br/><br/>
			<input class="register" type="submit" name="register" value="Register Subject">
			<br/>
			<a href="/learning-academy/dashboard.jsp" class="previous">&laquo; Back to Dashboard</a>
		</form>
	</div>	
</body>
</html>