package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.connection.DbCon;
import com.shop.dao.UserDao;
import com.shop.model.User;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
//		out.print("connected");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		try {
			UserDao userdao = new UserDao(DbCon.getConnection());
			User user = userdao.userLogin(email, password);
			if (user != null) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				res.sendRedirect("index.jsp");
			} else {
				out.print("wrong email or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
