package com.avengers.user.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dao.CommentsDao;
import com.avengers.user.dto.Comments;

public class CommentsDaoTest {

	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(new String[] {"spring/application-config.xml"});
		CommentsDao commentsDao = (CommentsDao)applicationContext.getBean("commentsDao");
		
		System.out.println(commentsDao.findCommentsByNo(1));
		System.out.println(commentsDao.findCommentsByUserNo(1));
		System.out.println(commentsDao.findCommentsAll());
		
		//System.out.println(commentsDao.insertComments(new Comments(0, null, "입력하겠습니다~~", 3,0 , 1,1, 2, 1, 3, 3)));
		//System.out.println(commentsDao.insertCommentsChild(new Comments(0, null, "대댓글입력하겠습니다~~", 3,4 , 1,1, 2, 1, 2, 3)));
		
		//Comments newComments = new Comments(1, null, "새로운수정입니다~~", 3, 4, 1,1, 2,1, 2, 3);
		//System.out.println(commentsDao.updateCommentsByNo(newComments));
		
		//System.out.println(commentsDao.deleteCommentsByNo(11));

	}

}
