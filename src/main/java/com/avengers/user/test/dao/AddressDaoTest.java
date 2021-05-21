package com.avengers.user.test.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dao.AddressDao;
import com.avengers.user.dto.Address;


public class AddressDaoTest {
	public static void main(String[] args) throws Exception, IllegalArgumentException{
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(new String[] {"spring/application-config.xml"});
		
		AddressDao addressDao = (AddressDao)applicationContext.getBean("addressDao");
		//주소 입력
		//System.out.println(addressDao.insertAddress(new Address(0, 55512, "테스트", "테스트", 4)));

		//주소 수정
		//System.out.println(addressDao.updateAddress(new Address(4, 1231, "변경", "변경")));
		
		//주소 삭제
		//System.out.println(addressDao.deleteAddress(4));
		
		//내 주소 상세정보
		//System.out.println(addressDao.selectAddressByNo(3));

		//내 주소 리스트
		//System.out.println(addressDao.selectAddressAllByNo(3));
		
	}
}
