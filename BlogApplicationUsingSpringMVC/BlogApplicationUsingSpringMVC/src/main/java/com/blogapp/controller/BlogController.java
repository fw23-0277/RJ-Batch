package com.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.model.Blog;
import com.blogapp.service.BlogService;

@RestController
@RequestMapping("/api")
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@GetMapping("/dashboard")
	public String showDashboard(Model model) {
		List<Blog> blogs = blogService.getAllBlogs();
		model.addAttribute("blogs", blogs);
		return "dashboard";
	}

	@GetMapping("/create-blog")
	public String showCreateBlog(Model model) {
		model.addAttribute("blog", new Blog());
		return "create-blog";
	}

	@PostMapping("/create-blog")
	public String createBlog(@ModelAttribute("blog") Blog blog) {
		blogService.createBlog(blog);
		return "redirect:/dashboard";
	}
}
