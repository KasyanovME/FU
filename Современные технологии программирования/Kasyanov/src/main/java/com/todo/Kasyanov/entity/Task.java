package com.todo.Kasyanov.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date date_of_execute;
    private boolean is_executed;
    private Date date_of_creation;
    private Date date_of_update;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    private Set<Category> category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_of_execute() {
        return date_of_execute;
    }

    public void setDate_of_execute(Date date_of_execute) {
        this.date_of_execute = date_of_execute;
    }

    public boolean isIs_executed() {
        return is_executed;
    }

    public void setIs_executed(boolean is_executed) {
        this.is_executed = is_executed;
    }

    public Date getDate_of_creation() {
        return date_of_creation;
    }

    public void setDate_of_creation(Date date_of_creation) {
        this.date_of_creation = date_of_creation;
    }

    public Date getDate_of_update() {
        return date_of_update;
    }

    public void setDate_of_update(Date date_of_update) {
        this.date_of_update = date_of_update;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }
}
