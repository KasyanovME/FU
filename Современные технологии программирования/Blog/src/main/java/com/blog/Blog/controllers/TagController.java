package com.blog.Blog.controllers;

import com.blog.Blog.entity.Tag;
import com.blog.Blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping(value = "/tags")
    public ResponseEntity<List<Tag>> readTag() {
        final List<Tag> tagList = tagService.findAll();

        if (tagList != null) {
            return new ResponseEntity<>(tagList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tags/{id}")
    public ResponseEntity<Optional<Tag>> readTag(@PathVariable(name = "id") Long id ) {
        final Optional<Tag> tag = tagService.findById(id);

        if (tag.isPresent()) {
            return new ResponseEntity<>(tag, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/tags")
    public void createTag(@RequestBody Tag tag) {
        tagService.create(tag);
    }

    @PutMapping(value = "/tags/{id}")
    public ResponseEntity<?> updateTag(@RequestBody Tag tag, @PathVariable(name = "id") Long id) {
        if (tagService.findById(id).isPresent()) {
            tagService.updateTag(tag, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/tags/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable(name = "id") Long id) {
        if (tagService.findById(id).isPresent()) {
            tagService.deleteTag(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/tags")
    public void deleteAll() {
        tagService.deleteAll();
    }
}
