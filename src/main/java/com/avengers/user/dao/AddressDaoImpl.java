package com.avengers.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avengers.user.dto.Address;
import com.avengers.user.mapper.AddressMapper;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	AddressMapper addressMapper;
	
	//주소 입력
	@Override
	public int insertAddress(Address address) throws Exception{
		return addressMapper.insertAddress(address);
	};

	//주소 수정
	@Override
	public int updateAddress(Address address) throws Exception{
		return addressMapper.updateAddress(address);
	};
	
	//주소 삭제
	@Override
	public int deleteAddress(int address_no) throws Exception{
		return addressMapper.deleteAddress(address_no);
	};

	//내 주소 상세정보
	@Override
	public Address selectAddressByNo(int address_no) throws Exception{
		return addressMapper.selectAddressByNo(address_no);
	};

	//내 주소 리스트
	@Override
	public List<Address> selectAddressAllByNo(int user_no) throws Exception{
		return addressMapper.selectAddressAllByNo(user_no);
	};
	

}
