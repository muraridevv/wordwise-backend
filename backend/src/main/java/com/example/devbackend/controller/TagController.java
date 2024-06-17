package com.example.devbackend.controller;

import com.example.devbackend.model.Posts;
import com.example.devbackend.model.Tag;
import com.example.devbackend.repository.TagRepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagRepo tagRepo;

    @GetMapping
    public ResponseEntity<?> getAllPosts(){
        List<Tag> tagList=new ArrayList<>();
        tagList=tagRepo.findAll();
        JSONObject res=new JSONObject();
        res.put("posts",tagList);
        String message="Result fetched successfully";
        return new ResponseEntity<>(tagList, HttpStatus.OK);
    }
}
