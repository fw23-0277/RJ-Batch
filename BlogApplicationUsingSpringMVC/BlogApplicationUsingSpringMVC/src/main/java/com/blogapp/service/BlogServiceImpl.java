package com.blogapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.model.Blog;
import com.blogapp.reposioty.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogRepository blogRepository;
	
	
	@Override
	public List<Blog> getBlogsByUserId(Integer UserId) {
		return blogRepository.findByAuthorUserId(UserId);
	}

	@Override
	public List<Blog> getBlogsByCategory(String category) {
		return blogRepository.findByCategory(category);
	}

	@Override
	public List<Blog> getBlogByAuthorName(String authorName) {
		return blogRepository.findByAuthorName(authorName);
	}

	@Override
	public void createBlog(Blog blog) {
		blogRepository.save(blog);
	}

	@Override
	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

}
