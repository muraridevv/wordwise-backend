package com.example.devbackend.repository;

import com.example.devbackend.model.Posts;
import com.example.devbackend.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepo extends JpaRepository<Tag,String> {

//    @Query("select t.name, t.id from Tag t")
    List<Tag> findAll();
}
