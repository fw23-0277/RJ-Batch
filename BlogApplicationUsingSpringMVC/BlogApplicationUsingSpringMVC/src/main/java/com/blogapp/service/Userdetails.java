package com.blogapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.blogapp.model.User;
import com.blogapp.reposioty.UserRepository;

@Service
public class Userdetails implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		System.out.println(username);
		if (user != null) {

			List<GrantedAuthority> authorities = new ArrayList<>();

			String role = user.getRole();
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(role);

			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);

		} else
			throw new BadCredentialsException("User Details not found with this username: " + username);

	}

}
