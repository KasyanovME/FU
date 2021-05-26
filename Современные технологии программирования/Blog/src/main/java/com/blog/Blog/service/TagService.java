package com.blog.Blog.service;


import com.blog.Blog.entity.Tag;
import com.blog.Blog.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public void create(Tag tag){
        tagRepository.save(tag);
    }

    public List<Tag> findAll(){
        return tagRepository.findAll();
    }

    public Optional<Tag> findById(Long id){
        return tagRepository.findById(id);
    }

    public void updateTag(Tag tag, Long id) {
        if (findById(id).isPresent()) {
            tag.setId(id);
            tagRepository.save(tag);
        }
    }

    public boolean deleteTag(Long id) {
        if (findById(id).isPresent()) {
            tagRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
        tagRepository.deleteAll();
    }
}
