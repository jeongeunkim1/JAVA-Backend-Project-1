package com.avengers.user.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dto.Address;
import com.avengers.user.service.AddressService;

public class AddressServiceTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-config.xml"});

		AddressService addressService = (AddressService) applicationContext.getBean("addressService");

		// 주소 입력
		//System.out.println(addressService.insertAddress(new Address(0, 6666, "테스트", "테스트", 3)));
		// 주소 수정
		//System.out.println(addressService.updateAddress(new Address(5, 1, "변경", "변경")));

		// 주소 삭제
		//System.out.println(addressService.deleteAddress(5));

		// 내 주소 상세정보
		//System.out.println(addressService.selectAddressByNo(1));

		// 내 주소 리스트
		//System.out.println(addressService.selectAddressAllByNo(3));
		
	}

}
