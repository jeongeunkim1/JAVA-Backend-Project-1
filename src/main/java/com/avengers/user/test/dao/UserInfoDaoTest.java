package com.avengers.user.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dao.UserInfoDao;
import com.avengers.user.dto.UserInfo;

public class UserInfoDaoTest {
	
	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(new String[]{"spring/application-config.xml"});
	
	   UserInfoDao userInfoDao = (UserInfoDao) applicationContext.getBean("userInfoDao");
	
	   // 가입
	   //System.out.println(userInfoDao.insertUserInfo(new UserInfo(0, "이이이", "abcde", "11122", "abcsaa@naver.com")));	   
	   
	   // 수정
	   // System.out.println(userInfoDao.updateUserInfoById(new UserInfo(7,"111","abc@naver.com")));	
	   
	   //탈퇴
	   //System.out.println(userInfoDao.deleteUserInfoByNo(7));	   
	   
	   // 이메일로 아이디찾기(반환값은 UserInfo --> UserInfo.user_id로 뿌릴거임)
	   //System.out.println(userInfoDao.selectUserIdByEmail("abc@naver.com"));	   
			    
	   // 아이디로 비밀번호 찾기(반환값은 UserInfo --> UserInfo.user_password로 뿌릴거임)
	   //System.out.println(userInfoDao.selectUserPasswordById("abcde"));	   
	   
	   // user_no로 회원정보 출력
	   //System.out.println(userInfoDao.selectUserInfoByNo(7));	   
	   
	   // 현재 user_no
	   //System.out.println(userInfoDao.selectCurrentUserNo());
	   System.out.println(userInfoDao.selectAll());
	}

}
