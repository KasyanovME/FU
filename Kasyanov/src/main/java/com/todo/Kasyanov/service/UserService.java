package com.todo.Kasyanov.service;


import com.todo.Kasyanov.entity.User;
import com.todo.Kasyanov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void create(User user){
        userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public void updateUser(User user, Long id) {
        if (findById(id).isPresent()) {
            user.setId(id);
            userRepository.save(user);
        }
    }

    public boolean deleteUser(Long id) {
        if (findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }
}
