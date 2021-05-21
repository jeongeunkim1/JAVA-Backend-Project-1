package com.avengers.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avengers.user.dto.Product;
import com.avengers.user.mapper.ProductMapper;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> findProductsAll() throws Exception {
		return productMapper.findProductsAll();
	}

	@Override
	public List<Product> findByLowPrice(String product_category) throws Exception {
		return productMapper.findByLowPrice(product_category);
	}

	@Override
	public List<Product> findByHighPrice(String product_category) throws Exception {
		return productMapper.findByHighPrice(product_category);
	}

	@Override
	public List<Product> findByLowStar() throws Exception {
		return productMapper.findByLowStar();
	}

	@Override
	public List<Product> findByHighStar() throws Exception {
		return productMapper.findByHighStar();
	}

	@Override
	public Product findByProductNo(int product_no) throws Exception {
		return productMapper.findByProductNo(product_no);
	}

	@Override
	public int insertProduct(Product product) throws Exception {
		return productMapper.insertProduct(product);
	}

	@Override
	public int updateProductByNo(Product product) throws Exception {
		return productMapper.updateProductByNo(product);
	}

	@Override
	public int deleteProductByNo(int product_no) throws Exception {
		return productMapper.deleteProductByNo(product_no);
	}

	@Override
	public List<Product> findProductCategory(String product_category) throws Exception {
		return productMapper.findProductCategory(product_category);
	}

//	@Override
//	public List<Product> findCompleteProduct(int user_no) throws Exception {
//		return productMapper.findCompleteProduct(user_no);
//	}
	
	@Override
	// 여성,남성 제품 총 갯수
	public int findAllCountByType(String type) throws Exception {
		return productMapper.findAllCountByType(type);
	}

	@Override
	public List<Product> findProductList(int start, int last, String product_category) throws Exception{
		return productMapper.findProductList(start, last, product_category);
	}
	
	@Override
	public List<Product> findNameAsc(String product_category) throws Exception {
		return productMapper.findNameAsc(product_category);
	}
	
	@Override
	public List<Product> findNameDesc(String product_category) throws Exception {
		return productMapper.findNameDesc(product_category);
	}

	@Override
	public List<Product> findProductByCategory(int start, int last, String name) throws Exception{
		return productMapper.findProductByCategory(start, last, name );
	}

	@Override
	public int findProductListCountByCategory(String category) throws Exception{
		return productMapper.findProductListCountByCategory(category);
	}

	
}
