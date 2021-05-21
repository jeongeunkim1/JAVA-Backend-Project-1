package com.avengers.user.dto;

import java.sql.Date;
import java.util.ArrayList;

public class Jumun {
	private int j_no;
	private Date j_date;
	private String j_desc;
	private int j_price;
	private int user_no;
	private ArrayList<JumunDetail> jumunDetailList;

	public Jumun() {
	}
	
	
	public Jumun(int j_no, Date j_date, String j_desc, int j_price, int user_no) {
		super();
		this.j_no = j_no;
		this.j_date = j_date;
		this.j_desc = j_desc;
		this.j_price = j_price;
		this.user_no = user_no;
		this.jumunDetailList = new ArrayList<JumunDetail>();
	}

	public int getJ_no() {
		return j_no;
	}

	public void setJ_no(int j_no) {
		this.j_no = j_no;
	}

	public Date getJ_date() {
		return j_date;
	}

	public void setJ_date(Date j_date) {
		this.j_date = j_date;
	}

	public String getJ_desc() {
		return j_desc;
	}

	public void setJ_desc(String j_desc) {
		this.j_desc = j_desc;
	}

	public int getJ_price() {
		return j_price;
	}

	public void setJ_price(int j_price) {
		this.j_price = j_price;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public ArrayList<JumunDetail> getJumunDetailList() {
		return jumunDetailList;
	}

	public void setJumunDetailList(ArrayList<JumunDetail> jumunDetailList) {
		this.jumunDetailList = jumunDetailList;
	}

	@Override
	public String toString() {
		return "Jumun [j_no=" + j_no + ", j_date=" + j_date + ", j_desc=" + j_desc + ", j_price=" + j_price
				+ ", user_no=" + user_no + ", jumunDetailList=" + jumunDetailList + "]";
	}
	
}
