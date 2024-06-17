package com.example.devbackend.model;

import jakarta.persistence.*;
import lombok.Data;


import java.sql.Timestamp;
import java.util.List;

@Data
@Entity(name = "posts")
public class Posts extends BaseEntity{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String body;

    @OneToMany
    private List<Tag> tags;

    private String titleURL;

    private Timestamp createdDate;

    private Timestamp modifiedDate;

    @OneToMany
    private List<User> likes;

    @OneToMany
    private List<User> bookmarks;

    @OneToMany
    private List<User> unicorns;

    @OneToMany(targetEntity = Comment.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private List<Comment> comments;

    @OneToOne
    private User author;

}
