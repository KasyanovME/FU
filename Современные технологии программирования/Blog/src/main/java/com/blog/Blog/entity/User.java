package com.blog.Blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean isActive;

    @OneToMany(mappedBy = "author")
    private Set<Post> post;
}
