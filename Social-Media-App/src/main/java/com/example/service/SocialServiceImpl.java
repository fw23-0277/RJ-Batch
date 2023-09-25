package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.OtherException;
import com.example.exception.UserException;
import com.example.model.Comment;
import com.example.model.Like;
import com.example.model.Post;
import com.example.model.Recomment;
import com.example.model.User;
import com.example.repository.CommentRepository;
import com.example.repository.LikeRepository;
import com.example.repository.PostRepository;
import com.example.repository.RecommentRepository;
import com.example.repository.UserRepository;

@Service
public class SocialServiceImpl implements SocialService {

	private PostRepository postRepository;
	private UserRepository userRepository;
	private CommentRepository commentRepository;
	private LikeRepository likeRepository;
	private RecommentRepository recommentRepository;

	
	@Autowired
	public SocialServiceImpl(PostRepository postRepository, UserRepository userRepository,
			CommentRepository commentRepository, LikeRepository likeRepository,
			RecommentRepository recommentRepository) {
		super();
		this.postRepository = postRepository;
		this.userRepository = userRepository;
		this.commentRepository = commentRepository;
		this.likeRepository = likeRepository;
		this.recommentRepository = recommentRepository;
	}

	@Override
	public Post addPost(Integer userId, Post post) {
		Optional<User> userOpt = userRepository.findById(userId);
		User user = userOpt.orElseThrow(() -> new UserException("User Not Found Give id " + userId));
		post.setUser(user);

		postRepository.save(post);
		return post;
	}

	@Override
	public Like LikeToPost(Integer userId, Integer postId, Like like) {
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepository.findById(userId);
		User user = userOpt.orElseThrow(() -> new UserException("User Not Found Give id " + userId));
		
		Optional<Post> postOpt =  postRepository.findById(postId);
		
		Post post =  postOpt.orElseThrow(()-> new OtherException("Post Not Found"));
		
		like.setLikeStatus(true);
		like.setPost(post);
		
		likeRepository.save(like);
		
		return like;
	}

	@Override
	public Comment commentToPost(Integer userId, Integer postId, Comment comment) {
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepository.findById(userId);
		User user = userOpt.orElseThrow(() -> new UserException("User Not Found Give id " + userId));
		
		Optional<Post> postOpt =  postRepository.findById(postId);
		
		Post post =  postOpt.orElseThrow(()-> new OtherException("Post Not Found"));
		
		commentRepository.save(comment);
		
		return comment;
	}

	@Override
	public Recomment commentToOthersComment(Integer userId, Integer commentId, Recomment recomment) {
		// TODO Auto-generated method stub
		return null;
	}

}
