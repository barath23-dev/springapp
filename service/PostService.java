package com.examly.springapp.service;

import com.examly.springapp.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post createPostForUser(Integer userId, Post post) throws Exception;
    List<Post> getAllPosts();
    Optional<Post> getPostById(Integer postId);
    Optional<Post> updatePost(Integer postId, Post post);
    String deletePost(Integer postId);
}
