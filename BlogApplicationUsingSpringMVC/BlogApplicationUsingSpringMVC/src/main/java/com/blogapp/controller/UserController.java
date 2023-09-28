package com.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.model.User;
import com.blogapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, Authentication session) {
		User authenticatedUser = userService.loginUser(user.getEmail(), user.getPassword());
		System.out.println(authenticatedUser);
		if (authenticatedUser != null) {
			Authentication auth = new UsernamePasswordAuthenticationToken(user.getName(), authenticatedUser,
					AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole()));
			return "redirect:/dashboard";
		} else {
			return "login";
		}
	}

	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/registration")
	public String register(@ModelAttribute("user") User user) {
		userService.registerUser(user);
		return "redirect:/login";
	}
}
