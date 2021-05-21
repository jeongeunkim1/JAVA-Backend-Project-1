package com.avengers.user.dto;

public class Card {

	private String card_no;
	private int card_cvc;
	private String card_deadline;
	private int card_password;
	private String card_password2;
	private int user_no;
	
	public Card() {
		
	}

	public Card(String card_no, int card_cvc, String card_deadline, int card_password, String card_password2,
			int user_no) {
		super();
		this.card_no = card_no;
		this.card_cvc = card_cvc;
		this.card_deadline = card_deadline;
		this.card_password = card_password;
		this.card_password2 = card_password2;
		this.user_no = user_no;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public int getCard_cvc() {
		return card_cvc;
	}

	public void setCard_cvc(int card_cvc) {
		this.card_cvc = card_cvc;
	}

	public String getCard_deadline() {
		return card_deadline;
	}

	public void setCard_deadline(String card_deadline) {
		this.card_deadline = card_deadline;
	}

	public int getCard_password() {
		return card_password;
	}

	public void setCard_password(int card_password) {
		this.card_password = card_password;
	}

	public String getCard_password2() {
		return card_password2;
	}

	public void setCard_password2(String card_password2) {
		this.card_password2 = card_password2;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "Card [card_no=" + card_no + ", card_cvc=" + card_cvc + ", card_deadline=" + card_deadline
				+ ", card_password=" + card_password + ", card_password2=" + card_password2 + ", user_no=" + user_no
				+ "]";
	}
	
}
