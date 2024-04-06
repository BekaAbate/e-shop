
<%@page import="com.shop.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.model.Cart"%>
<%
User user_nav = (User) session.getAttribute("user");
List<Cart> cartList = (List<Cart>) session.getAttribute("cart_list");
%>
<nav class="navbar navbar-expand-md py-3 bg-dark navbar-dark">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">E-Shop</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart
						<%
				if (cartList != null && cartList.size() > 0) {
				%> <span class="badge text-bg-warning rounded-pill"> <%=cartList.size()%>
					</span> <%
 }
 %>
				</a></li>

				<%
				if (user_nav != null) {
				%>

				<li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
				<%
				} else {
				%>

				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
				<%
				}
				%>

			</ul>
		</div>
	</div>
</nav>