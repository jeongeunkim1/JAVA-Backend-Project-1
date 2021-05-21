package com.avengers.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avengers.user.dto.Product;
import com.avengers.user.dto.CompanyProduct;
import com.avengers.user.mapper.CompanyProductMapper;

@Repository("companyProductDao")
public class CompanyProductDaoImpl implements CompanyProductDao {

	@Autowired
	CompanyProductMapper companyProductMapper;

	// Product insert 후 CompanyProduct에 insert
	@Override
	public int insertCompanyProduct(CompanyProduct companyProduct) {
		return companyProductMapper.insertCompanyProduct(companyProduct);
	};

	// 회사가 자신이 판매하는 제품리스트
	@Override
	public List<CompanyProduct> selectCompanyProductAllByNo(int user_no) {
		return companyProductMapper.selectCompanyProductAllByNo(user_no);
	};

	// 회사가 자신이 판매하는 제품 상세보기
	@Override
	public CompanyProduct selectCompanyProductByNo(int companyProduct_no) {
		return companyProductMapper.selectCompanyProductByNo(companyProduct_no);
	};

	// 회사가 자신이 판매하는 제품 수정
	@Override
	public int updateCompanyProductByNo(CompanyProduct companyProduct) {
		return companyProductMapper.updateCompanyProductByNo(companyProduct);
	};

	// 회사가 자신이 등록한 제품 삭제
	@Override
	public int deleteCompanyProductByNo(int companyProduct_no) {
		return companyProductMapper.deleteCompanyProductByNo(companyProduct_no);
	};

}
