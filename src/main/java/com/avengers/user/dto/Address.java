package com.avengers.user.dto;

public class Address {
	private int address_no;
	private int address_Zcode;
	private String address_streetOrlot;
	private String address_info;
	private int user_no;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(int address_no, int address_Zcode, String address_streetOrlot, String address_info, int user_no) {
		super();
		this.address_no = address_no;
		this.address_Zcode = address_Zcode;
		this.address_streetOrlot = address_streetOrlot;
		this.address_info = address_info;
		this.user_no = user_no;
	}
	
	public Address(int address_no, int address_Zcode, String address_streetOrlot, String address_info) {
		super();
		this.address_no = address_no;
		this.address_Zcode = address_Zcode;
		this.address_streetOrlot = address_streetOrlot;
		this.address_info = address_info;
	}
	
	public int getAddress_no() {
		return address_no;
	}
	public void setAddress_no(int address_no) {
		this.address_no = address_no;
	}
	public int getAddress_Zcode() {
		return address_Zcode;
	}
	public void setAddress_Zcode(int address_Zcode) {
		this.address_Zcode = address_Zcode;
	}
	public String getAddress_streetOrlot() {
		return address_streetOrlot;
	}
	public void setAddress_streetOrlot(String address_streetOrlot) {
		this.address_streetOrlot = address_streetOrlot;
	}
	public String getAddress_info() {
		return address_info;
	}
	public void setAddress_info(String address_info) {
		this.address_info = address_info;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "Address [address_no=" + address_no + ", address_Zcode=" + address_Zcode + ", address_streetOrlot="
				+ address_streetOrlot + ", address_info=" + address_info + ", user_no=" + user_no + "]";
	}

}