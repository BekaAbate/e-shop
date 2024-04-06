<%@page import="java.math.RoundingMode"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.shop.model.Product"%>
<%@page import="com.shop.connection.DbCon"%>
<%@page import="com.shop.dao.ProductDao"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Cart> carts = (List<Cart>) session.getAttribute("cart_list");
ProductDao pdao = new ProductDao(DbCon.getConnection());
List<Product> products;
DecimalFormat format = new DecimalFormat("$#,###.00");
%>
<!DOCTYPE html>
<html>
<head>

<%@include file="include/head.jsp"%>
<style type="text/css">
@media ( min-width : 768px) {
	.w-md-custom {
		width: 50%;
	}
}

.btn-decre, .btn-incre {
	font-size: 20px
}
</style>
<meta charset="UTF-8">
<title>cart</title>
</head>
<body>

	<%@include file="include/navbar.jsp"%>
	<div class="container">
		<div class="d-flex py-3">
			<h4>
				Total Price:
				<%
			double sum = 0;
			if (carts != null) {
				products = pdao.getProduct(carts);
				for (Product p : products) {
					for (Cart c : carts) {
				if (c.getP_id() == p.getP_id()) {

					sum = sum + (p.getPrice() * c.getQuantity());
				}
					}
				}
			}

			// 			DecimalFormat format = new DecimalFormat("#." + "0".repeat(2));
			// 			format.setRoundingMode(RoundingMode.HALF_UP);
			out.print(format.format(sum));
			%>
			</h4>
			<a class="mx-3 btn btn-primary" href="#">Check Out</a>

		</div>
		<table class="table">
			<thead class="table-light">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<%
			if (carts != null) {

				products = pdao.getProduct(carts);
				for (Product p : products) {
			%>
			<tbody>
				<tr>
					<td><%=p.getP_name()%></td>
					<td><%=p.getCategory()%></td>
					<td>
						<%
						for (Cart c : carts) {
							if (c.getP_id() == p.getP_id()) {
								out.print(format.format(p.getPrice() * c.getQuantity()));
							}
						}
						%>
					</td>
					<td>
						<form action="" method="post" class="from-inline">
							<input type="hidden" name="id" value="<%=p.getP_id()%>">
							<div
								class="form-group d-flex justify-content-between w-md-custom">
								<a class="btn btn-sm btn-decre"
									href="dec-inc?action=dec&id=<%=p.getP_id()%>"> <i
									class="fas fa-minus-square" style="color: #5468ff;"></i>
								</a> <input type="text" name="quatity"
									value="<%for (Cart c : carts) {
	if (c.getP_id() == p.getP_id()) {
		out.print(c.getQuantity());
	}
}%>"
									class="form-control" readonly="readonly"> <a
									class="btn btn-sm btn-decre"
									href="dec-inc?action=inc&id=<%=p.getP_id()%>"> <i
									class="fas fa-plus-square" style="color: #5468ff;"></i></a>

							</div>
						</form>
					</td>
					<td><a class="btn btn-sm btn-danger"
						href="remove-cart?id=<%=p.getP_id()%>">Remove</a></td>

				</tr>
			</tbody>
			<%
			}
			}
			%>

		</table>
	</div>
	<%@include file="include/foot.jsp"%>
</body>
</html>