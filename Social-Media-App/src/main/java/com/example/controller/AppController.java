package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.UserException;
import com.example.model.Comment;
import com.example.model.Like;
import com.example.model.Post;
import com.example.model.User;
import com.example.request.LoginRequest;
import com.example.response.AuthResponse;
import com.example.service.SocialService;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class AppController {
	
	private SocialService socialService;
	private UserService userService;
	
	
	

	
	@Autowired
	public AppController(SocialService socialService, UserService userService) {
		super();
		this.socialService = socialService;
		this.userService = userService;
	}

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
		return new ResponseEntity<AuthResponse>(userService.createUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest logingRequest) {
		return new ResponseEntity<AuthResponse>(userService.userLogin(logingRequest), HttpStatus.OK);
	}
	
	@PostMapping("/post/{userId}")
	public ResponseEntity<Post> postByuser(@PathVariable Integer userId,@RequestBody Post post){
		return new ResponseEntity<Post>(socialService.addPost(userId, post),HttpStatus.OK);
	}
	
	@PostMapping("/post/like/{userId}/{postId}")
	public ResponseEntity<Like> likeByUser(@PathVariable Integer userId,@PathVariable Integer postId, @RequestBody Like like){
		return new ResponseEntity<Like>(socialService.LikeToPost(userId, postId, like),HttpStatus.OK);
		
	}
	
	@PostMapping("/post/comment/{userId}/{postId}") 
	public ResponseEntity<Comment>  commentByUser(@PathVariable Integer userId ,@PathVariable Integer postId, @RequestBody Comment comment){
		return new ResponseEntity<Comment>(socialService.commentToPost(userId, postId, comment),HttpStatus.OK);
	}
	
	@PostMapping("/Post/recoment/{userId}/{commentId}")
	public ResponseEntity<Comment>  commentToOhersComment(@PathVariable Integer userId ,@PathVariable Integer commentId, @RequestBody Comment comment){
		return new ResponseEntity<Comment>(socialService.commentToPost(userId, commentId, comment),HttpStatus.OK);
	}
	
	

}
