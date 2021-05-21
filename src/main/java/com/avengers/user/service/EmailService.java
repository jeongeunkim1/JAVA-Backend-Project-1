package com.avengers.user.service;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.avengers.user.api.EmailHandler;


@Service
public class EmailService {
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	public void mailSend(HttpSession session,String user_email) {
		try {
			EmailHandler emailHandler = new EmailHandler(mailSender);
			Random random = new Random(System.currentTimeMillis());
			long start = System.currentTimeMillis();
			
			int result = 100000 + random.nextInt(900000);
			
			//받는 사람
			emailHandler.setTo(user_email);
			
			//보내는 사람
			emailHandler.setFrom("dummy210516@gmail.com");
			
			//제목
			emailHandler.setSubject("(주)Avengers 가입 인증번호 입니다.");
			
			//start Html LayOut
			String htmlContent = "<p>인증번호 :"+result+"<p>";
			emailHandler.setText(htmlContent, true);
			
			//end Html LayOut
			emailHandler.send();
			
			long end = System.currentTimeMillis();
			
			//인증번호 체크용 세션
			session.setAttribute(""+user_email,result);
			
			System.out.println("실행 시간 :"+(end-start)/1000.0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
