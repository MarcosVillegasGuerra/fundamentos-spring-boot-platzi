package com.marcos.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true )
    private Long id;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne
    private User user;

    public Post() {}

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post [description=" + description + ", id=" + id + "]";
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
