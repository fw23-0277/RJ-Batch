package com.blogapp.service;

import java.util.List;

import com.blogapp.model.User;

public interface UserService {
	User loginUser(String email, String password);
	List<User> findAll();
	User findById(Integer id);
	User registerUser(User user);
	User edit(User user);
	void deleteById(Integer id);
}

