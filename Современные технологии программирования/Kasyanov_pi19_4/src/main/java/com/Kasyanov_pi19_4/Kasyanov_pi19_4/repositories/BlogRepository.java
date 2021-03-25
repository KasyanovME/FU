package com.Kasyanov_pi19_4.Kasyanov_pi19_4.repositories;

import com.Kasyanov_pi19_4.Kasyanov_pi19_4.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
