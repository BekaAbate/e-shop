package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.Cart;

/**
 * Servlet implementation class Dec_IncServlet
 */
@WebServlet("/dec-inc")
public class Dec_IncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		List<Cart> carts = (List<Cart>) session.getAttribute("cart_list");
//		out.print(action);
		if(action.equals("dec")) {
			decrement(id, carts);
			response.sendRedirect("cart.jsp");
		}else if (action.equals("inc")) {
			increment(id, carts);
			response.sendRedirect("cart.jsp");
		}

	}

	private void decrement(int id, List<Cart> carts) {
		for (Cart c : carts) {
			if (c.getP_id() == id) {
				if (c.getQuantity() > 1) {
					c.setQuantity(c.getQuantity() - 1);
				}
			}
		}
	}

	private void increment(int id, List<Cart> carts) {
		for (Cart c : carts) {
			if (c.getP_id() == id) {
				c.setQuantity(c.getQuantity() + 1);
			}
		}

	}

}
