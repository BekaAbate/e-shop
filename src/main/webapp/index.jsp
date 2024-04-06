<%@page import="com.shop.model.Product"%>
<%@page import="com.shop.model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.dao.ProductDao"%>
<%@page import="com.shop.connection.DbCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> products = pd.getAllProducts();
%>


<!DOCTYPE html>
<html>
<head>
<%@include file="include/head.jsp"%>
<meta charset="UTF-8">
<title>Wellcome</title>
</head>
<body>

	<%@include file="include/navbar.jsp"%>

	<div class="container">
		<div class="card-header my-3 py-3">
			<h3>All Products</h3>
		</div>
		<div class="row">

			<%
			if (products != null) {
				for (Product p : products) {
			%>
			<div class="col-md-3  my-3">
				<div class="card w-100" style="width: 18rem;">
					<img src="product-image/<%=p.getImage()%>" class="card-img-top"
						alt="">
					<div class="card-body">
						<h5 class="card-title">
							<%=p.getP_name()%>
						</h5>
						<p class="price">
							Price: $<%=p.getPrice()%></p>
						<p class="category">
							Category:
							<%=p.getCategory()%>
						</p>
						<div class="mt-3 d-flex justify-content-between">

							<a href="add-to-cart?id=<%=p.getP_id()%>" class="btn btn-dark">Add
								to Cart</a> <a href="#" class="btn btn-primary">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			}
			%>

			<%
// 			List<Cart> carts = (List<Cart>) session.getAttribute("cart_list");
// 			if (carts != null) {
// 				for (Cart c : carts) {
// 					out.print(c.getP_id());
// 				}

// 			}
			%>


		</div>
	</div>

	<%@include file="include/foot.jsp"%>
</body>
</html>