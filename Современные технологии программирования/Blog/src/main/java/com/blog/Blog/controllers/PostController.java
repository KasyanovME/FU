package com.blog.Blog.controllers;

import com.blog.Blog.entity.Post;
import com.blog.Blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> readPost() {
        final List<Post> postList = postService.findAll();

        if (postList != null) {
            return new ResponseEntity<>(postList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<Optional<Post>> readPost(@PathVariable(name = "id") Long id ) {
        final Optional<Post> post = postService.findById(id);

        if (post.isPresent()) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/posts")
    public void createPost(@RequestBody Post post) {
        postService.create(post);
    }

    @PutMapping(value = "/posts/{id}")
    public ResponseEntity<?> updatePost(@RequestBody Post post, @PathVariable(name = "id") Long id) {
        if (postService.findById(id).isPresent()) {
            postService.updatePost(post, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(name = "id") Long id) {
        if (postService.findById(id).isPresent()) {
            postService.deletePost(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/posts")
    public void deleteAll() {
        postService.deleteAll();
    }
}
