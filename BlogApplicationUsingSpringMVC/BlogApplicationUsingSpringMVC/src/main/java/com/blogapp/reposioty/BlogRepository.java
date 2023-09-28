package com.blogapp.reposioty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapp.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{
	List<Blog> findByAuthorUserId(Integer userId);
	List<Blog> findByCategory(String category);
	List<Blog> findByAuthorName(String name);
}
