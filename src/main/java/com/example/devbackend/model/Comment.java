package com.example.devbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
public class Comment extends BaseEntity{

    private String body;

    private Timestamp createdDate;

    private Timestamp modifiedDate;

    @ManyToOne(optional = false,targetEntity = Posts.class)
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private Posts parentPost;

    @OneToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentId;

    @OneToOne
    private User author;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "like_id", referencedColumnName = "id")
    private List<User> likes;
}
