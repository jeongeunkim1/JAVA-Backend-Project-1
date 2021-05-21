package com.avengers.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.avengers.user.dto.Product;

public interface ProductMapper {

	public List<Product> findProductsAll() throws Exception;

	public List<Product> findByLowPrice(String product_category) throws Exception;

	public List<Product> findByHighPrice(String product_category) throws Exception;
	
	public List<Product> findNameDesc(String product_category) throws Exception;
	
	public List<Product> findNameAsc(String product_category) throws Exception;

	public List<Product> findByLowStar() throws Exception;

	public List<Product> findByHighStar() throws Exception;

//	public List<Product> findCompleteProduct(int user_no) throws Exception;

	public Product findByProductNo(int product_no) throws Exception;
	
	public int insertProduct(Product product) throws Exception;

	public int updateProductByNo(Product product) throws Exception;
	
	public int deleteProductByNo(int product_no) throws Exception;
	
	public List<Product> findProductCategory(String product_category) throws Exception;
	
	//여성,남성 제품 총 갯수
	public int findAllCountByType(String type) throws Exception;
	
	public List<Product> findProductList(@Param("start") int start, @Param("last") int last , @Param("product_category") String product_category) throws Exception;
	
	public List<Product> findProductByCategory(@Param("start") int start, @Param("last") int last , @Param("category") String category) throws Exception;
	
	public int findProductListCountByCategory(@Param("category") String category ) throws Exception;
}
