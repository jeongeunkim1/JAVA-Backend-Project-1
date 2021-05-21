package com.avengers.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avengers.user.dao.ProductDao;
import com.avengers.user.dto.Product;
import com.avengers.user.util.product.PageMaker;
import com.avengers.user.util.product.ProductListPageMakerDto;
import com.avengers.user.util.productSearch.PageMakerSearch;
import com.avengers.user.util.productSearch.ProductSearchPageMakerDto;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDoa;

	@Override
	public List<Product> findProductsAll() throws Exception {
		return productDoa.findProductsAll();
	}

	@Override
	public List<Product> findByLowPrice(String product_category) throws Exception {
		return productDoa.findByLowPrice(product_category);
	}

	@Override
	public List<Product> findByHighPrice(String product_category) throws Exception {
		return productDoa.findByHighPrice(product_category);
	}

	@Override
	public List<Product> findByLowStar() throws Exception {
		return productDoa.findByLowStar();
	}

	@Override
	public List<Product> findByHighStar() throws Exception {
		return productDoa.findByHighStar();
	}

	@Override
	public Product findByProductNo(int product_no) throws Exception {
		return productDoa.findByProductNo(product_no);
	}

	@Override
	public int insertProduct(Product product) throws Exception {
		return productDoa.insertProduct(product);
	}

	@Override
	public int updateProductByNo(Product product) throws Exception {
		return productDoa.updateProductByNo(product);
	}

	@Override
	public int deleteProductByNo(int product_no) throws Exception {
		return productDoa.deleteProductByNo(product_no);
	}

	@Override
	public List<Product> findProductCategory(String product_category) throws Exception {
		
		return productDoa.findProductCategory(product_category);
	}

//	@Override
//	public List<Product> findCompleteProduct(int user_no) throws Exception {
//		return productDoa.findCompleteProduct(user_no);
//	}
	
	@Override
	// 여성,남성 제품 총 갯수
	public int findAllCountByType(String type) throws Exception {
		return productDoa.findAllCountByType(type);
	}

	@Override
	public ProductListPageMakerDto findProductList(int currentPage, String product_category) throws Exception {

			//상품 전체의 갯수
			int totalProductCount = productDoa.findAllCountByType(product_category);
			//paging계산
		      PageMaker pageMaker = new PageMaker(totalProductCount, currentPage);
		    //상품데이터
		      List<Product> productList = productDoa.findProductList(pageMaker.getPageBegin(),pageMaker.getPageEnd(),product_category);
		      ProductListPageMakerDto productPageMaker = new ProductListPageMakerDto();
		      productPageMaker.totRecordCount = totalProductCount;
		      productPageMaker.productList = productList;
		      productPageMaker.pageMaker = pageMaker;
		return productPageMaker;
	};	

	@Override
	public List<Product> findNameAsc(String product_category) throws Exception {
		return productDoa.findNameAsc(product_category);
	}
	
	@Override
	public List<Product> findNameDesc(String product_category) throws Exception {
		return productDoa.findNameDesc(product_category);
	}

	
	@Override
	public ProductSearchPageMakerDto findProductByCategory(int currentPage, String category) throws Exception {
		//상품 전체의 갯수
		int totalProductCount = productDoa.findProductListCountByCategory(category);
		//paging계산
		PageMakerSearch pageMakerSearch = new PageMakerSearch(totalProductCount, currentPage);
	    //상품데이터
	      List<Product> productList = productDoa.findProductByCategory(pageMakerSearch.getPageBegin(),pageMakerSearch.getPageEnd(),category);
	      ProductSearchPageMakerDto productSearchPageMaker = new ProductSearchPageMakerDto();
	      productSearchPageMaker.totRecordCount = totalProductCount;
	      productSearchPageMaker.productList = productList;
	      productSearchPageMaker.pageMakerSearch = pageMakerSearch;
	return productSearchPageMaker;
	}

	@Override
	public int findProductListCountByCategory(String category ) throws Exception {
		return productDoa.findProductListCountByCategory(category);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
