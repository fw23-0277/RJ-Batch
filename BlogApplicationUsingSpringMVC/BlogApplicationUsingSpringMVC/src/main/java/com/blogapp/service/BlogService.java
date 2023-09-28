package com.blogapp.service;

import java.util.List;

import com.blogapp.model.Blog;

public interface BlogService {
	List<Blog> getBlogsByUserId(Integer UserId);
	List<Blog> getBlogsByCategory(String category);
	List<Blog> getBlogByAuthorName(String authorName);
	void createBlog(Blog blog);
	List<Blog> getAllBlogs();
}
