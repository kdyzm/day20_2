<%@ page language="java" import="java.util.*" pageEncoding="utf-8" 
	contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Insert title here!</title>
  </head>
  
  <body>
	<%
		List<HttpSession>list=(ArrayList<HttpSession>)application.getAttribute("userlist");
		for(HttpSession s:list)
		{
			String ip=(String)s.getAttribute("ip");
			out.println(ip+"<br/>");
		}
	%>
  </body>
</html>
