package com.Kasyanov_pi19_4.Kasyanov_pi19_4.controllers;

import com.Kasyanov_pi19_4.Kasyanov_pi19_4.entity.Blog;
import com.Kasyanov_pi19_4.Kasyanov_pi19_4.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/blogs")
    public ResponseEntity<List<Blog>> readBlogs() {
        final List<Blog> blogList = blogService.findAll();

        if (blogList != null) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/blogs/{id}")
    public ResponseEntity<Optional<Blog>> readBlog(@PathVariable(name = "id") Long id ) {
        final Optional<Blog> blog = blogService.findById(id);

        if (blog.isPresent()) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/blogs")
    public void createBlog(@RequestBody Blog blog) {
        blogService.create(blog);
    }

    @PutMapping(value = "/blogs/{id}")
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog, @PathVariable(name = "id") Long id) {
        if (blogService.findById(id).isPresent()) {
            blogService.updateBlog(blog, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/blogs/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable(name = "id") Long id) {
        if (blogService.findById(id).isPresent()) {
            blogService.deleteBlog(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/blogs")
    public void deleteAll() {
        blogService.deleteAll();
    }
}
