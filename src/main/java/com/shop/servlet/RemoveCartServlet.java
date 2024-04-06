package com.shop.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.Cart;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/remove-cart")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Cart> carts = (List<Cart>) session.getAttribute("cart_list");
		int id = Integer.parseInt(request.getParameter("id"));
		
		/*
		 * for(Cart c : carts) { if (c.getP_id() == id) { carts.remove(c); } }
		 * response.sendRedirect("cart.jsp");
		 */	
		
		Iterator<Cart> iterator = carts.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getP_id() == id) {
				iterator.remove();
			}
		}
		response.sendRedirect("cart.jsp");
	}
}
