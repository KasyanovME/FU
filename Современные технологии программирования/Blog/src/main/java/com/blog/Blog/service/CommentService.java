package com.blog.Blog.service;

import com.blog.Blog.entity.Comment;
import com.blog.Blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void create(Comment comment){
        commentRepository.save(comment);
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Optional<Comment> findById(Long id){
        return commentRepository.findById(id);
    }

    public void updateComment(Comment comment, Long id) {
        if (findById(id).isPresent()) {
            comment.setId(id);
            commentRepository.save(comment);
        }
    }

    public boolean deleteComment(Long id) {
        if (findById(id).isPresent()) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
        commentRepository.deleteAll();
    }
}
