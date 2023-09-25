package com.example.service;

import com.example.model.Comment;
import com.example.model.Like;
import com.example.model.Post;
import com.example.model.Recomment;

public interface SocialService {
	public Post addPost(Integer userId, Post post);
	public Like LikeToPost(Integer userId , Integer postId , Like like);
	public Comment commentToPost(Integer userId ,Integer postId , Comment comment);
	public Recomment commentToOthersComment(Integer userId ,Integer commentId, Recomment recomment);
}
