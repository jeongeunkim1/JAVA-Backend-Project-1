package com.avengers.user.dto;

public class UserInfo {
	private int user_no;
	private String user_name;
	private String user_id;
	private String user_password;
	private String user_email;

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int user_no, String user_name, String user_id, String user_password, String user_email) {
		this.user_no = user_no;
		this.user_name = user_name;
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_email = user_email;
	}

	public UserInfo(int user_no, String user_password, String user_email) {
		this.user_no = user_no;
		this.user_password = user_password;
		this.user_email = user_email;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Override
	public String toString() {
		return "UserInfo [user_no=" + user_no + ", user_name=" + user_name + ", user_id=" + user_id + ", user_password="
				+ user_password + ", user_email=" + user_email + "]";
	}

}