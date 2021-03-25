package com.blog.Blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String bode;

    @Column(unique = true)
    private String slug;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

}
