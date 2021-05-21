package com.avengers.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avengers.user.dao.CommentsDao;
import com.avengers.user.dto.Comments;
@Service("commentsService")
public class CommentsServiceImpl implements CommentsService{
	
	@Autowired
	CommentsDao commentsDao;
	

	@Override
	public Comments findCommentsByNo(int comments_no) throws Exception {
		
		return commentsDao.findCommentsByNo(comments_no);
	}

	@Override
	public List<Comments> findCommentsByUserNo(int user_no) throws Exception {
		
		return commentsDao.findCommentsByUserNo(user_no);
	}

	@Override
	public List<Comments> findCommentsAll() throws Exception {
		
		return commentsDao.findCommentsAll();
	}

	@Override
	public int insertComments(Comments comments) throws Exception {
		
		return commentsDao.insertComments(comments);
	}

	@Override
	public int insertCommentsChild(Comments comments) throws Exception {
		
		return commentsDao.insertCommentsChild(comments);
	}

	@Override
	public int updateCommentsByNo(Comments comments) throws Exception {
		
		return commentsDao.updateCommentsByNo(comments);
	}

	@Override
	public int deleteCommentsByNo(int comments_no) throws Exception {
		
		return commentsDao.deleteCommentsByNo(comments_no);
	}

}
