package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.Cart;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();

		List<Cart> cartList = new LinkedList<>();

		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("id"));

		List<Cart> carts = (List<Cart>) session.getAttribute("cart_list");

		if (carts == null) {
			Cart cart = new Cart();
			cart.setP_id(id);
			cart.setQuantity(1);
			cartList.add(cart);
			session.setAttribute("cart_list", cartList);
			response.sendRedirect("index.jsp");
		} else {
			if (contains(id, carts)) {
				response.sendRedirect("cart.jsp");
			} else {
//				cartList = carts;
				Cart cart = new Cart();
				cart.setP_id(id);
				cart.setQuantity(1);
				carts.add(cart);
				response.sendRedirect("index.jsp");
			}
		}

	}

	private boolean contains(int id, List<Cart> carts) {
		boolean exist = false;
		for (Cart c : carts) {
			if (c.getP_id() == id)
				exist = true;
		}
		return exist;
	}

}
