package com.avengers.user.dto;

public class JumunDetail {
	private int jd_no;
	private int product_no;
	private int jd_quantity;
	private int j_no;
	Product product;
	public JumunDetail() {
		// TODO Auto-generated constructor stub
	}
	public JumunDetail(int jd_no, int product_no, int jd_quantity, int j_no, Product product) {
		super();
		this.jd_no = jd_no;
		this.product_no = product_no;
		this.jd_quantity = jd_quantity;
		this.j_no = j_no;
		this.product = product;
	}
	public int getJd_no() {
		return jd_no;
	}
	public void setJd_no(int jd_no) {
		this.jd_no = jd_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getJd_quantity() {
		return jd_quantity;
	}
	public void setJd_quantity(int jd_quantity) {
		this.jd_quantity = jd_quantity;
	}
	public int getJ_no() {
		return j_no;
	}
	public void setJ_no(int j_no) {
		this.j_no = j_no;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
