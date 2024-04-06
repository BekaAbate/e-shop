package com.shop.model;

public class Product {
	private int p_id;
	private String p_name;
	private String category;
	private double price;
	private String image;

	public Product() {
	}

	public Product(int p_id, String p_name, String category, double price, String image) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.category = category;
		this.price = price;
		this.image = image;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
