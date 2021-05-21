package com.avengers.user.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.UserInfoService;

public class UserInfoServiceTest {
	
	public static void main(String[] args) throws Exception{
	
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(new String[]{"spring/application-config.xml"});
		UserInfoService userInfoService = (UserInfoService) applicationContext.getBean("userInfoService");
	   
		   //가입
		   //System.out.println(userInfoService.insertUserInfo(new UserInfo(0, "이이이", "abcde", "11122", "abcsaa@naver.com")));	   
		   
		   // 수정
		   //System.out.println(userInfoService.updateUserInfoById(new UserInfo(4,"ccc","333")));	
		   
		   // 탈퇴
		   //System.out.println(userInfoService.deleteUserInfoByNo(4));	   
		   
		   // 이메일로 아이디찾기(반환값은 UserInfo --> UserInfo.user_id로 뿌릴거임)
		   //System.out.println(userInfoService.selectUserIdByEmail("333"));	   
				    
		   // 아이디로 비밀번호 찾기(반환값은 UserInfo --> UserInfo.user_password로 뿌릴거임)
		   //System.out.println(userInfoService.selectUserPasswordById("abcde"));	   
		   
		   // user_no로 회원정보 출력
		   //System.out.println(userInfoService.selectUserInfoByNo(3));
		
		   // 현재 user_no 출력
			System.out.println(userInfoService.selectCurrentUserNo());
	}

}
