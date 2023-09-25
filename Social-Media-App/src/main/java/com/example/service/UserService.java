package com.example.service;

import com.example.exception.UserException;
import com.example.model.User;
import com.example.request.LoginRequest;
import com.example.response.AuthResponse;

public interface UserService {
	public AuthResponse createUser(User user) throws UserException;

	public AuthResponse userLogin(LoginRequest loginRequest);
}
