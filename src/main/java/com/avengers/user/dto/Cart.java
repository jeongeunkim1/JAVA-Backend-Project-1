package com.avengers.user.dto;

public class Cart {
	/*
	 * 이름 널? 유형 ---------- -------- ---------- CART_NO NUMBER(10,0) USER_NO
	 * NUMBER(10,0) PRODUCT_NO NUMBER(10,0)
	 */
	private int cart_no;
	private int user_no;
	private int product_no;
	private int cart_quantity;
	Product product;

	public Cart() {

	}

	public Cart(int cart_no, int user_no, int product_no, int cart_quantity, Product product) {
		super();
		this.cart_no = cart_no;
		this.user_no = user_no;
		this.product_no = product_no;
		this.cart_quantity = cart_quantity;
		this.product = product;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getCart_quantity() {
		return cart_quantity;
	}

	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", user_no=" + user_no + ", product_no=" + product_no + ", cart_quantity="
				+ cart_quantity + ", product=" + product + "]";
	}

}
