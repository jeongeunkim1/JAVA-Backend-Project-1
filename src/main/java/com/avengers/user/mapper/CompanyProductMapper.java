package com.avengers.user.mapper;

import java.util.List;

import com.avengers.user.dto.CompanyProduct;

public interface CompanyProductMapper {
	
	//Product insert 후 CompanyProduct에 insert
	public int insertCompanyProduct(CompanyProduct companyProduct);
	
	//회사가 자신이 판매하는 제품리스트
	public List<CompanyProduct> selectCompanyProductAllByNo(int user_no);

	//회사가 자신이 판매하는 제품 상세보기
	public CompanyProduct selectCompanyProductByNo(int companyProduct_no);

	//회사가 자신이 판매하는 제품 수정
	public int updateCompanyProductByNo(CompanyProduct companyProduct);

	//회사가 자신이 등록한 제품 삭제
	public int deleteCompanyProductByNo(int companyProduct_no);

}
