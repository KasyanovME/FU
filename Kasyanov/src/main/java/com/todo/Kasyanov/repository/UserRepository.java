package com.todo.Kasyanov.repository;

import com.todo.Kasyanov.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
