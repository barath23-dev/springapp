package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Post;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.PostRepository;
import com.examly.springapp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post createPostForUser(int userId, Post post) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            post.setUser(user.get());
            return postRepository.save(post);
        }
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(int postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post updatePost(int postId, Post post) {
        Optional<Post> existingPost = postRepository.findById(postId);
        if (existingPost.isPresent()) {
            Post updated = existingPost.get();
            updated.setTitle(post.getTitle());
            updated.setContent(post.getContent());
            return postRepository.save(updated);
        }
        return null;
    }

    @Override
    public String deletePost(int postId) {
        Optional<Post> existingPost = postRepository.findById(postId);
        if (existingPost.isPresent()) {
            postRepository.deleteById(postId);
            return "Post deleted successfully";
        }
        return "Post not found with ID: " + postId;
    }
}
