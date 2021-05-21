package com.avengers.user.dto;



import java.util.Date;

public class Comments {
	private int comments_no;
	private Date comments_date;
	private String comments_content;
	private int comments_star;
	private int comments_group_no;
	private int comments_step;
	private int comments_depth;
	private int user_no;
	private int userproduct_no;
	private int product_no;
	private int board_no;
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Comments(int comments_no, Date comments_date, String comments_content, int comments_star,
			int comments_group_no, int comments_step, int comments_depth, int user_no, int userproduct_no,
			int product_no, int board_no) {
		super();
		this.comments_no = comments_no;
		this.comments_date = comments_date;
		this.comments_content = comments_content;
		this.comments_star = comments_star;
		this.comments_group_no = comments_group_no;
		this.comments_step = comments_step;
		this.comments_depth = comments_depth;
		this.user_no = user_no;
		this.userproduct_no = userproduct_no;
		this.product_no = product_no;
		this.board_no = board_no;
	}

	public int getComments_no() {
		return comments_no;
	}

	public void setComments_no(int comments_no) {
		this.comments_no = comments_no;
	}

	public Date getComments_date() {
		return comments_date;
	}

	public void setComments_date(Date comments_date) {
		this.comments_date = comments_date;
	}

	public String getComments_content() {
		return comments_content;
	}

	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}

	public int getComments_star() {
		return comments_star;
	}

	public void setComments_star(int comments_star) {
		this.comments_star = comments_star;
	}

	public int getComments_group_no() {
		return comments_group_no;
	}

	public void setComments_group_no(int comments_group_no) {
		this.comments_group_no = comments_group_no;
	}

	public int getComments_step() {
		return comments_step;
	}

	public void setComments_step(int comments_step) {
		this.comments_step = comments_step;
	}

	public int getComments_depth() {
		return comments_depth;
	}

	public void setComments_depth(int comments_depth) {
		this.comments_depth = comments_depth;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getUserproduct_no() {
		return userproduct_no;
	}

	public void setUserproduct_no(int userproduct_no) {
		this.userproduct_no = userproduct_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	@Override
	public String toString() {
		return "Comments [comments_no=" + comments_no + ", comments_date=" + comments_date + ", comments_content="
				+ comments_content + ", comments_star=" + comments_star + ", comments_group_no=" + comments_group_no
				+ ", comments_step=" + comments_step + ", comments_depth=" + comments_depth + ", user_no=" + user_no
				+ ", userproduct_no=" + userproduct_no + ", product_no=" + product_no + ", board_no=" + board_no + "]";
	}

	
	
}
