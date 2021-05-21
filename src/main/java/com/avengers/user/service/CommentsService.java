package com.avengers.user.service;

import java.util.List;

import com.avengers.user.dto.Comments;

public interface CommentsService {
public Comments findCommentsByNo(int comments_no) throws Exception;
	
	public List<Comments> findCommentsByUserNo(int user_no) throws Exception ;
	
	public List<Comments> findCommentsAll() throws Exception;
	
	public int insertComments(Comments comments) throws Exception;
	
	public int insertCommentsChild(Comments comments) throws Exception;
	
	public int updateCommentsByNo(Comments comments) throws Exception;
	
	public int deleteCommentsByNo(int comments_no) throws Exception;
}
