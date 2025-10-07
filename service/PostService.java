package com.examly.springapp.service;

import com.examly.springapp.model.Post;
import java.util.List;

public interface PostService {
    Post createPostForUser(int userId, Post post);
    List<Post> getAllPosts();
    Post getPostById(int postId);
    Post updatePost(int postId, Post post);
    String deletePost(int postId);
}
