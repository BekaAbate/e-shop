<%@page import="com.shop.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// 	HttpSession session = request.getSession();
User user = (User) session.getAttribute("user");

if (user == null) {
	response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>

<%@include file="include/head.jsp"%>
<meta charset="UTF-8">
<title>orders</title>
</head>
<body>

	<%@include file="include/navbar.jsp"%>
	<%

	%>
	<%@include file="include/foot.jsp"%>
</body>
</html>