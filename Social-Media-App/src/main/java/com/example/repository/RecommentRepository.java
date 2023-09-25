package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Recomment;

public interface RecommentRepository extends JpaRepository<Recomment,Integer>{

}
