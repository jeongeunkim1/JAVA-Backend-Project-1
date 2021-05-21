package com.avengers.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avengers.user.dto.Comments;
import com.avengers.user.mapper.CommentsMapper;

@Repository("commentsDao")
public class CommentsDaoImpl implements CommentsDao {

	@Autowired
	CommentsMapper commentsMapper;

	@Override
	public Comments findCommentsByNo(int comments_no) throws Exception {

		return commentsMapper.findCommentsByNo(comments_no);
	}

	@Override
	public List<Comments> findCommentsByUserNo(int user_no) throws Exception {
		
		return commentsMapper.findCommentsByUserNo(user_no);
	}

	@Override
	public List<Comments> findCommentsAll() throws Exception {
		
		return commentsMapper.findCommentsAll();
	}

	@Override
	public int insertComments(Comments comments) throws Exception {
		
		return commentsMapper.insertComments(comments);
	}

	@Override
	public int insertCommentsChild(Comments comments) throws Exception {
		
		return commentsMapper.insertCommentsChild(comments);
	}

	@Override
	public int updateCommentsByNo(Comments comments) throws Exception {
		
		return commentsMapper.updateCommentsByNo(comments);
	}

	@Override
	public int deleteCommentsByNo(int comments_no) throws Exception {
		
		return commentsMapper.deleteCommentsByNo(comments_no);
	}

}
