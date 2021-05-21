package com.avengers.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.avengers.user.dto.Product;
import com.avengers.user.util.product.ProductListPageMakerDto;
import com.avengers.user.util.productSearch.ProductSearchPageMakerDto;

public interface ProductService {
	
	public List<Product> findProductsAll() throws Exception;

	public List<Product> findByLowPrice(String product_category) throws Exception;

	public List<Product> findByHighPrice(String product_category) throws Exception;

	public List<Product> findNameDesc(String product_category) throws Exception;
	
	public List<Product> findNameAsc(String product_category) throws Exception;
	
	public List<Product> findByLowStar() throws Exception;

	public List<Product> findByHighStar() throws Exception;

	public Product findByProductNo(int product_no) throws Exception;
	
//	public List<Product> findCompleteProduct(int user_no) throws Exception;
	
	public int insertProduct(Product product) throws Exception;

	public int updateProductByNo(Product product) throws Exception;
	
	public int deleteProductByNo(int product_no) throws Exception;
	
	public List<Product> findProductCategory(String product_category) throws Exception;
	
	public int findAllCountByType(String type) throws Exception;
	
	ProductListPageMakerDto findProductList(int currentPage, String product_category)throws Exception;
	
	ProductSearchPageMakerDto findProductByCategory(int currentPage, String category)throws Exception;
	
	public int findProductListCountByCategory(@Param("category") String category) throws Exception;

}