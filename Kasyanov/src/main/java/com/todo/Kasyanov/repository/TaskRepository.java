package com.todo.Kasyanov.repository;

import com.todo.Kasyanov.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
