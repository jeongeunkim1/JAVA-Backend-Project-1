package com.avengers.user.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.avengers.user.dto.Product;

public interface ProductDao {

	List<Product> findProductsAll() throws Exception;

	List<Product> findByLowPrice(String product_category) throws Exception;

	List<Product> findByHighPrice(String product_category) throws Exception;

	public List<Product> findNameDesc(String product_category) throws Exception;
	
	public List<Product> findNameAsc(String product_category) throws Exception;
	
	List<Product> findByLowStar() throws Exception;

	List<Product> findByHighStar() throws Exception;

	Product findByProductNo(int product_no) throws Exception;
	
//	List<Product> findCompleteProduct(int user_no) throws Exception;

	int insertProduct(Product product) throws Exception;

	int updateProductByNo(Product product) throws Exception;

	int deleteProductByNo(int product_no) throws Exception;
	
	public List<Product> findProductCategory(String product_category) throws Exception;
	
	public int findAllCountByType(String type) throws Exception;
	
	public List<Product> findProductList(@Param("start") int start, @Param("last") int last , @Param("product_category") String product_category) throws Exception;

	public List<Product> findProductByCategory(@Param("start") int start, @Param("last") int last , @Param("category") String category) throws Exception;
	
	public int findProductListCountByCategory(@Param("category") String category ) throws Exception;
}