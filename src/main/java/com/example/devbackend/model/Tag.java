package com.example.devbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "tag")
public class Tag extends BaseEntity{

    @Column(nullable = false)
    private String name;

    private Timestamp createdDate=new Timestamp(System.currentTimeMillis());

    private Timestamp modifiedDate=new Timestamp(System.currentTimeMillis());

    @OneToMany
    private List<Posts> posts;

    @OneToMany
    private List<User> followers;
}
