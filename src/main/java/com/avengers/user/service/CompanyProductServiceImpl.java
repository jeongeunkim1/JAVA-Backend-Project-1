
package com.avengers.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avengers.user.dao.CompanyProductDao;
import com.avengers.user.dto.CompanyProduct;

@Service("companyProductService")
public class CompanyProductServiceImpl implements CompanyProductService {
	@Autowired
	CompanyProductDao companyProductDao;

	// Product insert 후 CompanyProduct에 insert
	@Override
	public int insertCompanyProduct(CompanyProduct companyProduct) {
		return companyProductDao.insertCompanyProduct(companyProduct);
	};

	// 회사가 자신이 판매하는 제품리스트
	@Override
	public List<CompanyProduct> selectCompanyProductAllByNo(int user_no) {
		return companyProductDao.selectCompanyProductAllByNo(user_no);
	};

	// 회사가 자신이 판매하는 제품 상세보기
	@Override
	public CompanyProduct selectCompanyProductByNo(int companyProduct_no) {
		return companyProductDao.selectCompanyProductByNo(companyProduct_no);
	};

	// 회사가 자신이 판매하는 제품 수정
	@Override
	public int updateCompanyProductByNo(CompanyProduct companyProduct) {
		return companyProductDao.updateCompanyProductByNo(companyProduct);
	};

	// 회사가 자신이 등록한 제품 삭제
	@Override
	public int deleteCompanyProductByNo(int companyProduct_no) {
		return companyProductDao.deleteCompanyProductByNo(companyProduct_no);
	};
}
