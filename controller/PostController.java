package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Post;
import com.examly.springapp.service.PostService;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post/user/{userId}")
    public ResponseEntity<Post> createPostForUser(@PathVariable int userId, @RequestBody Post post) {
        try {
            Post savedPost = postService.createPostForUser(userId, post);
            if (savedPost != null)
                return ResponseEntity.status(201).body(savedPost);
            else
                return ResponseEntity.status(500).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/post")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        if (posts.isEmpty())
            return ResponseEntity.status(404).build();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable int postId) {
        Post post = postService.getPostById(postId);
        if (post != null)
            return ResponseEntity.ok(post);
        else
            return ResponseEntity.status(404).build();
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable int postId, @RequestBody Post post) {
        Post updated = postService.updatePost(postId, post);
        if (updated != null)
            return ResponseEntity.ok(updated);
        else
            return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable int postId) {
        String result = postService.deletePost(postId);
        if (result.equals("Post deleted successfully"))
            return ResponseEntity.ok(result);
        else
            return ResponseEntity.status(404).body(result);
    }
}
