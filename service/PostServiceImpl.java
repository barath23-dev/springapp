package com.examly.springapp.service;

import com.examly.springapp.model.Post;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.PostRepository;
import com.examly.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post createPostForUser(Integer userId, Post post) throws Exception {
        Optional<User> userOpt = userRepository.findById(userId);
        if (!userOpt.isPresent()) {
            throw new Exception("User not found with ID: " + userId);
        }
        User user = userOpt.get();
        // maintain both sides
        user.addPost(post);
        userRepository.save(user); // cascades and saves post
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Integer postId) {
        return postRepository.findById(postId);
    }

    @Override
    public Optional<Post> updatePost(Integer postId, Post post) {
        Optional<Post> existing = postRepository.findById(postId);
        if (!existing.isPresent()) {
            return Optional.empty();
        }
        Post p = existing.get();
        if (post.getTitle() != null) p.setTitle(post.getTitle());
        if (post.getContent() != null) p.setContent(post.getContent());
        postRepository.save(p);
        return Optional.of(p);
    }

    @Override
    public String deletePost(Integer postId) {
        Optional<Post> existing = postRepository.findById(postId);
        if (!existing.isPresent()) {
            return "Post not found with ID: " + postId;
        }
        Post p = existing.get();
        // remove from user posts to keep relation clean
        User user = p.getUser();
        if (user != null) {
            user.removePost(p);
            userRepository.save(user);
        } else {
            postRepository.delete(p);
        }
        return "Post deleted successfully";
    }
}
