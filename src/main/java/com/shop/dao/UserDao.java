package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shop.model.User;

public class UserDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rst;

	public UserDao(Connection con) {
		this.con = con;
	}

	public User userLogin(String email, String password) {
		User user = null;

		query = "select * from users where email=? and password=?";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rst = pst.executeQuery();

			if (rst.next()) {
				user = new User();
				user.setId(rst.getInt("id"));
				user.setName(rst.getString("name"));
				user.setEmail(rst.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
}
