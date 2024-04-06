
<%@page import="com.shop.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 	HttpSession session = request.getSession();
User user = (User) session.getAttribute("user");
if (user != null) {
	response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>

<%@include file="include/head.jsp"%>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

	<%@include file="include/navbar.jsp"%>
	<div class="container">
		<div class="card my-5 w-50 mx-auto">
			<div class="card-header text-center">User Login</div>
			<div class="card-body m-2">
				<form action="login" method="post">
					<div class="form-group m-4">
						<label>Email</label> <input class="form-control" type="email"
							name="email" required placeholder="Enter Your Email">
					</div>
					<div class="form-group m-4">
						<label>Password</label> <input class="form-control"
							type="password" name="password" required
							placeholder="Enter Password">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@include file="include/foot.jsp"%>
</body>
</html>