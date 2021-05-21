package com.avengers.user.dto;

import java.sql.Date;

public class CompanyProduct {

	private int companyProduct_no;
	private String companyProduct_name;
	private String companyProduct_desc;
	private String companyProduct_price;
	private String companyProduct_content;
	private Date companyProduct_date;
	private int user_no;
	// 제품 생성 시 현재 product_no시퀀스 값
	private int product_no;

	public CompanyProduct() {
		// TODO Auto-generated constructor stub
	}


	public CompanyProduct(int companyProduct_no, String companyProduct_name, String companyProduct_desc,
			String companyProduct_price, String companyProduct_content, Date companyProduct_date, int user_no) {
		super();
		this.companyProduct_no = companyProduct_no;
		this.companyProduct_name = companyProduct_name;
		this.companyProduct_desc = companyProduct_desc;
		this.companyProduct_price = companyProduct_price;
		this.companyProduct_content = companyProduct_content;
		this.companyProduct_date = companyProduct_date;
		this.user_no = user_no;
	}
	


	public CompanyProduct(int companyProduct_no, String companyProduct_name, String companyProduct_desc,
			String companyProduct_price, String companyProduct_content) {
		super();
		this.companyProduct_no = companyProduct_no;
		this.companyProduct_name = companyProduct_name;
		this.companyProduct_desc = companyProduct_desc;
		this.companyProduct_price = companyProduct_price;
		this.companyProduct_content = companyProduct_content;
	}


	public int getCompanyProduct_no() {
		return companyProduct_no;
	}

	public void setCompanyProduct_no(int companyProduct_no) {
		this.companyProduct_no = companyProduct_no;
	}

	public String getCompanyProduct_name() {
		return companyProduct_name;
	}

	public void setCompanyProduct_name(String companyProduct_name) {
		this.companyProduct_name = companyProduct_name;
	}

	public String getCompanyProduct_desc() {
		return companyProduct_desc;
	}

	public void setCompanyProduct_desc(String companyProduct_desc) {
		this.companyProduct_desc = companyProduct_desc;
	}

	public String getCompanyProduct_price() {
		return companyProduct_price;
	}

	public void setCompanyProduct_price(String companyProduct_price) {
		this.companyProduct_price = companyProduct_price;
	}

	public String getCompanyProduct_content() {
		return companyProduct_content;
	}

	public void setCompanyProduct_content(String companyProduct_content) {
		this.companyProduct_content = companyProduct_content;
	}

	public Date getCompanyProduct_date() {
		return companyProduct_date;
	}

	public void setCompanyProduct_date(Date companyProduct_date) {
		this.companyProduct_date = companyProduct_date;
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

	@Override
	public String toString() {
		return "CompanyProduct [companyProduct_no=" + companyProduct_no + ", companyProduct_name=" + companyProduct_name
				+ ", companyProduct_desc=" + companyProduct_desc + ", companyProduct_price=" + companyProduct_price
				+ ", companyProduct_content=" + companyProduct_content + ", companyProduct_date=" + companyProduct_date
				+ ", user_no=" + user_no + ", product_no=" + product_no + "]";
	}
	
}