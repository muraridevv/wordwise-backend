package com.example.devbackend.repository;

import com.example.devbackend.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepo extends JpaRepository<Posts,String> {
    List<Posts> findAll();
}
