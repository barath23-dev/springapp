package com.examly.springapp.controller;

import com.examly.springapp.model.Post;
import com.examly.springapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // POST - /post/user/{userId} create a post and map to user
    @PostMapping("/user/{userId}")
    public ResponseEntity<?> createPostForUser(@PathVariable Integer userId, @RequestBody Post post) {
        try {
            Post saved = postService.createPostForUser(userId, post);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create post for user: " + e.getMessage());
        }
    }

    // GET - /post  list all posts
    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        if (posts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No posts found");
        }
        return ResponseEntity.ok(posts);
    }

    // GET - /post/{postId}
    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Integer postId) {
        return postService.getPostById(postId)
                .map(p -> ResponseEntity.ok(p))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found with ID: " + postId));
    }

    // PUT - /post/{postId} update title and/or content
    @PutMapping("/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable Integer postId, @RequestBody Post post) {
        return postService.updatePost(postId, post)
                .map(updated -> ResponseEntity.ok(updated))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found with ID: " + postId));
    }

    // DELETE - /post/{postId}
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId) {
        String result = postService.deletePost(postId);
        if ("Post deleted successfully".equals(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
}
