package com.avengers.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avengers.user.dao.AddressDao;
import com.avengers.user.dto.Address;

@Repository("addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressDao addressDao;

	// 주소 입력
	@Override
	public int insertAddress(Address address) throws Exception{
		return addressDao.insertAddress(address);
	};

	// 주소 수정
	@Override
	public int updateAddress(Address address) throws Exception {
		return addressDao.updateAddress(address);
	};

	// 주소 삭제
	@Override
	public int deleteAddress(int address_no) throws Exception{
		return addressDao.deleteAddress(address_no);
	};

	// 내 주소 상세정보
	@Override
	public Address selectAddressByNo(int address_no) throws Exception{
		return addressDao.selectAddressByNo(address_no);
	};

	// 내 주소 리스트
	@Override
	public List<Address> selectAddressAllByNo(int user_no) throws Exception{
		return addressDao.selectAddressAllByNo(user_no);
	};
	
}
