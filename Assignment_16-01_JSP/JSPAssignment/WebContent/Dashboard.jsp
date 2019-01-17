<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<%
		if(session.getAttribute(request.getParameter("username")) == null) {
			session.setAttribute(request.getParameter("username"), 0);
		} else {
			int temp = Integer.parseInt(session.getAttribute(request.getParameter("username")).toString());
			session.setAttribute(request.getParameter("username"), temp + 1);
		}
		
		out.println("Visits by " + request.getParameter("username") + " : " + session.getAttribute(request.getParameter("username")));
	%>
</body>
</html>