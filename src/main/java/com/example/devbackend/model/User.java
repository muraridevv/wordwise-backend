package com.example.devbackend.model;

import com.example.devbackend.utils.AuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;


@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false,unique = true)
    private String email;

    private String imageUrl;

    @Column(nullable = false)
    private Boolean emailVerified=false;

//    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    private String providerId;

    private String bio;

    private String links;

    private Timestamp createdDate=new Timestamp(System.currentTimeMillis() );

    private Timestamp modifiedDate;

    private String location;

    private String work;

    private String skills;

    @OneToMany
    private List<Posts> posts;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<User> following;

    @OneToMany
    private List<User> followers;

    @OneToMany
    private List<Tag> followedTags;

    @OneToMany
    private List<Posts> bookmarks;
}
