package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.model.Cart;
import com.shop.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao {
	private Connection con;
	private String query;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ProductDao(Connection con) {
		this.con = con;
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		query = "select * from products";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				Product product = new Product();
				product.setP_id(rs.getInt("p_id"));
				product.setP_name(rs.getString("p_name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getDouble("price"));
				product.setImage(rs.getString("image"));

				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}

	public List<Product> getProduct(List<Cart> carts) throws SQLException {
		List<Product> products = new ArrayList<Product>();
		for (Cart c : carts) {
			query = "select * from products where p_id=?";
			pst = con.prepareStatement(query);
			pst.setString(1, c.getP_id() + "");
			rs = pst.executeQuery();

			if (rs.next()) {
				Product product = new Product();
				product.setP_id(rs.getInt("p_id"));
				product.setP_name(rs.getString("p_name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getDouble("price"));
				products.add(product);
			}
		}

		return products;
	}
}
