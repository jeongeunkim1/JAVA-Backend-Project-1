package com.avengers.user.dao;

import java.util.List;

import com.avengers.user.dto.Address;

public interface AddressDao {

	// 주소 입력
	public int insertAddress(Address address) throws Exception;

	// 주소 수정
	public int updateAddress(Address address) throws Exception;

	// 주소 삭제
	public int deleteAddress(int address_no) throws Exception;

	// 내 주소 상세정보
	public Address selectAddressByNo(int address_no) throws Exception;

	// 내 주소 리스트
	public List<Address> selectAddressAllByNo(int user_no) throws Exception;

}