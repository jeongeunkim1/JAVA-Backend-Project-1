package com.avengers.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avengers.user.dto.Cart;
import com.avengers.user.mapper.CartMapper;

@Repository("cartDao")
public class CartDaoImpl implements CartDao{
	
	@Autowired
	CartMapper cartMapper;
	
	@Override
	public List<Cart> selectCartAllByNo(int user_no) throws Exception{
		return cartMapper.selectCartAllByNo(user_no);
	}
	@Override
	public int insertCart(Cart cart) throws Exception{
		return cartMapper.insertCart(cart);
	}
	@Override
	public int deleteCartByCartNo(int cart_no) throws Exception{
		return cartMapper.deleteCartByCartNo(cart_no);
	}
	@Override
	public int deleteCartByUserNo(int user_no) throws Exception{
		return cartMapper.deleteCartByUserNo(user_no);
	}
//	@Override
//	public List<Cart> findCompleteCart(int user_no) throws Exception {
//		return cartMapper.findCompleteCart(user_no);
//	}
	
	@Override
	public Cart findcartitem(Cart cart) throws Exception {
		return cartMapper.findcartitem(cart);
	}
	
	@Override
	public int updateCartQty(Cart cart) throws Exception {
		return cartMapper.updateCartQty(cart);
	}
	@Override
	public List<Cart> findCartAndProductByNo(int user_no) throws Exception {
		// TODO Auto-generated method stub
		return cartMapper.findCartAndProductByNo(user_no);
	}
	
	@Override
	public Cart findcartitembyNo(int cart_no) throws Exception {
		return cartMapper.findcartitembyNo(cart_no);
	}
}
	
	
	
