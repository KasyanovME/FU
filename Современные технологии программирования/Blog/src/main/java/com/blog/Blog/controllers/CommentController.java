package com.blog.Blog.controllers;

import com.blog.Blog.entity.Comment;
import com.blog.Blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/comments")
    public ResponseEntity<List<Comment>> readComment() {
        final List<Comment> commentList = commentService.findAll();

        if (commentList != null) {
            return new ResponseEntity<>(commentList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/comments/{id}")
    public ResponseEntity<Optional<Comment>> readComment(@PathVariable(name = "id") Long id ) {
        final Optional<Comment> comment = commentService.findById(id);

        if (comment.isPresent()) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/comments")
    public void createComment(@RequestBody Comment comment) {
        commentService.create(comment);
    }

    @PutMapping(value = "/comments/{id}")
    public ResponseEntity<?> updateComment(@RequestBody Comment comment, @PathVariable(name = "id") Long id) {
        if (commentService.findById(id).isPresent()) {
            commentService.updateComment(comment, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable(name = "id") Long id) {
        if (commentService.findById(id).isPresent()) {
            commentService.deleteComment(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/comments")
    public void deleteAll() {
        commentService.deleteAll();
    }
}
