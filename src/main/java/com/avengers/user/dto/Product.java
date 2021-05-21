package com.avengers.user.dto;

import java.util.Date;

public class Product {
	private int product_no;
	private String product_name;
	private String product_desc;
	private int product_price;
	private String product_seller;
	private Date product_date;
	private String product_category;
	private String product_image;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int product_no, String product_name, String product_desc, int product_price, String product_seller,
			Date product_date, String product_category, String product_image) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.product_price = product_price;
		this.product_seller = product_seller;
		this.product_date = product_date;
		this.product_category = product_category;
		this.product_image = product_image;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_seller() {
		return product_seller;
	}

	public void setProduct_seller(String product_seller) {
		this.product_seller = product_seller;
	}

	public Date getProduct_date() {
		return product_date;
	}

	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	@Override
	public String toString() {
		return "Product [product_no=" + product_no + ", product_name=" + product_name + ", product_desc=" + product_desc
				+ ", product_price=" + product_price + ", product_seller=" + product_seller + ", product_date="
				+ product_date + ", product_category=" + product_category + ", product_image=" + product_image + "]";
	}

}
