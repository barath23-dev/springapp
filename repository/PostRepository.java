package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {}
