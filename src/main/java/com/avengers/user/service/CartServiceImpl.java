package com.avengers.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avengers.user.dao.CartDao;
import com.avengers.user.dao.ProductDao;
import com.avengers.user.dto.Cart;

@Service("cartService")
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;
	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Cart> selectCartAllByNo(int user_no) throws Exception{
		return cartDao.selectCartAllByNo(user_no);
	}
	
	@Override
	public int insertCart(Cart cart) throws Exception{
		return cartDao.insertCart(cart);
	}
	
	@Override
	public int deleteCartByCartNo(int cart_no) throws Exception{
		return cartDao.deleteCartByCartNo(cart_no);
	}

	@Override
	public int deleteCartByUserNo(int user_no) throws Exception{
		return cartDao.deleteCartByUserNo(user_no);
	}

//	@Override
//	public List<Cart> findCompleteCart(int user_no) throws Exception {
//		return cartDao.findCompleteCart(user_no);
//	}
	
	@Override
	public Cart findcartitem(Cart cart) throws Exception {
		return cartDao.findcartitem(cart);
	}
	
	@Override
	public int updateCartQty(Cart cart) throws Exception {
		return cartDao.updateCartQty(cart);
	}

	@Override
	public List<Cart> findCartAndProductByNo(int user_no) throws Exception {
		/*
		List<Cart> cartAll= cartDao.selectCartAllByNo(user_no);
		ArrayList<Product> cartListP = new ArrayList<Product>();
		for (Cart cart : cartAll) {
			Product cartP = productDao.findByProductNo(cart.getProduct_no());
			 cartListP.add(cartP);
		}
		*/
		return cartDao.findCartAndProductByNo(user_no);
	}
	
	@Override
	public Cart findcartitembyNo(int cart_no) throws Exception {
		return cartDao.findcartitembyNo(cart_no);
	}
}