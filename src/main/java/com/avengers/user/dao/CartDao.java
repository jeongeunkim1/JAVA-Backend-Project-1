package com.avengers.user.dao;

import java.util.List;

import com.avengers.user.dto.Cart;

public interface CartDao {

	public List<Cart> selectCartAllByNo(int user_no) throws Exception;

	public int insertCart(Cart cart) throws Exception;

	public int deleteCartByCartNo(int cart_no) throws Exception;

	public int deleteCartByUserNo(int user_no) throws Exception;

//	public List<Cart> findCompleteCart(int user_no)throws Exception;
	
	public Cart findcartitem(Cart cart)throws Exception;
	
	public int updateCartQty(Cart cart)throws Exception;
	
	public List<Cart> findCartAndProductByNo(int user_no)throws Exception;
	
	public Cart findcartitembyNo(int cart_no) throws Exception;
	
}