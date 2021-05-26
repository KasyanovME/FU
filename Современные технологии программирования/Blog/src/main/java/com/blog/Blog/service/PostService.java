package com.blog.Blog.service;

import com.blog.Blog.entity.Post;
import com.blog.Blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void create(Post post){
        postRepository.save(post);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long id){
        return postRepository.findById(id);
    }

    public void updatePost(Post post, Long id) {
        if (findById(id).isPresent()) {
            post.setId(id);
            postRepository.save(post);
        }
    }

    public boolean deletePost(Long id) {
        if (findById(id).isPresent()) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
        postRepository.deleteAll();
    }
}
