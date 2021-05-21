package com.avengers.user.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dto.Comments;
import com.avengers.user.service.CommentsService;

public class CommentsServiceTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(new String[]{"spring/application-config.xml"});
		
		CommentsService commentsService = (CommentsService)applicationContext.getBean("commentsService");
		
		System.out.println(commentsService.findCommentsByNo(1));
		System.out.println(commentsService.findCommentsByUserNo(1));
		System.out.println(commentsService.findCommentsAll());
		
		//System.out.println(commentsService.insertComments(new Comments(0, null, "입력하겠습니다~~", 3,0 , 1, 1,2, 3, 3, 3)));
		//System.out.println(commentsService.insertCommentsChild(new Comments(0, null, "대댓글입력하겠습니다~~", 3,4 , 1,1, 2, 1, 2, 1)));
				
		//Comments newComments = new Comments(6, null, "새로운수정입니다~~", 3, 4, 1, 1,2, 1, 2, 1);
		//System.out.println(commentsService.updateCommentsByNo(newComments));
				
		//System.out.println(commentsService.deleteCommentsByNo(8));
		
		
		
	}
}
